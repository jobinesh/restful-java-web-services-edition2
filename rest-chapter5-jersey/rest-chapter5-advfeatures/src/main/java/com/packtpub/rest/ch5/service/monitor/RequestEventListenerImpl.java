/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.ch5.service.monitor;

import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;

/**
 * Non-registrable provider that listens to request events. The implementation
 * of the interface will be called for request events when they occur. The
 * provider cannot be registered as a standard JAX-RS or Jersey provider. The
 * instance of the RequestEventListener must be returned from the
 * ApplicationEventListener.onRequest(RequestEvent). This will register the
 * instance for listening of request events for one particular request. Once the
 * processing of the request is finished, the instance will be ignored by the
 * Jersey runtime and not used for processing of further requests.
 *
 * @author Jobinesh
 */
public class RequestEventListenerImpl implements RequestEventListener {

    @Override
    public void onEvent(RequestEvent event) {
        switch (event.getType()) {
            case RESOURCE_METHOD_START:
                System.out.println("Resource method "
                        + event.getUriInfo().getMatchedResourceMethod()
                        .getHttpMethod()
                        + " started for request ");
                break;
            case FINISHED:
                System.out.println("Request "
                        + " finished. ");
                break;
        }
    }

}
