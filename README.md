Address microservice
============

This is a java API powered by Spring boot that provides the functions of an Address handler.

## Features
- Address saving
- OpenFeign support
- External API calls


It was part of `Challenge - 3` from my internship at [compassuol](https://compass.uol/pt/home/)

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


### Save Address

Creates a new user in the system.
to use the endpoint you need a Jwt token provided in the User microservice.

```http
POST http://localhost:8080/v1/address
Content-Type: application/json

{
    "cep": "00000-000"
}
```

## Documentation

The `swagger` documentation can be found here:
```http
 http://localhost:8080/swagger-ui/index.html

```
