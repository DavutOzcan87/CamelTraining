package com.cameltraining.converter;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConverters;

/**
 * Created by Lenovo on 4/13/2017.
 */


public class HeaderConverter implements TypeConverters
{
    @Converter
    public MyCustomObject convert(String data ,Exchange exchange)
    {
        String values = (String) exchange.getIn().getHeader("customheader");
        String [] splitted = values.split("-");
        return new MyCustomObject(splitted[0] , Integer.parseInt(splitted[1]) , splitted[2]);
    }
}
