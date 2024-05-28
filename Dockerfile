FROM openjdk:11.0.7-jdk

RUN ./mvnw clean package install

EXPOSE 8080

WORKDIR /applications

COPY target/simple-cache-service-0.0.1-SNAPSHOT.jar /applications/simple-cache-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar", "simple-cache-service-0.0.1-SNAPSHOT.jar"]
