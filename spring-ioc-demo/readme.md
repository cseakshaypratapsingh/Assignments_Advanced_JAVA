# Problem Statement 1

## Payment System Using Spring IoC

### Objective

Develop a payment system that supports multiple payment methods. The Spring IoC container must create and manage all payment beans. One payment method should be configured as the default bean. The application must also demonstrate bean scope and bean lifecycle management.

---

## Requirements

### 1. Create a Payment Interface

Create an interface named `Payment` with the following method:

```
void pay(double amount);
```

---

### 2. Create Payment Implementations

#### CreditCardPayment

* Must implement the `Payment` interface.
* Should print:

  ```
  Credit Card payment of Rs. <amount> successful
  ```
* Print the following message inside the constructor:

  ```
  CreditCardPayment Bean Created
  ```

#### UpiPayment

* Must implement the `Payment` interface.
* Should print:

  ```
  UPI payment of Rs. <amount> successful
  ```
* Print the following message inside the constructor:

  ```
  UpiPayment Bean Created
  ```

---

### 3. Configure Beans Using Spring Annotations

* Mark both implementation classes as Spring Beans.
* Configure bean scope:

    * `CreditCardPayment` → Singleton scope
    * `UpiPayment` → Prototype scope
* Demonstrate bean creation using constructor messages.

---

### 4. Configure Default Payment Method

* Configure `CreditCardPayment` as the default payment bean.
* Retrieve the `Payment` bean from the Spring container.
* Invoke the `pay()` method.

---

### 5. Demonstrate Bean Lifecycle

In the `CreditCardPayment` class, implement:

* Initialization method:

  ```
  CreditCardPayment Bean Initialized
  ```

* Destruction method:

  ```
  CreditCardPayment Bean Destroyed
  ```

---

### 6. Create Main Class

* Load Spring `ApplicationContext`.
* Retrieve `Payment` bean and call `pay()`.
* Retrieve `UpiPayment` bean twice to demonstrate prototype scope.
* Close the container.

---
