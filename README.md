# GitHub Repo Scanner

A Quarkus-based microservice for retrieving GitHub repository information with branch details, built using Java and Maven.

## Project Structure
```
src
├── main
│   ├── java
│   │   └── com/github/notintoab/grs
│   │       ├── client
│   │       │   └── GitHubApiClient.java
│   │       ├── exception
│   │       │   ├── GitHubResponseFilter.java
│   │       │   ├── GlobalExceptionHandler.java
│   │       │   └── NotFoundOwnerException.java
│   │       ├── model
│   │       │   ├── Branch.java
│   │       │   ├── Commit.java
│   │       │   ├── Owner.java
│   │       │   └── Repo.java
│   │       ├── resource
│   │       │   └── GitHubResource.java
│   │       └── service
│   │           └── GitHubService.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── org/github
            └── GitHubResourceTest.java
```

## Technologies
- Java
- Quarkus 3.19.1
- Maven 3.9.9
- Jackson

## Features
- Retrieve GitHub repositories for a specific owner
- Filter out forked repositories
- Fetch branch information for each repository
- Custom error handling for non-existent users

## API Endpoint
`GET /github/{ownerLogin}`

### Successful Response Example
```json
[
  {
    "fork": false,
    "branches": [
      {
        "name": "main",
        "commit": {
          "sha": "d5282df397dd10a3dfb0b1a3ac7118fcb5f86081"
        }
      }
    ],
    "name": "Istm-multivariate-crypto-price-forecasting",
    "owner": {
      "login": "notintoab"
    }
  }
]
```

### Error Response Example
```json
{
  "message": "User not found on GitHub",
  "status": 404
}
```

## Prerequisites
- Java 11 or higher
- Maven

## Running the Application
### Development Mode
```bash
./mvnw quarkus:dev
```

### Production Build
```bash
./mvnw clean package
```

## Running Tests
```bash
./mvnw test
```

## Key Components
- `GitHubResource`: REST controller
- `GitHubService`: Business logic for repository retrieval
- `GitHubApiClient`: GitHub API interaction client
- `GitHubResponseFilter`: Custom response handling
- `GlobalExceptionHandler`: Exception to HTTP response mapping

## Error Handling
- 404 status for non-existent GitHub users
- Custom `NotFoundOwnerException` for handling user lookup failures
