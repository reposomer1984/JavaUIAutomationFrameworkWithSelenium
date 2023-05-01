FROM maven:3.8.3-openjdk-8-slim

WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .
# Download the project dependencies
RUN mvn -B dependency:resolve
# Copy the rest of the project files to the container
COPY . .
# Build and test the project
RUN mvn clean test -DBROWSER=$BROWSER -DENV=$ENV -HUB_HOST=$HUB_HOST