# Demo Project

This is an educational project using Java, Spring Boot, and Maven. The main goal is to show others that there is an ability to generate a server by OpenAPI specs. The OpenAPI specification is located in `docs/openapi.yaml`, and the API interface is generated by the `openapi-generator-maven-plugin` in `pom.xml`.

## Requirements

- Java 11 or higher
- Maven 3.6.0 or higher

## Getting Started

### Clone the repository

```sh
git clone https://github.com/yourusername/demo-project.git
cd demo-project
```

### Build the project

```sh
mvn clean install
```

### Run the application

```sh
mvn spring-boot:run
```

The application will start on port 8090.

## API Endpoints

### Get all users

```http
GET /users
```

Response:

```json
[
  {
    "id": 1,
    "name": "Mykhailo"
  },
  {
    "id": 2,
    "name": "Alex"
  }
]
```

### Add a new user

```http
POST /users
```

Request body:

```json
{
  "name": "New User"
}
```

Response:

```json
{
  "id": 3,
  "name": "New User"
}
```

### Get a user by ID

```http
GET /users/{id}
```

Response:

```json
{
  "id": 1,
  "name": "Mykhailo"
}
```

### Update a user

```http
PUT /users/{id}
```

Request body:

```json
{
  "name": "Updated User"
}
```

Response:

```json
{
  "id": 1,
  "name": "Updated User"
}
```

### Delete a user

```http
DELETE /users/{id}
```

Response: `204 No Content`
