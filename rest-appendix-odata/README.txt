Code Samples for Appendix
==========================
This file contains instructions for running the sample project associated with Appendix of RESTful Java Web Services. 
This example demonstrates you how to use Olingo to enable OData service for your JPA model.

General instructions
--------------------
The examples used in this book are built using the following:

- Java SE Development Kit 8
- NetBeans IDE 8.0.2 c
- Glassfish Server 4.1 or newer(installed along with  NetBeans IDE)
- Maven 3.2.3. 
- Oracle Database 11.2 Express Edition or higher (Example uses HR Schema)

Detailed instructions for setting up all the required tools for running the 
examples used in this book are discussed in Appendix section of this book

 
How to use this example 
-------------------------
- Extract the zip file to your local file system. You may see **rest-appendix-odata** folder in the extracted location.
- This is a maven parent project and it has four sub projects
    - <rest-appendix-odata-service> : This project demonstrates how to generate OData services for your JPA model. This feature is enabled via Apache Olingo.  To learn about this project, refer (rest-appendix-odata-service/README.txt)   
    - <rest-appendix-client> : This project demonstrates how to consume OData services from a Java client. This feature is enabled via Apache Olingo. To learn about this project, refer (rest-appendix-odata-client/README.txt) 
      
- Open the rest-appendix-odata project in NetBeans IDE 8.0.2 or higher

    - In main tool bar,choose File > Open Project > rest-appendix-odata
    - In the project pane, expand rest-appendix-odata project and double click desired project to open in the IDE
    - **You will find a README.txt file under each project listed below rest-appendix-odata. Please go through this file to know how to run the respective project.**    


What next?
----------------------------
You can learn more about Apache Olingo by visiting official site at https://olingo.apache.org/. Try enhancing this samples with new features that you learn from the site. 