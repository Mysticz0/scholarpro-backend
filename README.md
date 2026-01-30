# ScholarPro Backend

REST API backend for ScholarPro Android app - A CGPA calculator and scholarship eligibility tracker.

## Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Maven**
- **Docker**
- **Kubernetes**
- **Helm**

## API Endpoints

### Add Grade
```
POST /api/grades/add
Body: {"grade": "A-", "weight": 1.0}
```

### Get CGPA
```
GET /api/grades/cgpa
Response: {"currentCGPA": 10.0, "cgpaOverTime": [10.0], "creditsCompleted": 1.0}
```

### Check Scholarship Eligibility
```
POST /api/grades/scholarship-check
Body: {"creditsRemaining": 5.0}
Response: {"averageNeeded": 10.0, "isPossible": true}
```

### Reset Data
```
POST /api/grades/reset
```

## Running Locally

### Prerequisites
- Java 17
- Maven

### Run with Maven
```bash
./mvnw spring-boot:run
```

Server runs on `http://localhost:8080`

## Docker

### Build Image
```bash
./mvnw clean package
docker build -t scholarpro-backend:1.0 .
```

### Run Container
```bash
docker run -p 8080:8080 scholarpro-backend:1.0
```

## Kubernetes Deployment

### Prerequisites
- Minikube
- kubectl

### Deploy
```bash
# Start Minikube
minikube start

# Load Docker image
minikube image load scholarpro-backend:1.0

# Apply deployment
kubectl apply -f k8s-deployment.yaml

# Access service
minikube service scholarpro-backend --url
```

## Helm Deployment

### Prerequisites
- Helm 3.x

### Install
```bash
helm install scholarpro-release ./scholarpro-chart
```

### Upgrade
```bash
helm upgrade scholarpro-release ./scholarpro-chart
```

### Uninstall
```bash
helm uninstall scholarpro-release
```

### Access Service
```bash
minikube service scholarpro-release-scholarpro-chart --url
```

## Project Structure
```
backend/
├── src/
│   └── main/
│       └── java/
│           └── com/scholarpro/backend/
│               ├── BackendApplication.java
│               ├── GradeController.java
│               ├── GraphCalculator.java
│               ├── GradeKey.java
│               ├── GradeRequest.java
│               └── ScholarshipRequest.java
├── Dockerfile
├── k8s-deployment.yaml
├── scholarpro-chart/
│   ├── Chart.yaml
│   ├── values.yaml
│   └── templates/
└── pom.xml
```

## Learning Objectives

This project demonstrates:
- RESTful API design with Spring Boot
- Containerization with Docker
- Container orchestration with Kubernetes
- Package management with Helm
