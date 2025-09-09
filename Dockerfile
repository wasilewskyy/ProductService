FROM openjdk:21
MAINTAINER jw
COPY target/product-service-0.0.1-SNAPSHOT.jar product-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/product-service-0.0.1-SNAPSHOT.jar"]