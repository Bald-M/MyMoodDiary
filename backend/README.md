# Quick Start

## Prerequisites
- **Java**: 17.0.12 or higher
- **Maven**: 3.9.9 or higher (or use the included Maven Wrapper)
- **MongoDB**: A running MongoDB instance (local or remote)

## Running Locally
You can run the application directly without creating a JAR first:
```bash
# Windows
mvnw.cmd spring-boot:run

# macOS / Linux
./mvnw spring-boot:run
```
This will:
1. Download and install all dependencies.
2. Compile the code and launch the embedded Tomcat server on port 8080 by default.

## Deployment
### 1. Build the Production JAR
```bash
# Windows
mvnw.cmd clean package -DskipTests

# macOS / Linux
./mvnw clean package -DskipTests
```
The executable JAR will be generated under `target/`

### 2. Run the JAR on Your Server
Copy the JAR to your server (e.g., via scp or CI/CD pipeline), then:
```bash
java -jar \
  -Dspring.profiles.active=prod \
  -Xms512m -Xmx1g \
  target/[jarname].jar
```
