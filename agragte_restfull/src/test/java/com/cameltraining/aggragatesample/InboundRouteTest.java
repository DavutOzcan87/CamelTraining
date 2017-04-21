package com.cameltraining.aggragatesample;

import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.camel.util.KeyValueHolder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.message.MessageContentsList;
import org.junit.Before;
import org.junit.Test;
import org.osgi.service.http.HttpService;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Lenovo on 4/13/2017.
 */
public class InboundRouteTest extends CamelBlueprintTestSupport {
    public static final String INBOUND_ROUTE_ID = "inbound-route";
    public static final String ANYMESSAGE = "anymessage";
    public static final String ANYID = "anyid";
    public static final int ANY_COUNT = 1;
    private RouteDefinition routeDefinition;

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/blueprint.xml";
    }

    @Before
    public void before()
    {
        this.routeDefinition = context.getRouteDefinition(INBOUND_ROUTE_ID);
    }


    @Override
    public boolean isUseAdviceWith() {
        return true;
    }
    private static final String URL = "http://localhost/8484/userservice/user";

    @Test
    public void shouldReturnResultWhenWebRequestReceives() throws Exception {
        routeDefinition.adviceWith(context, new AdviceWithRouteBuilder()
        {
            @Override
            public void configure() throws Exception
            {
                replaceFromWith("direct:start");
            }
        });
        context.start();
        MessageContentsList data = getWebRequestData(ANYID, ANY_COUNT, ANYMESSAGE);
        String result = (String) template.requestBody("direct:start",data );
        assertThat(result , equalTo("OK"));
    }

    @Test
    public void shouldSendTransformedValueToAggregation() throws Exception {
        final String mockAggregationEndPointUri = "mock:mockaggregation";
        routeDefinition.adviceWith(context, new AdviceWithRouteBuilder()
        {
            @Override
            public void configure() throws Exception
            {
                replaceFromWith("direct:start");
                weaveById("aggreageteWireTab").
                        replace().
                        to(mockAggregationEndPointUri);
            }
        });
        getMockEndpoint(mockAggregationEndPointUri).expectedBodiesReceived(ANYMESSAGE);
        getMockEndpoint(mockAggregationEndPointUri).expectedHeaderReceived(UserServiceRequestNormalizer.CORRELATION_ID , ANYID);
        getMockEndpoint(mockAggregationEndPointUri).expectedHeaderReceived(UserServiceRequestNormalizer.COMPLETION_SIZE , ANY_COUNT);
        context.start();
        MessageContentsList data = getWebRequestData(ANYID, ANY_COUNT, ANYMESSAGE);
        String result = (String) template.requestBody("direct:start",data );
        assertMockEndpointsSatisfied();
    }

    private MessageContentsList getWebRequestData(String id , int count , String message) {
        MessageContentsList data =  new MessageContentsList();
        data.add(id);
        data.add(count+"");
        data.add(message);
        return data;
    }
}