package com.cameltraining.aggragatesample;

import org.apache.camel.*;
import org.apache.cxf.message.MessageContentsList;

/**
 * Created by Lenovo on 4/17/2017.
 */
public class MessageRequestHandlerBean {



    public String reply(MessageContentsList request , Exchange exchange) throws Exception
    {
        String id = null;
        try
        {
            id = request.get(0).toString();
            CamelContext context =  exchange.getContext();
            ConsumerTemplate consumer = context.createConsumerTemplate();
            String uri = "amq:aggregatedMessages?selector=correlationId%3D'"+id+"'";
            Exchange exc = consumer.receive( uri, 5000);
            if(exc == null)
                return String.format("No record found for id=%s",id);
            return exc.getIn().getBody().toString();
        }catch(Exception e)
        {
            return String.format("Error:%s",e.getMessage());
        }

    }
}
