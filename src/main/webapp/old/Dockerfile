# Etapa 1: Construcción del proyecto
FROM maven:3.8.4-openjdk-17 AS build

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias Maven
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Construir la aplicación
RUN mvn package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado desde la etapa de construcción
COPY --from=build /app/target/CasaFacil.jar /app/CasaFacil.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/CasaFacil.jar"]
