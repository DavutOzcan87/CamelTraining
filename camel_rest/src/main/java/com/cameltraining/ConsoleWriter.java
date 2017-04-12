package com.cameltraining;


import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Processor;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Map;


/**
 * Created by Lenovo on 4/11/2017.
 */
public class ConsoleWriter implements Processor {
    @Handler
    public void writeToConsole(Exchange exchange)
    {
        System.out.println("Exchange received:"+System.currentTimeMillis());
        printHeaders(exchange.getIn().getHeaders());
            System.out.println("--Received message--");
            try {
                System.out.println("body:"+exchange.getIn().getBody(String.class));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    private void printHeaders(Map<String, Object> headers) {
        try {
            System.out.println("Headers");
            for (String key:headers.keySet()){
                System.out.println(key+"="+headers.get(key).toString());
            }
        }catch (Exception e)
        {
            //e.printStackTrace();
        }
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        writeToConsole(exchange);
    }
}
