# Stage 1 — Build stage
FROM --platform=linux/amd64 eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw package -DskipTests

# Stage 2 — Runtime stage
FROM --platform=linux/amd64 eclipse-temurin:21-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/RealEstate-0.0.1-SNAPSHOT.jar
COPY --from=build /app/${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]