# Getting Started

# Number Transformer

This project is a Spring Boot application that transforms a number (between 0 and 100) into a string based on the following rules:

- If the number is divisible by 3 or contains 3, the string should contain "FOO".
- If the number is divisible by 5 or contains 5, the string should contain "BAR".
- If the number contains 7, the string should contain "QUIX".
- The "divisible by" rule takes precedence over the "contains" rule.
- The number is analyzed from left to right.
- If none of the rules are met, the input number is returned as a string.


### Prerequisites

- Java 17
- Maven

### Running the Application

1. Clone the repository:
    ```sh
    git clone https://github.com/atefcharef/sg-kata-2024.git
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

4. Access the Swagger UI for API documentation:
    ```
    http://localhost:8080/api/v1/transform/swagger-ui/index.html
    ```

## API Endpoints

### Transform Number (GET)

- **URL:** `/api/v1/transform/{number}`
- **Method:** `GET`
- **Path Parameter:**
    - `number` (integer): The number to be transformed.
- **Response:**
    - Returns a string based on the transformation rules.


## Unit Tests

Run the unit tests using Maven:
```sh
mvn test
