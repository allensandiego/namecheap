package com.asandiego.nc.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"RequestValues",
"SLD",
"TLD"
})
public class Request {

@JsonProperty("RequestValues")
private List<RequestValue> requestValues;
@JsonProperty("SLD")
private String sld;
@JsonProperty("TLD")
private String tld;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

public Request(List<RequestValue> requestValues) {
    this.requestValues = requestValues;
}

@JsonProperty("RequestValues")
public List<RequestValue> getRequestValues() {
return requestValues;
}

@JsonProperty("RequestValues")
public void setRequestValues(List<RequestValue> requestValues) {
this.requestValues = requestValues;
}

@JsonProperty("SLD")
public String getSld() {
return sld;
}

@JsonProperty("SLD")
public void setSld(String sld) {
this.sld = sld;
}

@JsonProperty("TLD")
public String getTld() {
return tld;
}

@JsonProperty("TLD")
public void setTld(String tld) {
this.tld = tld;
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