FROM maven:3.5.4-jdk-11 as build2

RUN set -x \
 && mkdir /project
COPY pom.xml /project/pom.xml
RUN set -x \
 && cd /project \
 && mvn dependency:resolve

COPY . /project

RUN set -x \
 && cd /project \
 && mvn package


FROM openjdk:11.0.1-jdk-slim-sid

RUN set -x \
 && mkdir -p /opt/application
COPY --from=build2 /project/target/*.jar /opt/application
RUN set -x; \
    for jar in $(ls -1 /opt/application/*.jar); \
    do \
    	ln -s ${jar} /opt/application/main.jar; \
    done;

EXPOSE 8080 8090

USER 1001

ENTRYPOINT ["java", "-jar", "/opt/application/main.jar" ]
