package com.asandiego.nc.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"authDetails",
"request"
})
public class ApiRequest {

@JsonProperty("authDetails")
private AuthDetails authDetails;
@JsonProperty("request")
private Request request;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("authDetails")
public AuthDetails getAuthDetails() {
return authDetails;
}

@JsonProperty("authDetails")
public void setAuthDetails(AuthDetails authDetails) {
this.authDetails = authDetails;
}

@JsonProperty("request")
public Request getRequest() {
return request;
}

@JsonProperty("request")
public void setRequest(Request request) {
this.request = request;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}