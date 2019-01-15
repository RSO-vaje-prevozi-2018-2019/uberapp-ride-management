FROM openjdk:8-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/ride-management-api-1.0.0-SNAPSHOT.jar /app

EXPOSE 8084

CMD java -jar ride-management-api-1.0.0-SNAPSHOT.jar