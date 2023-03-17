# FROM openjdk:17-jdk

# WORKDIR /keikentest_piscine

# # Copy the jar file
# COPY target/week2day4exercice-0.0.1-SNAPSHOT.jar week2day4exercice-0.0.1-SNAPSHOT.jar 
# RUN chmod -R 777  week2day4exercice-0.0.1-SNAPSHOT.jar

# # Copy the wait-for-it.sh script
# COPY wait-for-it.sh wait-for-it.sh

# # Change permissions for the wait-for-it.sh script
# RUN chmod 777 wait-for-it.sh

# # Add the USER root directive
# USER root

# # Start the application
# ENTRYPOINT ["./wait-for-it.sh", "database:3306", "--", "java", "-jar", "/keikentest_piscine/week2day4exercice-0.0.1-SNAPSHOT.jar"]

# #CMD ["java", "-jar", "week2day4exercice-0.0.1-SNAPSHOT.jar"]


# # Use an official OpenJDK 11 image as a parent image
# FROM openjdk:17-jdk

# # Set the working directory to /app
# WORKDIR /app

# # Copy the Maven executable to the container
# COPY mvnw ./
# COPY .mvn .mvn

# # Copy the project configuration files to the container
# COPY pom.xml ./
# COPY src src/

# # Install any required dependencies
# RUN ./mvnw dependency:go-offline

# # Build the application
# RUN ./mvnw package

# # Expose the port that the application will listen on
# EXPOSE 8080

# # Set the environment variable for the Spring profile
# ENV SPRING_PROFILES_ACTIVE=prod

# # Set the command to run the application
# CMD ["java", "-jar", "/app/target/spring-boot-maven-plugin.jar"]

FROM openjdk:17-jdk

WORKDIR /app

COPY target/week2day4exercice.jar week2day4exercice.jar

ENTRYPOINT ["java", "-jar", "week2day4exercice.jar"]
