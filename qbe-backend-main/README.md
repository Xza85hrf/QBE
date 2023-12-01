# Spring Data JPA Query By Example
Illustrates the query by example(QBE) feature of Spring data JPA. 

# Technologies
- Spring Boot
- Spring Boot data JPA
- Lombok
- H2


# How to run
- Run the application as Springboot application
- While application start-up, it will inser the data from data-h2.sql 


# API (s)
1. Get All customers
	http://localhost:8080/customer/list
2. Get all customers whose first name ends with 
	http://localhost:8080/customer/firstname?endsWith=dra
3. Get all customers whose last name ends with
	http://localhost:8080/customer/lastname?endsWith=das
4. Get all customers whose first name equals
	http://localhost:8080/customer/rosalin
5. Get all customers whose wallet balance is
	http://localhost:8080/customer/balance?balance=5000




