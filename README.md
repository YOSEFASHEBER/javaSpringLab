# Product Service

A simple REST API built with Spring Boot.

## Run the project

mvn spring-boot:run

## Endpoints

GET /products  
GET /products/{id}  
POST /products  
GET /health

## Example request

POST /products

{
"name":"Laptop",
"price":1200
}
