FROM java:8

ADD spring-cloud-docker-discovery.jar app.jar

ENV spring.profiles.active DOCKER
# The dependency defines the service(s) this depends upon
ENV SCD_EUREKA_HOST eureka
ENV SCD_EUREKA_PORT 8761
VOLUME /tmp

RUN bash -c 'touch /app.jar'

EXPOSE 8761

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]