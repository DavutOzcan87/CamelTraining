package com.cameltraining.restclient;

import org.apache.camel.Message;

/**
 * Created by davut on 13.04.2017.
 */
public class MessageToStringBean {

    public static String map(Message msg)
    {
        return "@"+msg.getBody().toString();
    }
}
