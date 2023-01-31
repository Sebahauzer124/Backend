FROM amazoncorretto:11-alpine-jdk
MAINTAINER ACN
COPY target/Artilugios-0.0.1-SNAPSHOT.jar acn-app.jar
ENTRYPOINT ["java","-jar","/acn-app.jar"]
