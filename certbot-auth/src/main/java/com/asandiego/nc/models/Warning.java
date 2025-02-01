package com.asandiego.nc.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Warning {

    @JacksonXmlProperty(isAttribute = true, localName = "Number")
    private String number;

    @JacksonXmlProperty
    private String value;
    
}
