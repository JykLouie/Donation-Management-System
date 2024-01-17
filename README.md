# Donation Management System

## Project Overview
This project is a **Donation Management System** designed for shelters to manage their donation inventory efficiently. It provides a comprehensive solution for recording and tracking the inflow and outflow of various types of donations, including money, food, and clothing. The system is built using **Java with Spring Boot** for the backend.

## Key Features
- **Donation Registration:** Allows shelter staff to record details of donations, including donor information, donation type, quantity, and date.
- **Donation Distribution:** Logs the distribution of donations, capturing details like type, quantity, and distribution date.
- **Donation Reports:** Generates two types of reports - an inventory report displaying the current status of donations and a donor report summarizing total contributions.

## Getting Started
### Prerequisites
- **Java Development Kit (JDK):** version 11 or later
- **Node.js and npm:** for React frontend
- **Maven:** for building the backend
- Any IDE or text editor (e.g., IntelliJ IDEA, Visual Studio Code)

### Installation
**Clone the Repository:**
```sh
git clone https://github.com/JykLouie/Donation-Management-System
cd Donation-Management-System/backend/codingQuestionBackend
```
### Backend Setup
```sh
mvn spring-boot:run
```

### Running Tests
```sh
mvn test
```

## Usage

### Endpoints

#### 1. **Record Donation**
- **Endpoint:** `/donation/recordDonation`
- **Method:** POST
- **Request Payload:**
  ```json
  {
    "name": "Donor Name",
    "type": "FOOD",
    "quantity": 10,
    "date": "2024-01-11T12:30:00.000Z"
  }
  ```
- **Response: Success:**
  ```json
  {
    "message": "Donation recorded successfully"
  }
  ```
- **Response: Failure:**
  ```json
  {
    "error": "Failed to record donation"
  }
  ```

#### 2. **Record Distribution**
- **Endpoint:** `/donation/recordDistribution`
- **Method:** POST
- **Request Payload:**
  ```json
  {
    "type": "FOOD",
    "quantity": 5,
    "date": "2024-01-11T14:45:00.000Z"
  }
  ```
- **Response: Success:**
  ```json
  {
    "message": "Distribution recorded successfully"
  }
  ```
- **Response: Failure:**
  ```json
  {
    "error": "Failed to record distribution"
  }
  ```

#### 3. **Report Current Status**
- **Endpoint:** `/donation/reportCurrentStatus`
- **Method:** GET
- **Response:**
  ```json
  {
    "FOOD": 50,
    "MONEY": 100,
    "CLOTHING": 20
  }
  ```

#### 4. **Report Donators**
- **Endpoint:** `/donation/reportDonators`
- **Method:** GET
- **Request Payload:**
  ```json
  {
    "type": "FOOD",
    "quantity": 5,
    "date": "2024-01-11T14:45:00.000Z"
  }
  ```
- **Response:**
  ```json
  {
    "Donor1": {
      "FOOD": {
        "2024-01-11T12:30:00.000Z": 10
      },
      "MONEY": {
        "2024-01-10T18:20:00.000Z": 50
      }
    },
    "Donor2": {
      "CLOTHING": {
        "2024-01-12T09:15:00.000Z": 5
      }
    }
  }
  ```
  
