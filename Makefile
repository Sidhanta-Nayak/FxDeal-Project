build:
    ./mvnw clean package

run:
    docker-compose up --build

test:
    ./mvnw test