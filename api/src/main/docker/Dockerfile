FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} api##1.0.0.1.jar
ENTRYPOINT ["java", "-jar", "api##1.0.0.1.jar"]