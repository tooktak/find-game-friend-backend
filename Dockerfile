FROM openjdk:11
ARG JAR_FILE=build/libs/find-my-firend-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

