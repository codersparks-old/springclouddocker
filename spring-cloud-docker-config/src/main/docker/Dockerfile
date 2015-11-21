FROM java:8
VOLUME /tmp
VOLUME /git-repos

ADD spring-cloud-docker-config.jar app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]