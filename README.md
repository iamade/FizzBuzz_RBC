# FizzBuzz Spring Boot Application

## Overview
This project implements the classic children's game "FizzBuzz" as a stateful microservice using Spring Boot. It provides a RESTful API to interact with the FizzBuzz sequence.

## Features
- **RESTful API**: Exposes a `/next` endpoint to get the next value in the FizzBuzz sequence from 1 to 100.
- **Stateful Design**: Maintains the current state of computation to continue the sequence across multiple API calls.
- **Scalable and Simple**: Ready to be deployed in any modern Java-compatible environment.

## Prerequisites
Before you begin, ensure you have the following installed on your system:
- Java JDK 21 or above
- Maven 3.6 or above

## Getting Started

### Cloning the Repository
Clone the repository to your local machine:

```bash
git clone https://github.com/iamade/FizzBuzz_RBC
cd FizzBuzz_RBC
```

### Building the Application
Navigate to the root directory of the project and run the following command to build the application:
```
./mvnw clean package
```
### Running the Application
After building the application, you can run it using:
```commandline
java -jar target/FizzBuzz-0.0.1-SNAPSHOT.jar
```
### Usage
Once the application is running, you can interact with it by making HTTP GET requests to the /next endpoint:
```commandline
curl http://localhost:8080/next
```
This will return the next number in the FizzBuzz sequence or "Fizz", "Buzz", "FizzBuzz" according to the game's rules.

### Testing
To run the tests included with the application, use the following Maven command:
```commandline
./mvnw test

```