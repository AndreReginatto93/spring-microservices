# 📚 Bookstore API (Spring Data JPA)

A simple microservice built with **Java, Spring Boot, PostgreSQL, and RabbitMQ**.  
It provides a REST endpoint to create users and sends a confirmation email using **Gmail SMTP**.  
The service uses **CloudAMQP** as a RabbitMQ provider.

## Table of Contents
- [Run Locally](#-run-locally)
- [Technologies](#-Technologies)
- [API Endpoints](#api)

## Run Locally
1. Clone the repository:
   ```bash
   git clone https://github.com/AndreReginatto93/spring-microservices.git
   cd spring-microservices
2. Start PostgreSQL and create a database:
   * CREATE DATABASE ms-user;
   * CREATE DATABASE ms-email;
3. Update your application.properties in each service (look for the comments // change here):
    * ms-email service
   
   ```
   spring.mail.username=your_email@gmail.com       # change here
   spring.mail.password=your_app_password          # change here (use Gmail app password)
   spring.rabbitmq.addresses=your_cloudamqp_url    # change here
    ``` 
   * ms-email service
   ```
   spring.rabbitmq.addresses=your_cloudamqp_url    # change here
    ```

4. Run the applications
5. Test the endpoints with Postman or curl
   * "http://localhost:8081/user"

## 🛠 Technologies

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **RabbitMQ**
- **CloudAMQP** (RabbitMQ as a Service)
- **PostgreSQL**
- **pgAdmin** (database management)
- **IntelliJ IDEA** (development IDE)
- **Postman** (API testing)



# API
| Operations       | HTTP Method | Path                  |
|------------------|-------------|-----------------------|
| Create user      | POST        | /user                 |

```http
POST /user

{
    "name": "André",
    "email": "andrereginatto93@gmail.com"
}
```