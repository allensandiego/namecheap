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
"Key",
"Value"
})
public class RequestValue {

@JsonProperty("Key")
private String key;
@JsonProperty("Value")
private String value;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

public RequestValue(String key, String value) {
    this.key = key;
    this.value = value;
}

@JsonProperty("Key")
public String getKey() {
return key;
}

@JsonProperty("Key")
public void setKey(String key) {
this.key = key;
}

@JsonProperty("Value")
public String getValue() {
return value;
}

@JsonProperty("Value")
public void setValue(String value) {
this.value = value;
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