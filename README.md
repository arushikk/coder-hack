# CoderHack

CoderHack is a web application designed to manage user registrations and scores for a coding contest. It provides RESTful APIs for registering users, retrieving user details, updating user scores, and deregistering users.

## Features

- **User Registration**: Allows users to register for the coding contest by providing their details.
- **User Details Retrieval**: Retrieves the details of a specific user by their user ID.
- **User Score Update**: Updates the score of a specific user.
- **User Deregistration**: Deregisters a specific user from the contest.

## Technologies Used

- Java
- Spring Boot
- Spring Data MongoDB
- MongoDB
- JUnit
- Mockito

## Setup Instructions

1. Clone the repository: `git clone <repository_url>`
2. Navigate to the project directory: `cd CoderHack`
3. Build the project: `./gradlew build`
4. Run the application: `./gradlew bootRun`

The application will start on `http://localhost:8080`.

## API Documentation

### GET /users

Retrieve a list of all registered users.

### GET /users/{userId}

Retrieve the details of a specific user by their user ID.

### POST /users

Register a new user to the contest.

### PUT /users/{userId}

Update the score of a specific user.

### DELETE /users/{userId}

Deregister a specific user from the contest.

## Testing

Unit tests are provided for the controller and service layers of the application. You can run the tests using the following command:

```bash
./gradlew test
