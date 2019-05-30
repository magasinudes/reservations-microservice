FROM openjdk:8-jdk-slim as runtime

WORKDIR /src
COPY    . .
RUN     ./gradlew test build

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar", "build/libs/reservations-0.1.0.jar"]