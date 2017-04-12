package com.cameltraining;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import javax.jms.*;
import java.lang.IllegalStateException;

/**
 * Created by Lenovo on 4/12/2017.
 */
public class JmsMessageToStringConverter implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Object body =  exchange.getIn().getBody();

        if(!(body instanceof Message))
            throw new IllegalStateException("Only Jms messages converted");
        //exchange.getIn().setBody (((Message)body).get);
    }
}
