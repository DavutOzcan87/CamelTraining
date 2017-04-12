package com.cameltraining;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Lenovo on 4/12/2017.
 */
@XmlRootElement(name = "ClientResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientResponse
{
    @XmlElement(name="status")
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
