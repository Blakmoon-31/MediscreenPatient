FROM openjdk:11-jdk
COPY target/mediscreenPatient-0.0.1-SNAPSHOT.jar mediscreenPatient-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/mediscreenPatient-0.0.1-SNAPSHOT.jar"]