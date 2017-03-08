FROM maven:3-jdk-8-onbuild

CMD ["java", "-jar", "./target/TriangleCodingChallenge-1.0.0.jar"]
