FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/author-0.0.1-SNAPSHOT.jar author-api.jar
ENTRYPOINT ["java","-jar","author-api.jar"]