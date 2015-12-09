/*
 * Copyright © 2015 Packt Publishing   - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package com.packtpub.rest.appendix.patch.demo.service;

import java.io.IOException;
import java.util.Collections;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Jobinesh
 */
@Provider
public class OptionsAcceptHeader implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
            ContainerResponseContext responseContext) throws IOException {

        if ("OPTIONS".equals(requestContext.getMethod())) {
            if (responseContext.getHeaderString("Accept-Patch") == null) {
                responseContext.getHeaders().put(
                        "Accept-Patch", Collections.<Object>singletonList("application/json-patch+json"));
            }
        }
    }
}
