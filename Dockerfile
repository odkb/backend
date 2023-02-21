FROM amazoncorretto:17-alpine-jdk
ARG JAR_FILE=build/libs/nicu-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} nicuOPBackend.jar
ENTRYPOINT ["java","-jar","nicuOPBackend.jar"]
EXPOSE 8080