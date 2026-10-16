#FROM eclipse-temurin:25-jdk
#WORKDIR /app
#COPY target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]

#1

FROM maven:3.9.9-eclipse-temurin-25 AS build
WORKDIR /opt/app
COPY . .
RUN mvn clean package -DskipTests

#2

FROM eclipse-temurin:25-jre
WORKDIR /opt/app
COPY --from=build /opt/app/target/*.jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]