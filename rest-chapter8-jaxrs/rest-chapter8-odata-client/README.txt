Code Samples for Chapter 8
==========================
This file contains instructions for running project **rest-chapter8-odata-client** associated with Chapter 8 of RESTful Java Web Services.

General instructions
--------------------
The examples used in this book are built using the following:

- Java SE Development Kit 8
- NetBeans IDE 8.0.2 
- Maven 3.2.3. 


Detailed instructions for setting up all the required tools for running the 
examples used in this book are discussed in Appendix  section of this book

How to use this example 
-------------------------
   
- Open the rest-chapter8-odata-client project in NetBeans IDE 8.0.2 or higher
    - In main tool bar,choose File > Open Project > rest-chapter8-odata-cleint
    - In the project pane, expand rest-chapter8-odata-client project 
    - This is a OData client class created for rest-chapter8-odata-service
    - Before running the client, deploy rest-chapter8-odata-service to the server 
    - Change the serviceUrl variable in main() method of ODataDepartmentServiceClient to reflect the OData service URI for rest-chapter8-odata-service(e.g: http://localhost:28080/rest-chapter8-odata-service/odata)
	- To run project, right click rest-chapter8-odata-client and choose Run. This action will perform Create, Read,  Update and Delete on departments resource collection via OData service API
   

Core classes and corresponding REST APIs used in this example
-------------------------------------------------------------

- <rest-chapter8-odata-client>: This project contains client class for Olingo data service 
    - com.packtpub.rest.ch8.odata.client.ODataDepartmentServiceClient
    
How to test the APIs ?
-------------------------    
 - This client application uses rest chapter8-odata-service located in rest-chapter8-odata-service project. 
 	- First you have to deploy the rest-chapter8-odata-service to a container. 
 	- To do this go to rest-chapter8-odata-service project, right click on project and choose Run. This action will deploy the application in to integrated Glassfish
 - Open ODataDepartmentServiceClient.java and make sure serviceUrl variable in main() points to right URI(where rest-chapter8-odata-service is running )
 - To run ODataDepartmentServiceClient, right click the class and choose Run  
 - This action will perform Create, Read, Update, Delete on JPA model via OData service APIs over REST protocol      
.    

What next?
----------------------------
You can try adding more features from Apache Olingo. Refer [http://olingo.apache.org/doc/odata2/index.html](http://olingo.apache.org/doc/odata2/index.html)