FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
EXPOSE 8000
COPY ./target/url-shortener.jar url-shortener.jar
ENTRYPOINT ["java", "-jar", "url-shortener.jar"]