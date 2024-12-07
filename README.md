**Quiz-Service**
**Overview**
The Quiz-Service is a core microservice in the Java Quiz Application that manages quizzes and their association with questions. It serves as an intermediary between the Question-Service and the front-end/API Gateway, handling quiz creation, retrieval, and question integration. This microservice is built with Spring Boot and provides RESTful APIs to facilitate quiz management.

**Key Features**
Quiz Management: Create, retrieve, update, and delete quizzes.
Question Integration: Fetch questions from the Question-Service to populate quizzes dynamically.
Service Discovery: Registers with Eureka Server for seamless service discovery and communication with other services.
Load Balancing: Supports multiple instances for scalability.
Fault Tolerance: Configured to work with an API Gateway for error handling and request routing.

**Technologies Used**
Java 17: Primary programming language.
Spring Boot 3.x: Framework for building and running the microservice.
Spring Cloud Netflix Eureka: Service discovery for microservices.
Spring Data JPA: ORM for database interaction.
H2/MySQL/PostgreSQL: MySQL Database for storing quiz data.
Maven: Build and dependency management.
Docker (Optional): Containerization for deployment.

**Project Structure**
src/
├── main/
│   ├── java/
│   │   └── com.example.quizservice/
│   │       ├── controller/    // Contains REST API controllers
│   │       ├── service/       // Business logic layer
│   │       ├── repository/    // Data access layer
│   │       ├── model/         // Entity classes
│   │       └── QuizServiceApplication.java
│   └── resources/
│       ├── application.yml    // Configuration file
│       └── data.sql           // Sample data (if applicable)
└── test/                      // Unit and integration tests

**API Endpoints**
Method	Endpoint	Description
GET	/api/quiz	Fetch all quizzes
GET	/api/quiz/{id}	Fetch a quiz by its ID
POST	/api/quiz	Create a new quiz
PUT	/api/quiz/{id}	Update an existing quiz
DELETE	/api/quiz/{id}	Delete a quiz by its ID
GET	/api/quiz/getQuiz/{id}	Fetch a quiz along with its questions

Running the Service
Prerequisites
Java 17 or higher
Maven
(Optional) Docker
Steps to Run
Clone the repository:
Copy code
git clone https://github.com/yourusername/Quiz-Service.git
cd Quiz-Service

Build the application:
Copy code
mvn clean install

Run the application:
Copy code
mvn spring-boot:run
Access the APIs:

Base URL: http://localhost:8081/api/quiz (or other configured ports)
Eureka Registration
Ensure that the Eureka server is running on port 8761. The Quiz-Service will automatically register with the Eureka server at http://localhost:8761/eureka.

Dependency on Question-Service
The Quiz-Service communicates with the Question-Service to fetch questions. Ensure that:

The Question-Service is up and running.
The API Gateway is configured for proper routing.

**Contribution Guidelines**
Fork the repository.
Create a new feature branch:
Copy code
git checkout -b feature/your-feature-name
Commit and push your changes.
Create a pull request.
