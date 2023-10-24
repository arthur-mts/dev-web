FROM tomcat:10.1-jdk17

WORKDIR /app

COPY atividade-8-deploy .

RUN chmod +x mvnw

RUN ./mvnw package

RUN mv target/atividade-8-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/atividade-8.war

RUN mkdir /usr/local/tomcat/webapps/health
RUN mv health.html /usr/local/tomcat/webapps/health/index.html

ENTRYPOINT ["catalina.sh", "run"]