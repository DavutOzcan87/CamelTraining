package com.cameltraining;

import static com.cameltraining.ServiceResponse.of;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * Created by Lenovo on 4/11/2017.
 */
public class SampleServiceImp implements ISampleService{
    public SampleServiceImp() {
    }

    public ServiceResponse greet(String name) {
        String result = "Hello "+name;
        System.out.println("writing to amq:"+result);
        try {
            toAmq(result);
            return of(result);
        }catch (Exception e)
        {
            return of(e.getMessage());
        }
    }

    private void toAmq(String result) throws JMSException
    {
            //created ConnectionFactory object for creating connection
            ConnectionFactory factory = new ActiveMQConnectionFactory("Username", "Password", "tcp://localhost:61616");
            //Establish the connection
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("servicedata:greeting");
            //Added as a producer
            javax.jms.MessageProducer producer = session.createProducer(queue);
            // Create and send the message
            TextMessage msg = session.createTextMessage();
            msg.setText(result);
            producer.send(msg);


    }
}
