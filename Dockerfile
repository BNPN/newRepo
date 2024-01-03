FROM maven:3.8.3-openjdk-17 as build
COPY . .
RUN mvn clean package -nagendra

FROM openjdk:17.0.1-jdk-slim

LABEL  maintainer="javaguides.net"
COPY --from=build/target/ShopC-0.0.1-SNAPSHOT.jar ShopC.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","ShopC.jar" ]
