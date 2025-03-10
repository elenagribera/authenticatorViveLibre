# Construction fase
FROM maven:3.8.6-openjdk-8 AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

# Execution fase
FROM openjdk:8-jre-alpine
COPY --from=build /app/target/*.jar /app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]