FROM tomcat:10.1-jdk17

WORKDIR /app

COPY atividade-7 .

RUN chmod +x mvnw

RUN ./mvnw package

RUN mv target/atividade-7-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/atividade-7-1.war

ENTRYPOINT ["catalina.sh", "run"]