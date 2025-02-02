package com.asandiego.nc;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;

import com.asandiego.nc.models.ApiResponse;
import com.asandiego.nc.models.Host;
import com.asandiego.nc.models.RequestValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Recover {

    private static String sld;
    private static String tld;

    public static void main (String[] args) throws JsonParseException, JsonMappingException, IOException, URISyntaxException, InterruptedException {

        String apiUser = args[0];
        String apiKey = args[1];
        String domain = args[2];
        String responseFile = args[3];

        String[] s = domain.split("\\.");

        for (int i = s.length - 1; i >= 0; i--) {
            if (i == s.length - 1) {
                tld = s[i];
            } else if (i == s.length - 2) {
                sld = s[i];
            }
        }

        File responseXML = new File(responseFile);
        
        if (!responseXML.exists()) {
            System.out.println("File not found.");
            System.exit(1);
        }

        XmlMapper mapper = new XmlMapper();
        ApiResponse response = mapper.readValue(responseXML, ApiResponse.class);

        List<Host> hosts =  response.getCommandResponse().getDomainDNSGetHostsResult().getHosts();
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

        HttpRequest post = HttpRequest.newBuilder()
                .uri(postUri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = client.send(post, BodyHandlers.ofString());

        System.out.println(postResponse);
    }
}
