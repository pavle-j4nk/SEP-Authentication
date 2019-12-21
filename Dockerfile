FROM openjdk:11
VOLUME /tmp

ADD authentication.p12 authentication.p12
ADD target/authorization-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
