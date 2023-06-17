# About project
- maven is used as build tool
- SprintBoot is used to build the application
- Restfull APIs are exposed to do the operation
- In-built h2 database is used

# Steps to Build the project:
1) Fetch the project from git to your local compurter
2) mvn clean install
3) Run the main class PersonApplication.java
4) Access the h2 database url: http://localhost:8080/h2
5) click on 'connect' button
6) Default data is populated in Address and Person table
7) try to access the Restfull APIs

# RESTFULL APIs
1) Add Person  
HTTP Verb: POST  
URL:http://localhost:8080/persons  
Body:{
   "firstName":"John",
   "lastName":"Paul"
}
Hearder:   
key: Content-Type  
value: application/json  

2) Edit Person  
HTTP Verb: PUT  
URL:http://localhost:8080/persons/{personId}  
Body:{"id":1,"firstName":"John","lastName":"Reid"}  
Hearder:   
key: Content-Type  
value: application/json  

3) Delete Person  
HTTP Verb: DELETE  
URL:http://localhost:8080/persons/{personId}  

4) Get Number of persons  
HTTP Verb: GET  
URL: http://localhost:8080/persons/count  

5)  Get All persons  
HTTP Verb: GET  
URL: http://localhost:8080/persons/  

6) Add address to person  
HTTP Verb: POST
URL: http://localhost:8080/address?personId:1
Header:
key: Content-Type  
value: application/json  
Body:
[{
   "street":"test",
   "city":"test",
   "state":"state",
   "postalCode":"postalCode"
}
]


