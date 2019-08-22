FROM maven:3.6.0-jdk-12 as builder
COPY / survey_coding_challenge/
WORKDIR survey_coding_challenge
RUN mvn package -D skipTests

FROM openjdk:12
COPY --from=builder survey_coding_challenge/target/surveychallenge-1.0-SNAPSHOT.jar surveychallenge-1.0-SNAPSHOT.jar
CMD ["java", "-jar", "surveychallenge-1.0-SNAPSHOT.jar"]