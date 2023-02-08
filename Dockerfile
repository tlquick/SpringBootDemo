#
# Build stage
#
FROM maven:3.8-openjdk-17-slim AS build
COPY . .
RUN mvn -f pom.xml install 

#
# Package stage
#
FROM openjdk:17-oracle
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8081
EXPOSE 8081
ENTRYPOINT ["java","-jar","demo.jar"]