FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Neobis_week_3-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]