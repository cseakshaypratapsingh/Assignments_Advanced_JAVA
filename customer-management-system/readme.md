# Case Study: Customer Management System (CMS)

## Technology Stack

* Backend Framework: Spring MVC (Spring Boot)
* View Template Engine: Thymeleaf
* Database: PostgreSQL
* ORM Framework: Spring Data JPA (Hibernate)
* Build Tool: Maven

---

# 1. Project Overview

A retail organization intends to develop a Customer Management System (CMS) to efficiently manage customer records.

The objective of this application is to implement core Create and Read operations using a layered Spring MVC architecture, PostgreSQL for data persistence, and Thymeleaf for dynamic web page rendering.

The system must follow proper separation of concerns using the MVC design pattern.

---

# 2. Business Requirements

## 2.1 Create Customer

The system must allow users to enter and store the following details:

* Customer Name
* Email Address
* Phone Number
* Residential Address

Upon submission:

* Customer data must be persisted in the PostgreSQL database.
* The application must redirect the user to the customer listing page after successful storage.
* The primary key (Customer ID) must be auto-generated.

---

## 2.2 View Customers

The system must provide a page that:

* Displays all registered customers in a structured tabular format.
* Includes the following details:

    * Customer ID
    * Name
    * Email
    * Phone Number
    * Address

---

# 3. Database Requirements

## Database Name

cms

## Table Structure

```sql
CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    address VARCHAR(255)
);
```

Notes:

* `SERIAL` ensures automatic ID generation.
* PostgreSQL runs on default port 5432.

---

# 4. Technical Requirements

The application must follow a layered architecture based on MVC principles.

---

## 4.1 Model Layer

* Create a `Customer` entity class.
* Annotate the class using JPA annotations:

    * `@Entity`
    * `@Table`
    * `@Id`
    * `@GeneratedValue`
* Ensure proper mapping between class fields and database columns.
* Include:

    * Default constructor
    * Getters and setters

---

## 4.2 Repository Layer

* Create an interface `CustomerRepository`.
* Extend `JpaRepository<Customer, Integer>`.
* The repository must support:

    * Saving customer records.
    * Retrieving all customer records.
* No manual SQL queries required.

---

## 4.3 Service Layer

* Implement `CustomerService`.
* Responsibilities:

    * Save customer data.
    * Retrieve all customers.
* Use constructor injection.
* Maintain clear separation between controller and data access layers.

---

## 4.4 Controller Layer

Create a `CustomerController` with the following request mappings:

### GET /addCustomer

* Display customer registration form.
* Add empty `Customer` object to the model.

### POST /saveCustomer

* Accept submitted form data.
* Persist data using service layer.
* Redirect to `/customers`.

### GET /customers

* Retrieve all customers.
* Add list to the model.
* Return view for displaying customers.

The controller must:

* Use `Model` to pass data.
* Follow Post-Redirect-Get pattern.

---

## 4.5 View Layer (Thymeleaf)

Create the following templates inside:

```
src/main/resources/templates
```

### add-customer.html

Must include:

* `th:action` for form submission
* `th:object` for binding form model
* `th:field` for mapping form inputs

---

### customer-list.html

Must include:

* `th:each` for iterating customer records
* Display:

    * ID
    * Name
    * Email
    * Phone
    * Address

---

# 5. Expected System Behavior

1. When user accesses `/addCustomer`, the registration form must be displayed.
2. When the form is submitted:

    * Data must be stored in PostgreSQL.
    * User must be redirected to `/customers`.
3. When accessing `/customers`, all stored customer records must be displayed in a structured table.

---

# 6. Architectural Principles Demonstrated

* MVC Pattern
* Layered Architecture
* Separation of Concerns
* Dependency Injection
* JPA Entity Mapping
* Repository Abstraction
* Form Binding with Thymeleaf
* Post-Redirect-Get Pattern

