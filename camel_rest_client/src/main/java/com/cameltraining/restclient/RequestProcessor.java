package com.cameltraining.restclient;


import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;

/**
 * Created by davut on 13.04.2017.
 */
public class RequestProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.setPattern(ExchangePattern.InOut);
        Message inMessage = exchange.getIn();
        // set the operation name
        inMessage.setHeader(CxfConstants.OPERATION_NAME, "getGeoip");
        // using the proxy client API
        inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.FALSE);

        //creating the request
        String ip = inMessage.getBody(String.class);
        String type = inMessage.getHeader("type",String.class);
        MessageContentsList req = new MessageContentsList();
        req.add(type);
        req.add(ip);
        inMessage.setBody(req);
    }
}
