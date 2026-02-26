# Problem Statement 2

## Notification System Using Spring IoC

### Objective

Develop a notification system that supports multiple notification channels. The Spring IoC container must manage the notification beans. Email notifications should be eagerly initialized, while SMS notifications should be lazily initialized. The application must also demonstrate bean naming and lifecycle behavior.

---

## Requirements

### 1. Create a Notification Interface

Create an interface named `Notification` with the method:

```
void send(String message);
```

---

### 2. Create Implementation Classes

#### EmailNotification

* Must implement the `Notification` interface.
* Print:

  ```
  Email Notification sent: <message>
  ```
* Constructor message:

  ```
  EmailNotification Bean Created
  ```

#### SmsNotification

* Must implement the `Notification` interface.
* Print:

  ```
  SMS Notification sent: <message>
  ```
* Constructor message:

  ```
  SmsNotification Bean Created
  ```

---

### 3. Configure Beans with Custom Names

* Configure `EmailNotification` bean with name:

  ```
  emailBean
  ```
* Configure `SmsNotification` bean with name:

  ```
  smsBean
  ```

---

### 4. Configure Lazy Initialization

* `EmailNotification` → Default eager initialization
* `SmsNotification` → Lazy initialization

---

### 5. Demonstrate Bean Lifecycle

In `EmailNotification`, implement:

* Initialization method:

  ```
  EmailNotification Bean Initialized
  ```

* Destruction method:

  ```
  EmailNotification Bean Destroyed
  ```

---

### 6. Create Main Class

* Load Spring `ApplicationContext`.
* Observe which bean is created at startup.
* Retrieve `emailBean` and call `send()`.
* Retrieve `smsBean` and call `send()`.
* Close the container.

---

Now you have:

• Clear objectives
• Clean separation of concerns
• Explicit lifecycle expectations
• No ambiguity

This is how you translate vague instructions into implementation-ready design.

Next step is deciding whether you want both problems inside the same project or separate Maven projects.
