/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.ch5.service;

import com.packtpub.rest.ch5.model.SystemInfo;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.process.Inflector;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceMethod;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ServerProperties;
/*
 * This demonstartes use of ResourceConfig to configure dynamic resources during deploymnent
 * @author Jobinesh
 */

@Provider
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends ResourceConfig {

    private static final Logger logger = Logger.getLogger(ApplicationConfig.class.getName());

    public ApplicationConfig(@Context ServletContext context) {
        //Sepcify server side configuration properties
        property(ServerProperties.SUBRESOURCE_LOCATOR_CACHE_SIZE, 1000);
        property(ServerProperties.SUBRESOURCE_LOCATOR_CACHE_AGE, 60 * 10);

        //Registers specifc components
        register(MultiPartFeature.class);
        register(LoggingFilter.class);

        packages("com.packtpub.rest.ch5");
        // Add resource during deployment conditionally
        String configSysInfoParam = context.getInitParameter("system.info.allow");
        boolean allowViewServerInfo = (configSysInfoParam == null) ? false : Boolean.valueOf(configSysInfoParam);
        logger.info("Properties: " + configSysInfoParam);

        if (allowViewServerInfo) {
            /**
             * Add resource to return server information during deployment
             */
            Resource.Builder resourceBuilder = Resource.builder();
            resourceBuilder.path("server/info");
            ResourceMethod.Builder methodBuilder = resourceBuilder.addMethod("GET");
            methodBuilder.produces(MediaType.APPLICATION_JSON)
                    .handledBy(new Inflector<ContainerRequestContext, SystemInfo>() {
                        @Override
                        public SystemInfo apply(ContainerRequestContext containerRequestContext) {
                            return SystemInfo.getInstance();
                        }
                    });

            Resource resource = resourceBuilder.build();
            registerResources(resource);
        }

    }

}
