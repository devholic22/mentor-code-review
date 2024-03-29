FROM openjdk:17-jdk
WORKDIR /app
EXPOSE 8080
COPY build/libs/code-review-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
