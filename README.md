# 🎓 Student Management REST API (Spring Boot)

A simple and clean **REST API built with Spring Boot** to manage students.  
This project is perfect for beginners who want to learn:

- REST API development
- Controller → Service → Repository architecture
- DTOs and validation
- Global exception handling
- JPA + Hibernate + MySQL (or H2)
- Clean code & best practices

---

## 🚀 Features

✔ Create a student  
✔ Get all students  
✔ Get a student by ID  
✔ Update student  
✔ Delete student  
✔ Validate fields (email, size, null checks)  
✔ Global error handling with `@RestControllerAdvice`

**Optional extensions (future upgrades):**
- JWT Authentication
- Role-based access (ADMIN / USER)
- React front-end
- Docker containerization

---

## 🏗️ Project Structure

```
src/
 └── main/java/com/example/studentapi
      ├── controller
      │     └── StudentController.java
      ├── service
      │     └── StudentService.java
      ├── repository
      │     └── StudentRepository.java
      ├── dto
      │     └── StudentDTO.java
      ├── exception
      │     ├── GlobalExceptionHandler.java
      │     └── ResourceNotFoundException.java
      └── entity
            └── Student.java
```

---

## 📚 Technologies

- **Java 21**
- **Spring Boot 3**
- Spring Web
- Spring Data JPA
- Hibernate
-  H2 Database
- Validation (Jakarta Validation)
- Lombok 

---

## 🧩 API Endpoints

| Method | Endpoint          | Description            |
|--------|--------------------|------------------------|
| POST   | `/api/students`    | Create a new student   |
| GET    | `/api/students`    | Get all students       |
| GET    | `/api/students/{id}` | Get student by ID    |
| PUT    | `/api/students/{id}` | Update student       |
| DELETE | `/api/students/{id}` | Delete student       |

---

## 📄 Example Student JSON

```json
{
  "name": "Othmane EZ-Zahraouy",
  "email": "othmane@example.com",
  "filiere": "Computer Science",
  "age": 22
}
```

---

## 🗄️ Database Configuration

### **application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Or use **H2 in-memory** for testing:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

---

## 🧪 Running the Project

### **1. Clone the repo**
```bash
git clone https://github.com/your-username/student-management-api.git
```

### **2. Open the project in IntelliJ or VS Code**

### **3. Run it**
```bash
mvn spring-boot:run
```

Server will run on:

```
http://localhost:8080
```

---

## 🧱 Future Improvements (Roadmap)

- 🔐 Add JWT authentication
- 👨‍🏫 Add Teachers & Courses entities
- 🗃 Add pagination & sorting
- 📊 Add dashboard statistics
- 🌐 Add a React front-end
- 🐳 Docker support

---

## 🤝 Contributing

Pull requests are welcome!  
Feel free to improve code structure, add new features, or propose enhancements.

---

## 📝 License

This project is open-source under the **MIT License**.

---

## ⭐ Support

If this project helped you learn Spring Boot, please give it a **star ⭐ on GitHub**!
