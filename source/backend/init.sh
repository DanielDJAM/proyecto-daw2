#!/bin/bash

docker-compose down
mvn clean package
#mv ./target/ecomer-0.0.1-SNAPSHOT ./deployments/
docker-compose up