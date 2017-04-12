package com.cameltraining.restclient;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by davut on 12.04.2017.
 */
public class RecurringJobBean implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(""+System.currentTimeMillis());
    }
}
