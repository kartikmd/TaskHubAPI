

# TaskHubAPI

TaskHubAPI is a Spring Boot RESTful service that allows users to manage tasks with features like task creation, status updates, and priority-based tracking.

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Postman (for API testing)
- Hibernate Validator (for input validation)

---

## ⚙️ Project Setup

1. **Clone the repository**

```bash
git clone https://github.com/your-username/taskhub-api.git
cd taskhub-api
````

2. **Create MySQL Database**

```sql
CREATE DATABASE db;
```

3. **Configure `application.properties`**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234567890
spring.jpa.hibernate.ddl-auto=update
```

4. **Run the project**

```bash
mvn spring-boot:run
```

---

## 🔗 API Endpoints

### 👤 User Endpoints

| Method | Endpoint          | Description     |
| ------ | ----------------- | --------------- |
| GET    | `/api/users`      | Get all users   |
| GET    | `/api/users/{id}` | Get user by ID  |
| POST   | `/api/users`      | Create new user |
| PUT    | `/api/users/{id}` | Update user     |
| DELETE | `/api/users/{id}` | Delete user     |

### ✅ Task Endpoints

| Method | Endpoint                   | Description             |
| ------ | -------------------------- | ----------------------- |
| GET    | `/api/tasks`               | Get all tasks           |
| GET    | `/api/tasks/{id}`          | Get task by ID          |
| GET    | `/api/tasks/user/{userId}` | Get tasks by user ID    |
| POST   | `/api/tasks`               | Create new task         |
| PUT    | `/api/tasks/{id}`          | Update task             |
| PATCH  | `/api/tasks/{id}/status`   | Update task status only |
| DELETE | `/api/tasks/{id}`          | Delete task             |

---

## 📥 Sample Request

### POST `/api/tasks`

```json
{
  "title": "Finish project",
  "description": "Build backend with Spring Boot",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2025-08-15",
  "userId": 1
}
```

---

## ✅ Validation Rules

* `dueDate` must be in the future
* `title`, `status`, `priority`, and `userId` are required

---

## 🧠 Architecture

* Layered structure: Controller → Service → Repository → Entity
* DTOs used for request and response
* `@ControllerAdvice` handles global exceptions
* Enum-based fields for `Status` and `Priority`

---

## 👤 Author

Kartik Naik
Spring Boot Developvser – TaskHubAPI


