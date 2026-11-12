# 🎴 Mandarin Web Flashcard System

A hybrid web learning application and RESTful API built with **Spring Boot** and **Java 21**. Designed to help users master Mandarin vocabulary through interactive 3D flashcards while providing clean JSON endpoints for external client consumption.

This project demonstrates industry-standard **Clean Architecture (Separation of Concerns)**, persistent data storage, automated database seeding, and interactive OpenAPI documentation.

## 🚀 Key Features
* **Hybrid Architecture (SSR & REST API):** Serves a responsive web interface via Thymeleaf alongside stateless JSON RESTful endpoints.
* **Interactive 3D Flashcards:** Smooth CSS 3D-flipping cards powered by Bootstrap 5 with randomized vocabulary generation.
* **RESTful CRUD Operations:** Full API support to fetch all cards, retrieve random cards, add new vocabulary, and delete entries.
* **Interactive API Documentation:** Integrated **Swagger UI (OpenAPI 3)** for live endpoint testing directly from the browser.
* **Persistent Storage & Auto-Seeding:** File-based H2 database to retain data across server restarts, paired with `CommandLineRunner` for initial sample data.

## 🛠️ Tech Stack
* **Backend:** Java 21, Spring Boot (Web, Data JPA), Thymeleaf Engine
* **API & Documentation:** SpringDoc OpenAPI (Swagger UI)
* **Database:** H2 Database (Persistent File Mode)
* **Frontend:** HTML5, CSS3, Bootstrap 5
* **Build Tool:** Maven

## 📦 Project Structure
```text
src/main/java/com/portfolio/mandarin_flashcard/
├── config/             # Database Seeding & System Configurations
├── controller/         # Web MVC (@Controller) & REST API (@RestController) Endpoints
├── model/              # JPA Database Entity Definitions
├── repository/         # Data Access Layer (Spring Data JPA)
└── service/            # Core Business Logic Layer
```

## 🔌 RESTful API Endpoints

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/flashcards` | Retrieve all stored Mandarin flashcards |
| `GET` | `/api/flashcards/random` | Retrieve a single randomized flashcard |
| `POST` | `/api/flashcards` | Add a new flashcard (`hanzi`, `pinyin`, `arti`) |
| `DELETE` | `/api/flashcards/{id}` | Delete a specific flashcard by its ID |

## ⚙️ Setup & Installation

### Prerequisites
* Java JDK 21
* Maven (or included Maven Wrapper)

### How to Run Locally
1. Clone the repository:
   ```bash
   git clone https://github.com
   cd mandarin-flashcard
   ```
2. Run the application using Maven Wrapper:
   ```powershell
   ./mvnw spring-boot:run
   ```
3. Access the application interfaces in your browser:
    * **Web Flashcard UI:** `http://localhost:8080`
    * **Swagger API Documentation:** `http://localhost:8080/swagger-ui/index.html`
    * **H2 Database Console:** `http://localhost:8080/h2-console`
