# 🎴 Mandarin Web Flashcard System

A web-based learning application built with **Spring Boot** designed to help users learn Mandarin vocabulary using interactive flashcards. This project demonstrates clean architecture principles with a strict separation of concerns, persistent data layer, and responsive user interface.

## 🚀 Features
* **Randomized Flashcard Generation:** Smart service layer logic that shuffles cards seamlessly upon every request.
* **Interactive UI:** Clean 3D-flipping flashcard design leveraging Bootstrap 5 and customized Thymeleaf styling.
* **Persistent Storage:** Lightweight file-based persistent H2 database to retain data across applications restarts.
* **Database Seeding:** Automatic schema generation and seed management to deploy ready-to-test dummy data.

## 🛠️ Tech Stack
* **Backend:** Java 21, Spring Boot (Web, Data JPA), Thymeleaf Engine
* **Database:** H2 Database (File Mode)
* **Frontend:** HTML5, CSS3, Bootstrap 5
* **Build Tool:** Maven

## 📦 Project Structure
```text
src/main/java/com/portfolio/mandarin_flashcard/
├── config/             # Database Seeding and Configurations
├── controller/         # Web HTTP Endpoints Mapping
├── model/              # Database Entity Definitions
├── repository/         # Data Access Layer (JPA Repositories)
└── service/            # Core Business Logic Layer
```

## ⚙️ Setup & Installation

### Prerequisites
* Java JDK 21
* Maven (or Maven Wrapper included)

### How to Run Locally
1. Clone the repository:
   ```bash
   git clone https://github.com
   cd mandarin-flashcard
   ```
2. Configure environment variable and boot up the system using terminal:
   ```powershell
   $env:JAVA_HOME="PATH_TO_YOUR_JDK_21"
   ./mvnw spring-boot:run
   ```
3. Access the web interface in your preferred browser:
   ```text
   http://localhost:8080
   ```
