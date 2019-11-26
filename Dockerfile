#
# Build stage
#
FROM maven:3.5.2-jdk-8-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY agenciasBCP.json /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/agenciaApi-0.0.1-SNAPSHOT.jar /usr/local/lib/agenciaApi-0.0.1-SNAPSHOT.jar
COPY --from=build /home/app/agenciasBCP.json /agenciasBCP.json

ENTRYPOINT ["java","-jar","/usr/local/lib/agenciaApi-0.0.1-SNAPSHOT.jar"]
