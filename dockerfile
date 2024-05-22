FROM openjdk:17-oracle

WORKDIR /app

# Consider using multi-stage builds for smaller image size:
# https://spring.io/guides/topicals/spring-boot-docker

# Copy JAR from context (replace with your build path if different)
COPY ./target/customerservice-0.0.1-SNAPSHOT.jar customerservice-0.0.1-SNAPSHOT.jar

# Expose port (replace with your application's port)
EXPOSE 8081

# Start the application using the JAR 
ENTRYPOINT ["java", "-jar", "customerservice-0.0.1-SNAPSHOT"] 
