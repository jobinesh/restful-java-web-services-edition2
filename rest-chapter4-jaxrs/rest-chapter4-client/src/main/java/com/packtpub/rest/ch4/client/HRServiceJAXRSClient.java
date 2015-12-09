/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.ch4.client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;

/**
 * JAX-RS REST client generated for REST resource:HRService [hr]<br>
 *
 *
 * @author Jobinesh
 */
public class HRServiceJAXRSClient {

    private static final String BASE_URI = "http://localhost:28080/rest-chapter4-service/webresources";

    public HRServiceJAXRSClient() {

    }

    public void create(Object requestEntity) throws ClientErrorException {
        Client client = javax.ws.rs.client.ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URI).path("hr");
        Form form = new Form();
        form.param("departmentId", "101");
        form.param("departmentName", "Revenue");
        webTarget.path("departments").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(form, javax.ws.rs.core.MediaType.APPLICATION_JSON));
        client.close();
    }

    public static void main(String arg[]) {

    }

}
