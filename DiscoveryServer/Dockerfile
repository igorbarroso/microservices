FROM openjdk:8-jdk-alpine
MAINTAINER igorbarroso14@gmail.com
COPY target/DiscoveryServer-1.0-SNAPSHOT.jar discovery-server.jar
ENTRYPOINT ["java", "-jar", "/discovery-server.jar"]
EXPOSE 8761