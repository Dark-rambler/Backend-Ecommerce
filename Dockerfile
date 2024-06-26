# Usa una imagen base de OpenJDK para construir y ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /usr/src/app

# Copia el archivo JAR de la aplicación
COPY target/tu-aplicacion-java.jar .

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8080

# Define el comando que se ejecutará al iniciar el contenedor
CMD ["java", "-jar", "tu-aplicacion-java.jar"]
