# DevOps Demo Application 🚀

A simple Spring Boot web application designed for practicing DevOps concepts, CI/CD pipelines, and Jenkins deployment.

## Features

- ✅ RESTful API endpoints
- ✅ Web interface with API testing
- ✅ Spring Boot Actuator for health checks
- ✅ Unit tests with JUnit
- ✅ Maven build system
- ✅ Docker support
- ✅ Jenkins pipeline configuration
- ✅ Easy to deploy and extend

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Docker (optional, for containerization)
- Jenkins (for CI/CD pipeline)

## Quick Start

### 1. Build the Application

```bash
mvn clean package
```

### 2. Run the Application

```bash
java -jar target/devops-demo-app-1.0.0.jar
```

Or using Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 3. Access the Application

- **Web Interface**: http://localhost:8080
- **API Endpoints**:
  - `GET /api/hello` - Simple greeting
  - `GET /api/status` - Application status
  - `GET /api/greet/{name}` - Personalized greeting
  - `POST /api/echo` - Echo JSON payload
  - `GET /actuator/health` - Health check

## Running Tests

```bash
mvn test
```

## Docker Support

### Build Docker Image

```bash
docker build -t devops-demo-app:1.0.0 .
```

### Run Docker Container

```bash
docker run -p 8080:8080 devops-demo-app:1.0.0
```

## Jenkins CI/CD Pipeline

This project includes a `Jenkinsfile` for setting up a CI/CD pipeline.

### Pipeline Stages:

1. **Checkout** - Retrieves code from repository
2. **Build** - Compiles the application
3. **Test** - Runs unit tests
4. **Package** - Creates JAR file
5. **Archive** - Archives build artifacts
6. **Deploy** - Deploys the application (customize as needed)

### Setting up Jenkins:

1. Create a new Pipeline job in Jenkins
2. Configure the repository URL
3. Point to the `Jenkinsfile` in the repository
4. Configure Maven and JDK tools in Jenkins Global Tool Configuration
5. Run the pipeline

### Required Jenkins Plugins:

- Pipeline
- Git
- Maven Integration
- JUnit

### Jenkins Tool Configuration:

Make sure to configure in Jenkins > Global Tool Configuration:
- **Maven** - Name it 'Maven-3.9' (or update Jenkinsfile)
- **JDK** - Name it 'JDK-17' (or update Jenkinsfile)

## Project Structure

```
devops-java-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java      # Main application class
│   │   │   └── ApiController.java        # REST API controller
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html            # Web interface
│   │       └── application.properties    # App configuration
│   └── test/
│       └── java/com/example/demo/
│           └── ApiControllerTest.java    # Unit tests
├── Dockerfile                             # Docker configuration
├── Jenkinsfile                           # Jenkins pipeline
├── pom.xml                               # Maven configuration
└── README.md                             # This file
```

## API Examples

### Using curl:

```bash
# Test hello endpoint
curl http://localhost:8080/api/hello

# Test status endpoint
curl http://localhost:8080/api/status

# Test greet endpoint
curl http://localhost:8080/api/greet/DevOps

# Test echo endpoint
curl -X POST http://localhost:8080/api/echo \
  -H "Content-Type: application/json" \
  -d '{"message":"Hello Jenkins!"}'

# Test health endpoint
curl http://localhost:8080/actuator/health
```

## Customization Ideas

This application is designed to be easily extended. Here are some ideas:

1. Add database connectivity (MySQL, PostgreSQL)
2. Implement authentication and authorization
3. Add more comprehensive tests (integration tests, load tests)
4. Configure different deployment environments (dev, staging, prod)
5. Add monitoring and logging (Prometheus, ELK stack)
6. Implement blue-green or canary deployments
7. Add Kubernetes manifests for container orchestration

## DevOps Practice Scenarios

Use this application to practice:

- ✅ Setting up Jenkins pipelines
- ✅ Automated testing in CI/CD
- ✅ Docker containerization
- ✅ Artifact management
- ✅ Deployment automation
- ✅ Health monitoring
- ✅ Version control with Git
- ✅ Infrastructure as Code
- ✅ Configuration management

## Troubleshooting

### Port already in use

If port 8080 is already in use, change it in `application.properties`:

```properties
server.port=8081
```

### Maven build fails

Ensure you have Java 17 or higher:

```bash
java -version
```

### Jenkins pipeline fails

1. Check Maven and JDK are configured in Jenkins
2. Verify the tool names in Jenkinsfile match your Jenkins configuration
3. Check Jenkins has access to the Git repository

## License

This project is created for educational purposes and DevOps practice.

## Contributing

Feel free to fork this project and add your own enhancements!

---

**Happy Learning! 🎓**
