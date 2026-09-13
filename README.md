# 🏋️ Workout Tracker API

A Spring Boot REST API that evaluates workout sessions for biomechanical balance and central nervous system (CNS) strain.

This project was developed with the aim of reinforcing the concepts of the **Facade Design Pattern**, cleanly separating the HTTP web layer from domain math and fitness logic.

## 🏗️ Architecture: The Facade Pattern

In standard web applications, controllers often become bloated with business logic. This project addresses that by routing incoming requests through a central orchestrator:

* **`WorkoutSessionController`**: Handles incoming HTTP requests, serializes/deserializes JSON payloads, and returns HTTP responses without performing business calculations.
* **`SessionAnalyticsFacade`**: Central orchestrator. It receives data from the controller and coordinates the execution flow across underlying subsystems.
* **`SymmetryAnalysisService` (Subsystem)**: Analyzes the movement composition of the session (e.g., flagging compound movements like Squats, Leg Presses, or Deadlifts).
* **`NeuromuscularFatigueService` (Subsystem)**: Computes overall session strain using total set volume and average Rating of Perceived Exertion (RPE).

## 🚀 Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x (Spring Web)
* **Build Tool:** Maven
* **Architecture:** RESTful API, Facade Design Pattern

## 💻 Getting Started

### Prerequisites
* JDK 17 or higher
* Git

### Installation & Run
1. Clone the repository:
```bash
git clone [https://github.com/victoraltran/WorkoutTracker.git](https://github.com/victoraltran/WorkoutTracker.git)
```

2. Navigate to the project root:
```bash
cd WorkoutTracker
```

3. Run the application using the Maven wrapper:
```bash
./mvnw spring-boot:run
```
*(On Windows Command Prompt: `mvnw.cmd spring-boot:run`)*

The server will initialize on `http://localhost:8080`.

## 📡 API Reference

### Analyze Workout Session

* **URL:** `/api/v1/sessions/analyze`
* **Method:** `POST`
* **Headers:** `Content-Type: application/json`

#### Request Body
```json
{
  "exercises": [
    "Barbell Squat",
    "Leg Press",
    "Calf Raises"
  ],
  "totalSets": 12,
  "averageRpe": 8
}
```

#### Success Response (`200 OK`)
```json
{
  "balanceRank": "UNBALANCED: HIGH CNS STRAIN, BE CAUTIOUS",
  "fatigueScore": 96
}
```

## 👨‍💻 Author

**Victor Altran Soares**  
Computer Science Student
