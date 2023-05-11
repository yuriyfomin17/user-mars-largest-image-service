FROM amazoncorretto:19

COPY target/user-mars-largest-image-service-0.0.1-SNAPSHOT.jar user-mars-largest-image-service

ENTRYPOINT ["java", "-jar", "user-mars-largest-image-service"]