FROM openjdk:11

ADD ./build/libs/find-my-firend-0.0.1-SNAPSHOT.jar app.jar
ADD ./build/resources/application.yaml application.yaml

