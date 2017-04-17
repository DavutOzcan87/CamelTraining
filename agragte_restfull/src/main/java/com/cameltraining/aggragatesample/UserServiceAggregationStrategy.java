package com.cameltraining.aggragatesample;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Created by Lenovo on 4/17/2017.
 */
public class UserServiceAggregationStrategy  implements AggregationStrategy{

//    public String concat(String oldString , String newString)
//    {
//        if(oldString == null)
//            return newString;
//        return oldString+" "+newString;
//    }

    @Override
    public Exchange aggregate(Exchange old, Exchange neww) {
        if(old == null)
            return neww;
        String finalResult = old.getIn().getBody(String.class) + neww.getIn().getBody(String.class);
        neww.getIn().setBody(finalResult);
        return neww;
    }
}
