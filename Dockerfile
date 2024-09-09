# Use the official OpenJDK 21 image as the base image
FROM eclipse-temurin:21

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged WAR file into the container at /app
COPY target/auth-api-1.0.0.war /app

RUN mkdir /app/logs

# Expose the port that your application runs on
EXPOSE 8688

# Specify the command to run your application
CMD ["java", "-jar", "-Dspring.profiles.active=prd", "auth-api-1.0.0.war"]
