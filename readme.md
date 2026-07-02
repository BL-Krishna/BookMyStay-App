# 🏨 BookMyStay-App

A **Core Java Hotel Booking Management System** developed incrementally to demonstrate real-world software engineering principles, object-oriented programming, Java Collections Framework, and data structure usage.

The application simulates a hotel booking platform where guests can search for rooms, make reservations, select additional services, and view booking history while ensuring fair booking allocation and preventing double bookings.

---

# 📌 Project Objectives

- Learn Core Java through a real-world application
- Understand appropriate use of Java Collections Framework
- Apply Object-Oriented Programming principles
- Practice clean architecture and modular design
- Implement Test Driven Development (TDD)
- Follow professional Git workflow
- Build production-quality Java code

---

# 🚀 Technologies Used

- Java 17
- Maven
- IntelliJ IDEA
- JUnit 5
- Git
- GitHub

---

# 📂 Project Structure

```
BookMyStay-App
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.bookmystay
│   │           ├── model
│   │           ├── repository
│   │           ├── service
│   │           ├── exception
│   │           ├── util
│   │           └── BookMyStayApplication.java
│   │
│   └── test
│       └── java
│           └── com.bookmystay
│
├── docs
├── README.md
├── pom.xml
└── .gitignore
```

---

# 📖 Use Cases

## ✅ UC1 – Room Inventory Setup & Management

### Data Structure

- HashMap<RoomType, Room>

### Features

- Add room types
- Maintain inventory
- Store room prices
- Store amenities
- Check room availability
- Update inventory

---

## ✅ UC2 – Room Search & Availability Check

### Data Structure

- HashMap

### Features

- Search room types
- View pricing
- View amenities
- Check availability

---

## ✅ UC3 – Booking Request (First Come First Served)

### Data Structure

- Queue<Reservation>
- LinkedList

### Features

- Accept booking requests
- FIFO processing
- Fair allocation

---

## ✅ UC4 – Reservation Confirmation & Room Allocation

### Data Structures

- HashSet
- HashMap<String, Set<String>>

### Features

- Assign unique room IDs
- Prevent duplicate room allocation
- Automatic inventory updates

---

## ✅ UC5 – Add-On Services

### Data Structure

- Map<String, List<Service>>

### Features

- Breakfast
- Airport Pickup
- Spa
- Laundry
- Restaurant

---

## ✅ UC6 – Booking History & Reporting

### Data Structure

- List<Reservation>

### Features

- Booking history
- Cancellation
- Reports
- Reservation lookup

---

# 📚 Java Collections Used

| Collection | Purpose |
|------------|---------|
| HashMap | Room Inventory |
| LinkedList | Booking Queue |
| Queue | FIFO Booking |
| HashSet | Unique Room Allocation |
| List | Booking History |
| Map | Reservation Services |

---

# 🏗 Architecture

```
Presentation
      │
      ▼
Service Layer
      │
      ▼
Repository Layer
      │
      ▼
Collections Framework
```

---

# 🧩 Design Principles

- Object-Oriented Programming
- SOLID Principles
- Clean Code
- Separation of Concerns
- DRY Principle
- Single Responsibility Principle

---

# 🛠 Git Workflow

Repository Name

```
BookMyStay-App
```

### Branch Structure

```
main
develop

feature/UC1-Room_Inventory_Setup_Management
feature/UC2-Room_Search_Availability_Check
feature/UC3-Booking_Request_First_Come_First_Served
feature/UC4-Reservation_Confirmation_Room_Allocation
feature/UC5-Add_On_Service_Selection
feature/UC6-Booking_History_Reporting
```

### Workflow

```
Feature Branch
      │
      ▼
Develop
      │
      ▼
Main
```

---

# 📝 Commit Message Format

```
[Your Name] : Description
```

Example

```
[Krrish CH] : Implemented room inventory management

[Krrish CH] : Added room search functionality

[Krrish CH] : Implemented booking queue

[Krrish CH] : Added room allocation logic

[Krrish CH] : Implemented booking history
```

---

# ▶️ How to Run

Clone Repository

```bash
git clone https://github.com/<your-username>/BookMyStay-App.git
```

Go to project

```bash
cd BookMyStay-App
```

Compile

```bash
mvn clean compile
```

Run

```bash
mvn exec:java
```

Or simply run

```
BookMyStayApplication.java
```

from IntelliJ IDEA.

---

# 🧪 Testing

Run all tests

```bash
mvn test
```

---

# 📈 Future Enhancements

- Customer Management
- Payment Gateway Simulation
- Loyalty Program
- Email Notifications
- Dynamic Pricing
- Room Reviews
- Discount Coupons
- Admin Dashboard
- File Persistence
- Database Integration
- Spring Boot Migration

---

# 🎯 Learning Outcomes

After completing this project, you will understand:

- Core Java
- Object-Oriented Programming
- Java Collections Framework
- Exception Handling
- Java Generics
- Enums
- HashMap
- Queue
- HashSet
- List
- Clean Architecture
- Unit Testing
- Git Workflow
- Software Design Principles

---

# 👨‍💻 Author

**Krrish CH**

Software Engineer | Java Developer | Full Stack Developer

---

# 📄 License

This project is developed for educational purposes to practice Core Java, Data Structures, Object-Oriented Programming, and Software Engineering principles.