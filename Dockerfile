# Stage 1: Build the application using JDK 25
FROM eclipse-temurin:25-jdk-alpine AS builder
WORKDIR /app

# Copy build files first to leverage Docker layer caching
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Give Maven Wrapper execution permission
RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline -B

# Copy source and package the application
COPY src ./src
RUN ./mvnw package -DskipTests


# Stage 2: Create a minimal runtime image using JRE 25
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Run as a non-root user for production security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy only the compiled JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Optimize JVM settings for container awareness
ENV JAVA_TOOL_OPTIONS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]