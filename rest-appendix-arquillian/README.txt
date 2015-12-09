Code Samples for Appendix section of the book
==========================
This file contains instructions for running project **rest-appendix-arquillian** associated with  Appendix section of of RESTful Java Web Services.
This example demonstrates how to use Arquillian for integration testing JAX-RS.
This sample is inspired by the tutorial available at: https://github.com/m-reza-rahman/testing-javaee

General instructions
--------------------
The examples used in this book are built using the following:

- Java SE Development Kit 8
- NetBeans IDE 8.0.2 
- Glassfish Server 4.1 or newer
- Maven 3.2.3. 
- Oracle Database 11.2 Express Edition or higher (Example uses HR Schema)

Dependencies
-------------------
This example uses jboss public repository for arquillian jars
<repository>
    <id>jboss-public-repository-group</id>
    <url>https://repository.jboss.org/nexus/content/groups/public-jboss/</url>
</repository>

Setup GlassFish container for running integration tests
-------------------------------------------------------
* Install GlassFish 4.1. You can download it from here [https://glassfish.java.net/download.html](https://glassfish.java.net/download.html)
* The demo is just a simple Maven project under the [rest-appendix-arquillian](rest-appendix-arquillian)
  directory. You should be able to open it up in any Maven capable IDE, we used
  NetBeans.
* The tests in the Maven build are executed against an installed GlassFish instance.
   For details on configuring GlassFish for 
  Arquillian, look [https://docs.jboss.org/author/display/ARQ/GlassFish+3.1+-+Managed](https://docs.jboss.org/author/display/ARQ/GlassFish+3.1+-+Managed). 
   Note that in this case we are using GlassFish in managed mode. This means that
   Arquillian still automatically start and stop GlassFish as needed. You must
   set an admin password for GlassFish. Due to a GlassFish bug, Arquillian can't
   start GlassFish with an empty admin password. Also, GlassFish embedded is 
   no longer supported as of GlassFish 4 and cannot be used. When this chpater was written there were some issues in using GlassFish in use remote mode (this is the fastest testing option    with Arquillian).

Detailed instructions for setting up all other required tools for running the 
examples used in this book are discussed in Appendix section of this book


How to use this example 
-------------------------
   
- Open the rest-appendix-arquillian project in NetBeans IDE 8.0.2 or higher
    - In main tool bar,choose File > Open Project > rest-appendix-arquillian
    - In the project pane, expand rest-appendix-arquillian project 
    - Note that this example uses HR schema that usually comes with Oracle as sample schema. So we need to change the connection details to reflect your local settings as explained in next step. 
    - In rest-appendix-arquillian project,       
        - Go to src/main/resources folder and open META-INF/persistence.xml.  Modify the jta-data-source entry to match with Oracle data base that you have. You can either choose a an already existing data source(which connects to HR schema in Oracle DB) in GlassFish server or define a new JNDI data source in GlassFish and set it as 'jta-data-source' in persistence.xml. To know how to define data source in GlassFish, see this page: http://www.jobinesh.com/2015/09/configuring-jndi-data-source-for-oralce.html.
         
        - You will need to configure 
  <rest-appendix-arquillian>/src/test/resources/arquillian.xml with the details
  of your GlassFish installation.
    - To test project, right click rest-appendix-arquillian and choose test. This action deploys the REST services to the container and runs the tests.
   

Core classes and corresponding REST APIs used in this example
-------------------------------------------------------------

- <rest-appendix-arquillian>

    -  com.packtpub.jaxrs.arquilian.demo.service.ApplicationConfig: This class configures the JAX-RS components used in this example.    
    - com.packtpub.jaxrs.arquilian.demo.DepartmentResource: This is a standard REST resource class representing department resource. You can access this via URI http://<server>:<port>/rest-chapter8-service/webresources/departments
    
How to test the APIs ?
-------------------------    
 - Run the maven test command as follows: mvn test
- Alternatively from NetBeans, choose the project , right click and run Test

What next?
----------------------------
This project will help you to get a real feel of using Arquillian for integration tests. You can explore each tip at your own pace. Also try enhancing the samples by adding more points that we discussed in Appendix