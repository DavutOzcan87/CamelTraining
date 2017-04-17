package com.cameltraining.aggragatesample;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

/**
 * Created by Lenovo on 4/17/2017.
 */
public class UserServiceRequestNormalizer implements Processor {

    public static final String CORRELATION_ID = "correlationId";
    public static final String COMPLETION_SIZE = "completionSize";

    @Override
    public void process(Exchange exchange) throws Exception {
        MessageContentsList data = (MessageContentsList) exchange.getIn().getBody();
        String name = (String) data.get(0);
        int sequence = Integer.parseInt((String) data.get(1));
        String message = (String) data.get(2);
        exchange.getIn().setHeader(CORRELATION_ID,name );
        exchange.getIn().setHeader(COMPLETION_SIZE,sequence );
        exchange.getIn().setBody(message);
    }
}
