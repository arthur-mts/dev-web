FROM openjdk:18-alpine

WORKDIR /app

COPY atividade-7 .

RUN chmod +x mvnw

RUN ./mvnw package

RUN wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.15/bin/apache-tomcat-10.1.15.zip

RUN unzip apache-tomcat-10.1.15.zip

RUN mv target/atividade-7-1.0-SNAPSHOT.war /app/apache-tomcat-10.1.15/webapps/atividade-7-1.war
RUN chmod +x /app/apache-tomcat-10.1.15/bin/catalina.sh

ENTRYPOINT ["/app/apache-tomcat-10.1.15/bin/catalina.sh", "run"]