/*
 * Copyright © 2015 Packt Publishing   - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.appendix.patch.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.packtpub.rest.appendix.patch.demo.model.Department;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Department Resource class
 * @author Jobinesh
 */
@Stateless
@Path("departments")
public class DepartmentResource extends JPAResource<Department> {

    @PersistenceContext(unitName = "HR-PU")
    private EntityManager em;

    public DepartmentResource() {
        super(Department.class);
    }

    @PATCH
    @Path("{id}")
    @Consumes({("application/json-patch+json")})
    public Response patch(@PathParam("id") Short id, String deptUpdatesInJSON) {
        // get the dept from DB
        Department dept = super.find(id);;

        try {
            if (dept != null) {
                //The mapper (or, data binder, or codec) provides 
                //functionality for converting between Java objects 
                //and matching JSON constructs.
                ObjectMapper mapper = new ObjectMapper();

                // convert JSON string to a Java class
                //JsonPatch is here https://github.com/fge/json-patch
                JsonPatch patch = mapper.readValue(deptUpdatesInJSON, JsonPatch.class);
                // convert Dept to a JSON object
                JsonNode userJson = mapper.valueToTree(dept);
                // apply patch
                JsonNode patched = patch.apply(userJson);
                // convert the patched object to Dept
                dept = mapper.readValue(patched.toString(), Department.class);
                // save the patched object
                save(dept);
            }else{
               return  Response.serverError().status(Status.NOT_FOUND).build();
            }
        } catch (Exception ex) {
            throw new WebApplicationException(ex);
        }
        return Response.ok().build();

    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Department findDepartment(@PathParam("id") Short id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Department> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
