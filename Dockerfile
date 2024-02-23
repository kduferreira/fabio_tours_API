FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-18-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080
COPY --from=build /target/agendamento-api-0.0.1-SNAPSHOT.jar app.js

ENTRYPOINT ["java", "-jar", "app.jar"]