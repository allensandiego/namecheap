package com.asandiego.nc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Host {

    @JsonProperty("HostId")
    private String hostID;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("MXPref")
    private String mxPref;

    @JsonProperty("TTL")
    private String ttl;

    @JsonProperty("AssociatedAppTitle")
    private String associatedAppTitle;

    @JsonProperty("FriendlyName")
    private String friendlyName;

    @JsonProperty("IsActive")
    private String isActive;

    @JsonProperty("IsDDNSEnabled")
    private String isDDNSEnabled;

    public String getHostID() { return hostID; }
    public void setHostID(String value) { this.hostID = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public String getAddress() { return address; }
    public void setAddress(String value) { this.address = value; }

    public String getMXPref() { return mxPref; }
    public void setMXPref(String value) { this.mxPref = value; }

    public String getTTL() { return ttl; }
    public void setTTL(String value) { this.ttl = value; }

    public String getAssociatedAppTitle() { return associatedAppTitle; }
    public void setAssociatedAppTitle(String value) { this.associatedAppTitle = value; }

    public String getFriendlyName() { return friendlyName; }
    public void setFriendlyName(String value) { this.friendlyName = value; }

    public String getIsActive() { return isActive; }
    public void setIsActive(String value) { this.isActive = value; }

    public String getIsDDNSEnabled() { return isDDNSEnabled; }
    public void setIsDDNSEnabled(String value) { this.isDDNSEnabled = value; }
}
