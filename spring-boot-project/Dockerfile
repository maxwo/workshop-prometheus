FROM maven:3.5.4-jdk-11 as build

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

RUN set -x \
 && curl -L https://repo1.maven.org/maven2/io/prometheus/jmx/jmx_prometheus_javaagent/0.3.1/jmx_prometheus_javaagent-0.3.1.jar \
    --output /project/jmx_prometheus_javaagent-0.3.1.jar


FROM openjdk:11.0.1-jdk-slim-sid

COPY src/main/docker/root /

COPY --from=build /project/target/*.jar /opt/application
RUN set -x; \
    for jar in $(ls -1 /opt/application/*.jar); \
    do \
    	ln -s ${jar} /opt/application/main.jar; \
    done;

COPY --from=build /project/jmx_prometheus_javaagent-0.3.1.jar /opt/application
ENV JAVA_TOOL_OPTIONS="-javaagent:/opt/application/jmx_prometheus_javaagent-0.3.1.jar=7071:/etc/prometheus/default.yml"

EXPOSE 8080 7071

USER 1001

ENTRYPOINT ["java", "-jar", "/opt/application/main.jar" ]
