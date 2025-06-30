# Fase de construcción
FROM maven:3.8.6-openjdk-11 AS build

# 1. Primero copia solo el POM para cachear dependencias
COPY pom.xml /app/
WORKDIR /app
RUN mvn dependency:go-offline -B

# 2. Luego copia el código fuente y compila
COPY src /app/src/
RUN mvn clean package -DskipTests

# Fase de ejecución
FROM openjdk:11-jre-slim

# Copia el JAR con nombre consistente
COPY --from=build /app/target/graphqludea-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]