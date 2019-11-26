#De la imagen que partimos
FROM frolvlad/alpine-oraclejdk8:slim
 
#Directorio de trabajo
WORKDIR /app
 
#Copiamos el uber-jar en el directorio de trabajo
COPY target/agenciaApi-0.0.1-SNAPSHOT.jar /app
 
#Exponemos el puerto 8080
EXPOSE 8080
 
#Comando que se ejecutará una vez ejecutemos el contendor
CMD ["java","-jar","agenciaApi-0.0.1-SNAPSHOT.jar"]