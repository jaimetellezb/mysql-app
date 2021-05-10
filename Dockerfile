FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-jdk-slim
EXPOSE 8085
RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/mysql-app-*-all.jar /app/mysql-app.jar

ENTRYPOINT ["java","-jar", "-Djava.security.egd=file:/dev/./urandom","/app/mysql-app.jar"]