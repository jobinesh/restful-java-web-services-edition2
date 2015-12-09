Code Samples for Appendix
==========================
This file contains instructions for running project **rest-appendix-patch-demo** associated with Appendix of RESTful Java Web Services.
This example demonstrates how to enable PATCH support in JAX-RS application.
This sample is inspired by the article available at: http://kingsfleet.blogspot.in/2014/02/transparent-patch-support-in-jax-rs-20.html

General instructions
--------------------
The examples used in this book are built using the following:

- Java SE Development Kit 8
- NetBeans IDE 8.0.2 
- Maven 3.2.3. 
- Oracle Database 11.2 Express Edition or higher (Example uses HR Schema)

Detailed instructions for setting up all the required tools for running the 
examples used in this book are discussed in Appendix section of this book

How to use this example 
-------------------------
   
- Open the rest-appendix-patch-demo project in NetBeans IDE 8.0.2 or higher
    - In main tool bar,choose File > Open Project > rest-appendix-patch-demo
    - In the project pane, expand rest-appendix-patch-demo project 
    - Note that this example uses HR schema that usually comes with Oracle as sample schema. So we need to change the connection details to reflect your local settings as explained in next step. 
    - In rest-appendix-patch-demo,        
        - Open META-INF/persistence.xml and modify the data source to match with Oracle data base (having HR schema) that you have. 
    - To run project, right click rest-appendix-patch-demo and choose Run. This action deploys the REST services.
   

Core classes and corresponding REST APIs used in this example
-------------------------------------------------------------

- <rest-appendix-patch-demo>

    -  com.packtpub.rest.appendix.patch.demo.service.ApplicationConfig: This class configures the JAX-RS components used in this example.    
    - com.packtpub.rest.appendix.patch.demo.service.DepartmentResource: This is a standard REST resource class representing department resource. You can access this via URI http://<server>:<port>/rest-appendix-patch-demo/webresources/departments
    -  com.packtpub.rest.appendix.patch.demo.service.PATCH: HTTP method extension for supporting HTTP PATCH
    -  com.packtpub.rest.appendix.patch.demo.service.OptionsAcceptHeader: This class output Accept-Patch:application/json-patch+json  when a client performs an OPTIONS request. 
    
How to test the APIs ?
-------------------------    
 - Deploy the application to a container. Alternatively you can run(Right click on project and choose Run) the desired REST sample project as described in last section. This action will deploy the application in to integrated Glassfish
 
    - A quick way to test the API is to use any REST test client(such as Postman or Rest Console addons that will find for Chrome browser)    
    - To test PATCH method , issue a PATCH request with following properties using any of your favourite REST test client.
   	 	- Request URI: http://<server>:<port>/rest-appendix-patch-demo/webresources/departments/10
   	 	- Content-Type: application/json-patch+json
		- Request Method: PATCH
		- Request Payload: [{ "op": "replace", "path": "/managerId", "value": 101}, { "op": "replace", "path": "/departmentName", "value":"HR" }]
	


What next?
----------------------------
This project will help you to understand how you can add support for PATCH method in JAX-RS. You can explore each tip at your own pace. 