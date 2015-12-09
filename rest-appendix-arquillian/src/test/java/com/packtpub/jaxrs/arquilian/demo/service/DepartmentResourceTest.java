/*
 * Copyright Â© 2015 Oracle  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.jaxrs.arquilian.demo.service;

import com.packtpub.jaxrs.arquilian.demo.Department;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Jobinesh
 */
@RunWith(Arquillian.class)
public class DepartmentResourceTest {

    public DepartmentResourceTest() {
    }

    @Deployment(testable=true)
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class, "rest-appendix-arquillian.war")
                .addClasses(Department.class, ApplicationConfig.class,
                        JPAResource.class, DepartmentResource.class)
                .addAsWebInfResource("test-web.xml", "web.xml")
                .addAsResource("test-persistence.xml",
                        "META-INF/persistence.xml");
    }

    @Test
    @InSequence(1)
    public void testAddDept() {
        WebTarget target = ClientBuilder.newClient()
                .target("http://localhost:28080/rest-appendix-arquillian/api/departments");
        // Save a new bid.
        Department dept = new Department();

        dept.setDepartmentId(new Short((short) 10));
        dept.setDepartmentName("HR");
        dept = target.request("application/json").post(Entity.json(dept), Department.class);
        Department deptToVerify = target.path("{id}").resolveTemplate("id", 10)
                .request("application/json").get(Department.class);

        assertEquals("HR", deptToVerify.getDepartmentName());
    }

    @Test
    @InSequence(2)
    public void testEditDept() {
        WebTarget target = ClientBuilder.newClient()
                .target("http://localhost:28080/rest-appendix-arquillian/api/departments");
        Department dept = target.path("{id}").resolveTemplate("id", 10)
                .request("application/json").get(Department.class);
        dept.setDepartmentName("IT");
        dept = target.path("{id}").resolveTemplate("id", 10).request("application/json").put(Entity.json(dept), Department.class);
        Department deptToVerify = target.path("{id}").resolveTemplate("id", 10)
                .request("application/json").get(Department.class);

        assertEquals("IT", deptToVerify.getDepartmentName());
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

}
