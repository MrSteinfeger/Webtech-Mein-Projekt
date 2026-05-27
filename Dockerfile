# 1. Build-Phase: Projekt mit Maven bauen
FROM maven:3.8.5-openjdk-17 AS build
COPY demo /app/demo
WORKDIR /app/demo
RUN mvn clean package -DskipTests

# 2. Run-Phase: Die fertige App mit Java starten
FROM openjdk:17-jdk-slim
COPY --from=build /app/demo/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]