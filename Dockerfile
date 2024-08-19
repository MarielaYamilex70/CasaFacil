## Etapa 1: Construcción del proyecto
#FROM maven:latest AS build
#
## Establecer el directorio de trabajo en el contenedor
#WORKDIR /CasaFacil
#
##Instalar Git en el Entorno de Construcción
#RUN apt-get update && apt-get install -y git
#
## Copiar el archivo pom.xml y descargar las dependencias Maven
#COPY pom.xml .
#RUN mvn dependency:go-offline -B
#
## Copiar el código fuente
#COPY src ./src
#
## Construir la aplicación
#RUN mvn package -DskipTests
#
## Etapa 2: Ejecutar la aplicación
#FROM openjdk:17-jdk-slim
#
## Establecer el directorio de trabajo
#WORKDIR /CasaFacil
#
## Copiar el archivo JAR generado desde la etapa de construcción
#COPY --from=build /CasaFacil/target/CasaFacil-0.0.1-SNAPSHOT.jar /CasaFacil/casa-facil.jar
#
## Exponer el puerto en el que la aplicación se ejecutará
#EXPOSE 8080
#
## Comando para ejecutar la aplicación
#ENTRYPOINT ["java", "-jar", "/CasaFacil/casa-facil.jar"]

#FROM maven:latest
#
#VOLUME  -p /tmp
#
#ENV IMG_PATH=/img
#
#EXPOSE 8080
#
#RUM mkdir -p /img
#
#ADD ./target/CasaFacil-0.0.1-SNAPSHOT.jar casa-facil.jar
#
#ENTRYPOINT ["java", "-jar", "/casa-facil.jar"]

#Para una WEB APP
# Usa una imagen base con un servidor de aplicaciones como Tomcat
FROM tomcat:9.0.73-jdk17-corretto

# Configura el directorio de trabajo en el contenedor
WORKDIR /usr/local/tomcat

# Copia el archivo WAR generado al directorio webapps de Tomcat
#COPY target/CasaFacil-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
COPY target/CasaFacil-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/CasaFacil.war

# Exponer el puerto en el que Tomcat escuchará
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
