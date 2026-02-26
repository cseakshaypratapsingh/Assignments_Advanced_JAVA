# Case Study

# Employee Leave Management System (ELMS)

---

## 1. Objective

Design and develop a web-based Employee Leave Management System using the Spring MVC architecture.

The system must manage:

* Employee records
* Leave types
* Leave requests

All data must be persisted in a relational database and displayed dynamically using Thymeleaf.

---

## 2. Scenario

A company currently handles employee leave requests manually. This process leads to:

* Delays in approval
* Lack of centralized tracking
* Difficulty in monitoring leave balances
* Poor visibility into leave status

To automate this process, a web-based system must be developed that:

* Stores employee data
* Tracks leave applications
* Maintains approval status
* Preserves relational integrity between records

---

## 3. Technology Stack

* Backend Framework: Spring MVC
* View Layer: Thymeleaf
* Database: MySQL
* Build Tool: Apache Maven
* Server: Apache Tomcat

---

## 4. Database Design

### 4.1 Employee Table

| Column Name  | Type    | Constraint  |
| ------------ | ------- | ----------- |
| employee_id  | INT     | Primary Key |
| name         | VARCHAR | Not Null    |
| email        | VARCHAR | Unique      |
| department   | VARCHAR | —           |
| joining_date | DATE    | —           |

---

### 4.2 Leave_Type Table

| Column Name      | Type    | Constraint  |
| ---------------- | ------- | ----------- |
| leave_type_id    | INT     | Primary Key |
| leave_name       | VARCHAR | Not Null    |
| max_days_allowed | INT     | Not Null    |

---

### 4.3 Leave_Request Table

| Column Name   | Type    | Constraint                    |
| ------------- | ------- | ----------------------------- |
| request_id    | INT     | Primary Key                   |
| employee_id   | INT     | Foreign Key → Employee        |
| leave_type_id | INT     | Foreign Key → Leave_Type      |
| start_date    | DATE    | —                             |
| end_date      | DATE    | —                             |
| status        | VARCHAR | Pending / Approved / Rejected |

---

## 5. Relationship Requirements

1. One Employee → Many Leave Requests
2. One Leave Type → Many Leave Requests

This creates two Many-to-One relationships inside Leave_Request:

* Leave_Request → Employee
* Leave_Request → Leave_Type

---

## 6. Functional Requirements

### 6.1 Employee Module

The system must support:

* Add new employee
* View all employees
* Update employee details
* Delete employee

---

### 6.2 Leave Type Module

The system must support:

* Add new leave type
* View all leave types

---

### 6.3 Leave Request Module

The system must support:

* Apply for leave
* Approve leave request
* Reject leave request
* View leave requests for a specific employee

---

## 7. Architectural Constraints

The application must:

* Follow MVC layered architecture
* Separate:

    * Model layer
    * DAO layer
    * Service layer
    * Controller layer
* Use form binding in Spring MVC
* Perform CRUD operations
* Maintain foreign key integrity
* Implement basic business logic in service layer

---

## 8. Business Logic Requirements

The system must enforce:

* Default status = "Pending" when leave is applied
* Status must change only through approval or rejection
* Leave approval must be handled via service layer
* Leave duration may optionally be validated against max_days_allowed

---

## 9. Expected System Behavior

The application should:

* Persist data across three related tables
* Display relational data using Thymeleaf
* Maintain foreign key constraints
* Successfully perform CRUD operations
* Allow approval workflow
* Follow proper layered separation

---

## 10. Architectural Flow

Browser
↓
Controller
↓
Service
↓
DAO / Repository
↓
MySQL Database
↓
Service
↓
Controller
↓
Thymeleaf View



