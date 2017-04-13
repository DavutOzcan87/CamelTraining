package com.cameltraining.converter;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConverters;

/**
 * Created by Lenovo on 4/13/2017.
 */


public class HeaderConverter implements TypeConverters{
    @Converter
    public MyCustomObject convert(String data ,Exchange exchange)
    {
        return new MyCustomObject("test" , 20 , "testmsg");

    }

//    @Converter
//    public static MyCustomObject convert2(String data ,Exchange exchange)
//    {
//        return new MyCustomObject("test" , 20 , "testmsg");
//
//    }
}
