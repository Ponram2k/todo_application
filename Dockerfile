FROM eclipse-temurin:21.0.10_7-jre-ubi10-minimal
LABEL authors="Ponram"

COPY target/todo-app.jar todo-app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/todo-app.jar"]