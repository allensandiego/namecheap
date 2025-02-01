package com.asandiego.nc.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {

    @JsonProperty("Errors")
    private List<Error> errors;

    @JsonProperty("Warnings")
    private List<Warning> warnings;

    @JsonProperty("RequestedCommand")
    private String requestedCommand;

    @JsonProperty("CommandResponse")
    private CommandResponse commandResponse;

    @JsonProperty("Server")
    private String server;
    
    @JsonProperty("GMTTimeDifference")
    private String gmtTimeDifference;
    
    @JsonProperty("ExecutionTime")
    private String executionTime;
    
    private String xmlns;
    
    @JsonProperty("Status")
    private String status;

    public List<Error> getErrors() { return errors; }
    public void setErrors(List<Error> value) { this.errors = value; }

    public List<Warning> getWarnings() { return warnings; }
    public void setWarnings(List<Warning> value) { this.warnings = value; }

    public String getRequestedCommand() { return requestedCommand; }
    public void setRequestedCommand(String value) { this.requestedCommand = value; }

    public CommandResponse getCommandResponse() { return commandResponse; }
    public void setCommandResponse(CommandResponse value) { this.commandResponse = value; }

    public String getServer() { return server; }
    public void setServer(String value) { this.server = value; }

    public String getGmtTimeDifference() { return gmtTimeDifference; }
    public void setGmtTimeDifference(String value) { this.gmtTimeDifference = value; }

    public String getExecutionTime() { return executionTime; }
    public void setExecutionTime(String value) { this.executionTime = value; }

    public String getXmlns() { return xmlns; }
    public void setXmlns(String value) { this.xmlns = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

}

