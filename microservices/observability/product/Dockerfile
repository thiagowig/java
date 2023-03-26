FROM adoptopenjdk/openjdk11:alpine
COPY target/product-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]