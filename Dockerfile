# Build stage
FROM gradle:jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN chmod +x gradlew
RUN ./gradlew build --no-daemon --stacktrace

# Package stage
FROM eclipse-temurin:21-jdk
COPY --from=build /home/gradle/src/build/libs/WebTechProject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
