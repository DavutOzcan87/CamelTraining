package com.cameltraining.converter;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 4/14/2017.
 */
public class ConverterTest extends CamelBlueprintTestSupport{
    @Override
    public boolean isUseAdviceWith() {
        return true;
    }

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/blueprint.xml";
    }

    @Test
    public void testConvertedCorrectly() throws Exception
    {
        RouteDefinition rd = context.getRouteDefinition("converter_route");
        rd.adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("direct:start");
                //mockEndpoints();
                interceptSendToEndpoint("log:result").to("mock:result");
            }
        });

        MockEndpoint me =  getMockEndpoint("mock:result");
        String resultString = getResultValue();
        me.expectedBodiesReceived(resultString);
        context.start();
        template.sendBody("direct:start" , "test message");
        assertMockEndpointsSatisfied();
    }

    private String getResultValue() {
        return new MyCustomObject("lionel" , 29 , "best player in the world").toString();
    }

    @Test
    public void shouldMockAllEndpoints() throws Exception {
        RouteDefinition rd = context.getRouteDefinition("converter_route");
        rd.adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("direct:start");
                mockEndpoints();
            }
        });

        MockEndpoint me =  getMockEndpoint("mock:log:result");
        String resultString = getResultValue();
        me.expectedBodiesReceived(resultString);
        context.start();
        template.sendBody("direct:start" , "test message");
        assertMockEndpointsSatisfied();
    }


    @Test
    public void shouldMockBeans() throws Exception {
        RouteDefinition rd = context.getRouteDefinition("converter_route");
        rd.adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("direct:start");
                mockEndpoints();
            }
        });

        MockEndpoint me =  getMockEndpoint("mock:log:result");
        String resultString = getResultValue();
        me.expectedBodiesReceived(resultString);
        context.start();
        template.sendBody("direct:start" , "test message");
        assertMockEndpointsSatisfied();
    }
}