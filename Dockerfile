FROM adoptopenjdk/openjdk17:alpline-jre
EXPOSE 8080
COPY target/ServiceAutorization-1.0-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]