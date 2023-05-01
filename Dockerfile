FROM maven:3.8.3-openjdk-8-slim

ENV BROWSER="ch"
ENV ENV="test"
ENV HUB_HOST="localhost"

WORKDIR /app

VOLUME ["$PWD:$WORKDIR"]
# Copy the rest of the project files to the container
COPY . .

# Build and test the project
ENTRYPOINT mvn test -DBROWSER=$BROWSER -DENV=$ENV -DHUB_HOST=$HUB_HOST



