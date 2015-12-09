/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package com.packtpub.jaxrs.arquilian.demo.service;

import com.packtpub.jaxrs.arquilian.demo.Department;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Jobinesh
 */
@Stateless
@Path("departments")
public class DepartmentResource extends JPAResource<Department> {
    @PersistenceContext(unitName = "HRDBPU")
    private EntityManager em;

    public DepartmentResource() {
        super(Department.class);
    }
    @Override
    @POST
    @Consumes({"application/xml", "application/json"})
    public Department create(Department entity) {
        super.create(entity);
        return entity;
    }
   
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public Department edit(@PathParam("id") Short id, Department entity) {
        return super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Short id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Department find(@PathParam("id") Short id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Department> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Department> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
