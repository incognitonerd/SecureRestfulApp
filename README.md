# SecureRestfulApp

Reference App that uses the following technologies Ubuntu Server, Jenkins Server, Wildfly Server, Mysql Server, Eclipse Java EE, Java 8, Maven, Spring Boot, Spring Security, Spring Web, Spring Hibernate, JDBC.

Exposes Multiple Secure Endpoints Filtered By Roles And A Few Unsecure Endpoints That Do Various Joins On Multiple Tables Of Jargon Data  

curl -u username:password -G http://localhost:8080/SecureRestfulApp/secure/randomqueries/getTwoMostPopRegDates  

http://localhost:8080/SecureRestfulApp/secure/randomqueries/getInactiveUsers
http://localhost:8080/SecureRestfulApp/secure/randomqueries/getMostPopPhoto
http://localhost:8080/SecureRestfulApp/secure/randomqueries/getAvgPhotosPerUser
http://localhost:8080/SecureRestfulApp/secure/randomqueries/getFiveMostPopHashtags
http://localhost:8080/SecureRestfulApp/secure/randomqueries/getUsersWhoMayBeBots


curl http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAvailableEndpoints   

http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllTables 
http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllTableStats
http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllComments
http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllFollows
http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllLikes 
http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllPhotos
http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllPhotoTags 
http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllTags   
http://localhost:8080/SecureRestfulApp/unsecure/showdataset/getAllUsers 
 
 
Copy and paste the data that's returned in this editor and click validate json: https://jsonlint.com/  

Dev Environment -  
* Github - Code repository  
* Jenkins Server - Continuous integration continuous deployment build tool  
* Ubuntu Server - Linux box to host my applications  
* Macbook Pro - My personal machine  
* Eclipse Java EE - IDE
* Java 8 - Programming language used  
* Wildfly Server - Application server to host the war  
* Mysql Server - For my database  

Build Management And Automation Tool -
* Maven - project management framework for compilation, packaging, simplifies and standardizes a project's build process, a default/standard project structure, dependency management, relies on internet connection. Based on the pom (project object model)  

Wiring the technologies together -  
* Spring Boot - develop enterprise applications using pojos instead of beans, forces programmers to use the best-known practices. Handles instantiating classes (dependency injection).

Database Connections -
* Jpa - java persistence api for crud operations and annotations. runs jdbc in the background.    
* Hibernate - vendor to implement the jpa specifications 
* Jdbc - used to select data from the db

Authentication -  
* Spring Security - Secure URL mapping, and user validation
