package com.asandiego.nc.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DomainDNSGetHostsResult {

    @JacksonXmlProperty(localName = "host")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Host> hosts = new ArrayList<>();
    
    @JsonProperty("Domain")
    private String domain;

    @JsonProperty("EmailType")
    private String emailType;

    @JsonProperty("IsUsingOurDNS")
    private String isUsingOurDNS;

    public List<Host> getHosts() { return hosts; }
    public void setHosts(List<Host> value) { this.hosts = value; }

    public String getDomain() { return domain; }
    public void setDomain(String value) { this.domain = value; }

    public String getEmailType() { return emailType; }
    public void setEmailType(String value) { this.emailType = value; }

    public String getIsUsingOurDNS() { return isUsingOurDNS; }
    public void setIsUsingOurDNS(String value) { this.isUsingOurDNS = value; }
}
