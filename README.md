Address microservice
============

This is a java API powered by Spring boot that provides the functions of an Address handler.

## Features
- Address saving
- OpenFeign support
- External API calls


| Technologies Used  |            |
|--------------------|------------|
| Spring Boot        |            |
| Java               |            |
| OpenFeign          |            |
| Swagger            |            |

| Additional Tools   |            |
|--------------------|------------|
| MySQL              |            |

Contributors: Vinicius Guerra


## How to Use

1. **Setup Environment:**
    - Ensure you have Java and Maven installed on your system.

2. **Clone the Repository:**
   ```bash
   git clone <repository_url>

3. **Setup Database:**
    - You might want to look into `applications.yml` to make changes to the port and set up your database.

4. **Setup RabbitMq**
   - Run the RabbitMq server using this docker command in the terminal:
   docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.9-management

### Save Address

Creates a new user in the system.
to use the endpoint you need a Jwt token provided in the User microservice.

```http
POST http://localhost:8080/v1/address
Content-Type: application/json

body:
{
    "cep": "00000-000"
}
```

## Documentation

The `swagger` documentation can be found here:
```http
 http://localhost:8080/swagger-ui/index.html

```
