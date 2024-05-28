FROM openjdk:11.0.7-jdk

RUN mvn clean package install

EXPOSE 8080

WORKDIR /applications

COPY target/*.jar /applications/simple-cache.jar

ENTRYPOINT ["java","-jar", "simple-cache.jar"]
