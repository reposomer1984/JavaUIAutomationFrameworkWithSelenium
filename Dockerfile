FROM maven:3.8.3-openjdk-8-slim

ENV BROWSER="oo"
ENV ENVNAME="build"
ENV HUB_HOST="1.2.3"

WORKDIR /app

# Copy the rest of the project files to the container
COPY . .

# Build and test the project
CMD mvn  test -Dbrowser=$BROWSER -Denv=$ENVNAME -Dhub_host=$HUB_HOST





