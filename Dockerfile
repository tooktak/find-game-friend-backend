FROM openjdk:11
ARG JAR_FILE=build/libs/find-my-firend-0.0.1-SNAPSHOT.jar
ARG PROPERTIES_FILE=src/main/recources/application2.yaml

COPY ${JAR_FILE} app.jar
COPY ${PROPERTIES_FILE} application.yaml

