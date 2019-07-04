FROM openjdk:8-jdk-slim as runtime

WORKDIR /
COPY    . .

EXPOSE 5003

ENTRYPOINT ["java"]
CMD ["-jar", "build/libs/com.magasinudes.microservice-0.1.0.jar"]