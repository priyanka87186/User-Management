# User-Management

### **User Management System with Spring Boot and MySQL**

The **User Management System** is a secure and scalable application built with **Spring Boot** and **MySQL**, designed for managing user accounts and roles with **JWT-based authentication**.

#### **Key Features:**

1. **JWT Authentication**: Secure login using JWT tokens, with token refresh functionality to maintain session continuity.
   
2. **Role-Based Access Control**: Users are assigned roles (Admin or User), with Admins having full control over user management. Role-based access ensures only authorized users can perform certain actions.

3. **Pagination Support**: Users can be fetched in a paginated format, improving performance when dealing with large datasets (e.g., `GET /get-all?page=0&size=5`).

4. **CRUD Operations**:
   - **Admins**: Create, view, update, and delete users.
   - **Regular Users**: View and update their profiles.
   
5. **One Admin Restriction**: The system enforces the existence of a single Admin. A default Admin is created at startup, and no additional Admins can be added.

6. **Secure Password Handling**: Passwords are securely hashed, and validation rules ensure strong password criteria.

7. **MySQL Integration**: Uses **Spring Data JPA** and **Hibernate** for seamless database operations, storing user data and roles in MySQL.

#### **Technologies**:
- **Spring Boot**: Framework for building stand-alone applications.
- **Spring Security**: Manages authentication and authorization with JWT.
- **Spring Data JPA** & **Hibernate**: Simplifies database interactions.
- **MySQL**: Relational database for persisting user data.
- **Lombok**: Reduces boilerplate code.

This system offers a streamlined solution for managing users with secure role-based access, ideal for applications requiring robust user control.
