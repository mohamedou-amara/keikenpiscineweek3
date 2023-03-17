FROM openjdk:17-jdk

WORKDIR /app

COPY target/week2day4exercice.jar week2day4exercice.jar

ENTRYPOINT ["java", "-jar", "week2day4exercice.jar"]
