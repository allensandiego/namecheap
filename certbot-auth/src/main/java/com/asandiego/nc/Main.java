package com.asandiego.nc;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;

import com.asandiego.nc.models.ApiRequest;
import com.asandiego.nc.models.ApiResponse;
import com.asandiego.nc.models.AuthDetails;
import com.asandiego.nc.models.Host;
import com.asandiego.nc.models.Request;
import com.asandiego.nc.models.RequestValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {

    private static String apiUser, apiKey, domain, sld, tld, txt;
    private static String subdomain = "";
    private static String createDomain = "_acme-challenge";
    private static boolean updated = false;

    public static void main(String[] args) throws Exception {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");

        File responseFile = new File(String.format("response-%s.xml",dateFormat.format(date)));
        File requestFile = new File(String.format("resquest-%s.txt",dateFormat.format(date)));

        apiUser = args[0];
        apiKey = args[1];
        domain = args[2];
        txt = args[3];

        String[] s = domain.split("\\.");

        for (int i = s.length - 1; i >= 0; i--) {
            if (i == s.length - 1) {
                tld = s[i];
            } else if (i == s.length - 2) {
                sld = s[i];
            } else {
                subdomain = s[i] + "." + subdomain;
            }
        }

        subdomain = StringUtils.stripEnd(subdomain, ".");

        if (!subdomain.equals("*")) {
            createDomain = String.format("%s.%s", createDomain, subdomain);
            createDomain = StringUtils.stripEnd(createDomain, ".");
        }

        Host createHost = new Host();
        createHost.setType("TXT");
        createHost.setName(createDomain);
        createHost.setAddress(txt);
        createHost.setTTL("1800");
        createHost.setIsActive("true");

        URI getUri = new URIBuilder("https://api.namecheap.com/xml.response")
                .addParameter("ApiUser", apiUser)
                .addParameter("ApiKey", apiKey)
                .addParameter("UserName", apiUser)
                .addParameter("clientIP", "0.0.0.0")
                .addParameter("Command", "namecheap.domains.dns.getHosts")
                .addParameter("SLD", sld)
                .addParameter("TLD", tld)
                .build();

        HttpRequest get = HttpRequest.newBuilder()
                .uri(getUri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = client.send(get, BodyHandlers.ofString());
        System.out.println(httpResponse.body());

        XmlMapper mapper = new XmlMapper();
        ApiResponse apiResponse = mapper.readValue(httpResponse.body(), ApiResponse.class);

        if (apiResponse.getStatus().equals("ERROR")) {
            StringBuilder builder = new StringBuilder();
            List<com.asandiego.nc.models.Error> errors = apiResponse.getErrors();
            for (int i = 0; i < errors.size(); i++) {
                builder.append(errors.get(i).getValue());
            }
            System.out.println(builder.toString());
            System.exit(1);
        }

        mapper.writeValue(responseFile, apiResponse);

        List<Host> hosts = apiResponse.getCommandResponse().getDomainDNSGetHostsResult().getHosts();

        for (int i = 0; i < hosts.size(); i++) {
            String name = hosts.get(i).getName();
            String type = hosts.get(i).getType();

            if (name.equals(createDomain) && type.equals("TXT")) {
                hosts.set(i, createHost);
                updated = true;
            }
        }

        if (updated == false) {
            hosts.add(createHost);
        }

        List<String> keyList = Arrays.asList("HostName", "RecordType", "Address", "TTL");
        List<RequestValue> requestValues = new ArrayList<>();

        for (int i = 0; i < hosts.size(); i++) {
            for (int j = 0; j < keyList.size(); j++) {
                if (keyList.get(j).equals("HostName")) {
                    requestValues.add(new RequestValue(keyList.get(j) + (i + 1), hosts.get(i).getName()));
                }
                if (keyList.get(j).equals("RecordType")) {
                    requestValues.add(new RequestValue(keyList.get(j) + (i + 1), hosts.get(i).getType()));
                }
                if (keyList.get(j).equals("Address")) {
                    requestValues.add(new RequestValue(keyList.get(j) + (i + 1), hosts.get(i).getAddress()));
                }
                if (keyList.get(j).equals("TTL")) {
                    requestValues.add(new RequestValue(keyList.get(j) + (i + 1), hosts.get(i).getTTL()));
                }
            }
        }

        URIBuilder builder = new URIBuilder("https://api.namecheap.com/xml.response")
        .addParameter("ApiUser", apiUser)
        .addParameter("ApiKey", apiKey)
        .addParameter("UserName", apiUser)
        .addParameter("clientIP", "0.0.0.0")
        .addParameter("Command", "namecheap.domains.dns.setHosts")
        .addParameter("SLD", sld)
        .addParameter("TLD", tld);

        for (int i = 0; i < requestValues.size(); i++) {
            builder.addParameter(requestValues.get(i).getKey(), requestValues.get(i).getValue());
        }

        URI postUri = builder.build();

        FileOutputStream os = new FileOutputStream(requestFile);
        os.write(postUri.toString().replaceFirst("\\bApiKey=.*?(&|$)", "ApiKey=***&").getBytes());
        os.flush();
        os.close();

        HttpRequest post = HttpRequest.newBuilder()
                .uri(postUri)
                .GET()
                .build();

        HttpResponse<String> postResponse = client.send(post, BodyHandlers.ofString());

        System.out.println(postResponse.body());
    }

}