FROM maven:3.8.2-jdk-8

WORKDIR /tpachat
COPY . .
COPY pom.xml .
COPY src ./src
RUN mvn clean package -Dmaven.test.skip -DskipTests
EXPOSE 8080


CMD mvn spring-boot:run
