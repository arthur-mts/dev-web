FROM tomcat:10.1-jdk17

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw package

RUN mv target/atividade-8-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/atividade-8-1.war

ENTRYPOINT ["catalina.sh", "run"]