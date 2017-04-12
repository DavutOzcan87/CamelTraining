package com.cameltraining;

import javax.xml.bind.annotation.*;

/**
 * Created by Lenovo on 4/11/2017.
 */
@XmlRootElement(name = "ServiceResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceResponse {
    public ServiceResponse() {

    }

    @XmlElement(name = "message")
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ServiceResponse of(String message)
    {
        ServiceResponse resp = new ServiceResponse();
        resp.setMsg(message);
        return resp;
    }
}
