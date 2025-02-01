package com.asandiego.nc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandResponse {

    @JsonProperty("DomainDNSGetHostsResult")
    private DomainDNSGetHostsResult domainDNSGetHostsResult;
    
    @JsonProperty("Type")
    private String type;

    public DomainDNSGetHostsResult getDomainDNSGetHostsResult() { return domainDNSGetHostsResult; }
    public void setDomainDNSGetHostsResult(DomainDNSGetHostsResult value) { this.domainDNSGetHostsResult = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }
    
}
