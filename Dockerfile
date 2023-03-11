FROM openjdk:17
ADD target/api-0.1.jar api.jar
ENTRYPOINT ["java", "-jar","api.jar"]
EXPOSE 8080