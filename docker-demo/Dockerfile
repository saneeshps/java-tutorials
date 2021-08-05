FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} docker-demo-1.0.jar
ENTRYPOINT ["java","-jar","/docker-demo-1.0.jar"]
