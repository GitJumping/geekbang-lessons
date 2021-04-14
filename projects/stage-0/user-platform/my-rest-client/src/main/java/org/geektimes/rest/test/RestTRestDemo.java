package org.geektimes.rest.test;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class RestTRestDemo {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("").request().get();
    }

    @Test
    public void testPost(){
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8080")
                .request()
                .post(Entity.text(String.class));

        String content = response.readEntity(String.class);
        System.out.println(content);
    }
}
