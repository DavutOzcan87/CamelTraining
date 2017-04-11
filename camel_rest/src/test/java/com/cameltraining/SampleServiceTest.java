package com.cameltraining;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

/**
 * Created by Lenovo on 4/11/2017.
 */
public class SampleServiceTest extends CamelBlueprintTestSupport {

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/blueprint.xml";
    }

    @Test
    public void shouldDoSmthng()
    {
//        fail("NotImplementedYet");
    }
}
