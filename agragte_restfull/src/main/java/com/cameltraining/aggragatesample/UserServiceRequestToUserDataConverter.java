package com.cameltraining.aggragatesample;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConverters;
import org.apache.cxf.message.MessageContentsList;

/**
 * Created by Lenovo on 4/14/2017.
 */
public class UserServiceRequestToUserDataConverter implements TypeConverters {

    @Converter
    public UserData convert(MessageContentsList data , Exchange exchange)
    {
        String name = (String) data.get(0);
        int sequence = Integer.parseInt((String) data.get(1));
        String message = (String) data.get(2);
        return new UserData(name,sequence,message);
    }
}
