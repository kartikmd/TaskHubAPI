
### ✅ `README.md`


# TaskHubAPI

TaskHubAPI is a Java Spring Boot RESTful API for managing users and their tasks. It supports creating, updating, assigning, and filtering tasks based on status, priority, and due date.

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Postman (for API testing)

---

## ⚙️ Project Setup Instructions

1. **Clone the project**

```bash
git clone https://github.com/kartikmd/TaskHubAPI.git
cd TaskHubAPI
````

2. **Create the database**

```sql
CREATE DATABASE db;
```

3. **Update `application.properties`**

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

## 🔗 Sample API Requests

### ✅ Create a User

**POST** `/api/users`

```json
{
  "name": "Alice",
  "email": "alice@example.com"
}
```

---

### ✅ Create a Task

**POST** `/api/tasks`

```json
{
  "title": "Build Spring API",
  "description": "Finish TaskHub assignment",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2025-08-10",
  "userId": 1
}
```

---

### ✅ Update Task Status

**PATCH** `/api/tasks/1/status`

```json
{
  "status": "IN_PROGRESS"
}
```

---

### ✅ Get Tasks by User

**GET** `/api/tasks/user/1`

---

## 🧠 OOP & Architecture Explanation

* **DTO Layer:** Used for all API request/response objects to keep domain models decoupled from HTTP logic.
* **Entity Layer:** Contains `User` and `TaskItem` JPA entities, mapped to database tables.
* **Service Layer:** Business logic is separated into interfaces and `impl` classes for loose coupling and testability.
* **Repository Layer:** Uses Spring Data JPA for database access via interfaces.
* **Controller Layer:** Handles HTTP endpoints and delegates to services.
* **Enums:** `Status` and `Priority` are modeled using `enum` for controlled values.
* **Validation:** Uses `jakarta.validation` annotations (`@NotNull`, `@Future`) to ensure data integrity.
* **Exception Handling:** A global exception handler is implemented using `@ControllerAdvice`.

---

## 🧪 Testing

Use **Postman** to test the API endpoints. All responses are JSON formatted. Validation errors return `400 Bad Request` with field-level messages.

---

## 👨‍💻 Author

**Kartik Naik**
Spring Boot Developer


