FROM openjdk:8-jdk-slim
VOLUME /tmp
COPY target/fxdeals-0.0.1-SNAPSHOT.jar fxdeals.jar
ENTRYPOINT ["java","-jar","/fxdeals.jar"]
