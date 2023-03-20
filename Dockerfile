FROM openjdk:8-jdk-alpine
ADD target/oneHundre-0.0.1-SNAPSHOT.jar oneHundre-0.0.1-SNAPSHOT.jar
VOLUME /tmp
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "oneHundre-0.0.1-SNAPSHOT.jar"]