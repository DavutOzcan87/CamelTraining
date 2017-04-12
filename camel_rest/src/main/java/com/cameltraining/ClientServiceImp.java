package com.cameltraining;

/**
 * Created by Lenovo on 4/12/2017.
 */
public class ClientServiceImp implements ClientService {
    @Override
    public void ping(ClientResponse response)
    {
        System.out.println("--Ping method--");
        if(response != null)
            print(response);
    }

    private void print(ClientResponse response) {
        System.out.println("Response recevied");
        System.out.println("Status :"+response.getStatus());
    }
}
