FROM openjdk:11

ADD build/libs/find-my-firend-0.0.1-SNAPSHOT.jar app.jar
ADD application.yaml application.yaml

