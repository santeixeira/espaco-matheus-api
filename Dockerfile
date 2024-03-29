FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim
EXPOSE 8081
COPY --from=build /build/libs/api-0.0.1-SNAPSHOT-plain.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
