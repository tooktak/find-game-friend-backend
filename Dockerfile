FROM openjdk:11

RUN mkdir -p /app
WORKDIR /app

ADD ./build/libs/find-my-firend-0.0.1-SNAPSHOT.jar app.jar
ADD ./src/main/resources/application.yaml application.yaml

