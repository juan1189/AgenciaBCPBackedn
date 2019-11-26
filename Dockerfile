FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
COPY agenciasBCP.json /tmp
WORKDIR /tmp/
RUN mvn package

#De la imagen que partimos
FROM openjdk:8-jdk-alpine
 
#Directorio de trabajo
WORKDIR /tmp/
#Copiamos el jar en el directorio de trabajo
COPY /target/agenciaApi-0.0.1-SNAPSHOT.jar /app

#Exponemos el puerto 8081
EXPOSE 8081
 
#Comando que se ejecutará una vez ejecutemos el contendor
CMD ["java","-jar","agenciaApi-0.0.1-SNAPSHOT.jar"]