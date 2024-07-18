FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/afgc-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_afgc.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_afgc.jar"]