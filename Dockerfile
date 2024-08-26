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
