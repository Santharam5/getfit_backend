 # Use official Java 17 LTS image
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper scripts and pom.xml first
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Download dependencies for offline build cache
RUN ./mvnw dependency:go-offline

# Copy the entire source code
COPY src ./src

# Package the Spring Boot application into a jar
RUN ./mvnw package -DskipTests


# Expose port 8080 to allow external access
EXPOSE 8080

# Run the jar file when the container starts
CMD ["java", "-jar", "target/getfit-0.0.1-SNAPSHOT.jar"]

