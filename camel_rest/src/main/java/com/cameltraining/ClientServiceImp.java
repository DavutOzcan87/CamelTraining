package com.cameltraining;

/**
 * Created by Lenovo on 4/12/2017.
 */
public class ClientServiceImp implements ClientService {
    @Override
    public ClientResponse ping()
    {
        System.out.println("--Ping method--");
        return null;
    }

    private void print(ClientResponse response) {
        System.out.println("Response recevied");
        System.out.println("Status :"+response.getStatus());
    }
}
