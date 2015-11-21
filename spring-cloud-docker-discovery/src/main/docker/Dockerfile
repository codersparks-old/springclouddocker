FROM java:8
ENV spring.profiles.active=DOCKER
VOLUME /tmp

ADD spring-cloud-docker-discovery.jar app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]