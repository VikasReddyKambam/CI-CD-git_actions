FROM openjdk:21
EXPOSE 8080
ADD target/simpleapi-image.jar simpleapi-image.jar
ENTRYPOINT ["java","-jar","/simpleapi-image.jar"]