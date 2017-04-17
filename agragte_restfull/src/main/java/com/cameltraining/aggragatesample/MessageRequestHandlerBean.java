package com.cameltraining.aggragatesample;

import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.MessageContentsList;

/**
 * Created by Lenovo on 4/17/2017.
 */
public class MessageRequestHandlerBean {

    public String reply(MessageContentsList request , Exchange exchange)
    {
        return "ReplyFrom Bean";
    }
}
