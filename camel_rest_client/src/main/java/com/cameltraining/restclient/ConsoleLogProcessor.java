package com.cameltraining.restclient;


import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Processor;

import java.util.Map;


/**
 * Created by Lenovo on 4/11/2017.
 */
public class ConsoleLogProcessor implements Processor {
    @Handler
    public void writeToConsole(Exchange exchange)
    {
        System.out.println("\n---------------------\nExchange received:"+System.currentTimeMillis());
        printHeaders(exchange.getIn().getHeaders());
            System.out.println("--Received message--");
            try
            {
                System.out.println("Type of getIn:"+exchange.getIn().getClass().getName());
                System.out.println("Type of body:"+exchange.getIn().getBody().getClass().getName());
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
