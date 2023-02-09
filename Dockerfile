FROM openjdk:11-jre-alpine

EXPOSE 8080

WORKDIR /applications

COPY target/simple-cache-service-0.0.1-SNAPSHOT.jar /applications/simple-cache-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar", "simple-cache-service-0.0.1-SNAPSHOT.jar"]
