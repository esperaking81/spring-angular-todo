# Todo App

A full-stack task management application with a Spring Boot backend API and an Angular frontend (planned).

## Project Structure

```
todo_app/
├── apps/
│   ├── api/          # Spring Boot backend (Java 17, Gradle)
│   └── web/          # Angular frontend (planned)
└── README.md
```

## Backend (API)

The backend is a Spring Boot 4.0.3 REST API that provides CRUD operations for managing todos. It uses Gradle 9.3.1 as the build tool and connects to a PostgreSQL database.

### Tech Stack

- **Java 17**
- **Spring Boot 4.0.3** (Web, Data JPA, DevTools)
- **PostgreSQL** for persistence
- **Gradle 9.3.1** for build management
- **JUnit 5** for testing

### Prerequisites

- Java 17+
- PostgreSQL running locally on port `5432`
- A database named `todos_db`

### Database Setup

Create the PostgreSQL database:

```sql
CREATE DATABASE todos_db;
```

The default connection is configured in `apps/api/src/main/resources/application.properties`:

| Property | Default Value |
|---|---|
| URL | `jdbc:postgresql://localhost:5432/todos_db` |
| Username | `postgres` |
| Password | `postgres` |

### Running the API

From the `apps/api` directory:

```sh
./gradlew bootRun
```

The API starts on `http://localhost:8080`.

### API Endpoints

#### Create a todo

```
POST /todos
Content-Type: application/json

{ "title": "Buy groceries" }
```

Response: `200 OK`

```json
{ "id": 1, "title": "Buy groceries", "isCompleted": false }
```

#### Get all todos

```
GET /todos
```

Response: `200 OK`

```json
[
  { "id": 1, "title": "Buy groceries", "isCompleted": false }
]
```

#### Get a todo by ID

```
GET /todos/{id}
```

Response: `200 OK`

```json
{ "id": 1, "title": "Buy groceries", "isCompleted": false }
```

Returns `404 Not Found` if the todo does not exist.

### Running Tests

```sh
./gradlew test
```

## Frontend (Web)

> **Status:** Not yet implemented.

The frontend will be an Angular application located in `apps/web/`.

## Roadmap

- [ ] Add persistent storage via JPA entities and repositories
- [ ] Update and delete todo endpoints
- [ ] Mark todos as completed
- [ ] Scaffold Angular frontend
- [ ] Connect frontend to backend API
