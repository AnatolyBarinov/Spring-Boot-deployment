FROM adoptopenjdk/openjdk17:alpline-jre
EXPOSE 8080
COPY target/ServiceAutorization1.jar app.jar
CMD ["java","-jar","app.jar"]