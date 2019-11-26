#De la imagen que partimos
FROM openjdk:11-jre-slim

#Directorio de trabajo
WORKDIR /app

#Copiamos el uber-jar en el directorio de trabajo
COPY target/agenciaApi-0.0.1-SNAPSHOT.jar /app
COPY agenciasBCP.json /app

#Exponemos el puerto 8081
EXPOSE 8081

#Comando que se ejecutará una vez ejecutemos el contendor
ENTRYPOINT ["java","-jar","agenciaApi-0.0.1-SNAPSHOT.jar"]
