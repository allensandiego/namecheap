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
"ParentUserType",
"ParentUserId",
"UserId",
"UserName",
"ClientIp",
"EndUserIp",
"AdminUserName",
"DisableSecurityNotification",
"AllowWhenDomainLocked",
"ProceedWhenDomainLockedFlag",
"DefaultChargeForUserName",
"Roles"
})
public class AuthDetails {

@JsonProperty("ParentUserType")
private String parentUserType;
@JsonProperty("ParentUserId")
private Integer parentUserId;
@JsonProperty("UserId")
private String userId;
@JsonProperty("UserName")
private String userName;
@JsonProperty("ClientIp")
private String clientIp;
@JsonProperty("EndUserIp")
private String endUserIp;
@JsonProperty("AdminUserName")
private String adminUserName;
@JsonProperty("DisableSecurityNotification")
private Boolean disableSecurityNotification;
@JsonProperty("AllowWhenDomainLocked")
private Boolean allowWhenDomainLocked;
@JsonProperty("ProceedWhenDomainLockedFlag")
private Boolean proceedWhenDomainLockedFlag;
@JsonProperty("DefaultChargeForUserName")
private String defaultChargeForUserName;
@JsonProperty("Roles")
private List<String> roles;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("ParentUserType")
public String getParentUserType() {
return parentUserType;
}

@JsonProperty("ParentUserType")
public void setParentUserType(String parentUserType) {
this.parentUserType = parentUserType;
}

@JsonProperty("ParentUserId")
public Integer getParentUserId() {
return parentUserId;
}

@JsonProperty("ParentUserId")
public void setParentUserId(Integer parentUserId) {
this.parentUserId = parentUserId;
}

@JsonProperty("UserId")
public String getUserId() {
return userId;
}

@JsonProperty("UserId")
public void setUserId(String userId) {
this.userId = userId;
}

@JsonProperty("UserName")
public String getUserName() {
return userName;
}

@JsonProperty("UserName")
public void setUserName(String userName) {
this.userName = userName;
}

@JsonProperty("ClientIp")
public String getClientIp() {
return clientIp;
}

@JsonProperty("ClientIp")
public void setClientIp(String clientIp) {
this.clientIp = clientIp;
}

@JsonProperty("EndUserIp")
public String getEndUserIp() {
return endUserIp;
}

@JsonProperty("EndUserIp")
public void setEndUserIp(String endUserIp) {
this.endUserIp = endUserIp;
}

@JsonProperty("AdminUserName")
public String getAdminUserName() {
return adminUserName;
}

@JsonProperty("AdminUserName")
public void setAdminUserName(String adminUserName) {
this.adminUserName = adminUserName;
}

@JsonProperty("DisableSecurityNotification")
public Boolean getDisableSecurityNotification() {
return disableSecurityNotification;
}

@JsonProperty("DisableSecurityNotification")
public void setDisableSecurityNotification(Boolean disableSecurityNotification) {
this.disableSecurityNotification = disableSecurityNotification;
}

@JsonProperty("AllowWhenDomainLocked")
public Boolean getAllowWhenDomainLocked() {
return allowWhenDomainLocked;
}

@JsonProperty("AllowWhenDomainLocked")
public void setAllowWhenDomainLocked(Boolean allowWhenDomainLocked) {
this.allowWhenDomainLocked = allowWhenDomainLocked;
}

@JsonProperty("ProceedWhenDomainLockedFlag")
public Boolean getProceedWhenDomainLockedFlag() {
return proceedWhenDomainLockedFlag;
}

@JsonProperty("ProceedWhenDomainLockedFlag")
public void setProceedWhenDomainLockedFlag(Boolean proceedWhenDomainLockedFlag) {
this.proceedWhenDomainLockedFlag = proceedWhenDomainLockedFlag;
}

@JsonProperty("DefaultChargeForUserName")
public String getDefaultChargeForUserName() {
return defaultChargeForUserName;
}

@JsonProperty("DefaultChargeForUserName")
public void setDefaultChargeForUserName(String defaultChargeForUserName) {
this.defaultChargeForUserName = defaultChargeForUserName;
}

@JsonProperty("Roles")
public List<String> getRoles() {
return roles;
}

@JsonProperty("Roles")
public void setRoles(List<String> roles) {
this.roles = roles;
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