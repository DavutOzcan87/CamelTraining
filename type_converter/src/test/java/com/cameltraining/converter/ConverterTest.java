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



    @Before
    public void before() throws Exception {

    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        return new DefaultCamelContext();
    }

    @Test
    public void testConvertedCorrectly() throws Exception
    {
        RouteDefinition rd = context.getRouteDefinition("converter_route");
        rd.adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("direct:start");
                mockEndpoints();
            }
        });
        context.start();

        getMockEndpoint("mock:log").expectedBodiesReceived("test");
        System.err.println("Sending body to mock timer");
        template.sendBody("direct:start" , "");
        assertMockEndpointsSatisfied();
    }
}