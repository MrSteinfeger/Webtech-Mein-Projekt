# 1. Build-Phase
FROM maven:3.8.5-openjdk-17 AS build
COPY demo /app/demo
WORKDIR /app/demo
RUN mvn clean package -DskipTests

# 2. Run-Phase
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /app/demo/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
