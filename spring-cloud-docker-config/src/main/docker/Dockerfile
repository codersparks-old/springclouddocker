FROM centos:7

RUN yum install -y java-1.8.0-openjdk python-setuptools && easy_install pip && pip install requests
ADD start_service.py start_service.py
ADD spring-cloud-docker-config.jar app.jar

ENV spring.profiles.active DOCKER
# The dependency defines the service(s) this depends upon
ENV SCD_DEPENDENCIES=""
ENV SCD_EUREKA_HOST eureka
ENV SCD_EUREKA_PORT 8761
VOLUME /tmp

RUN bash -c 'touch /app.jar'

EXPOSE 8080

ENTRYPOINT ["python","/start_service.py"]