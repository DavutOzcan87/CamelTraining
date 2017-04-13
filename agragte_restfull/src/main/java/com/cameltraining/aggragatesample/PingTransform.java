package com.cameltraining.aggragatesample;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

/**
 * Created by Lenovo on 4/13/2017.
 */
public class PingTransform implements Processor{


    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.setPattern(ExchangePattern.InOut);
        String value = exchange.getIn().getBody(String.class);
        MessageContentsList req = new MessageContentsList();
        req.add(value);
        exchange.getIn().setBody(req);
    }
}
