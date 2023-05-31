##stage 1: Build
#FROM gradle:7.6.1-jdk17 AS build
#WORKDIR /app
#COPY . .
#RUN gradle clean build -x test --no-daemon
#
##stage 2: Create the final image
#FROM openjdk:17-jdk-slim
#WORKDIR /app
#COPY --from=build /app/build/libs/*.jar app.jar
#EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]

# Slim dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]