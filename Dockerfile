FROM openjdk:11-slim
MAINTAINER Marcin Michalak <marcin.michalak@decerto.com>

COPY ./backend/target/telco-configurator.war /app/telco-configurator.war
COPY ./docker/app.yml /root/conf/hyperon-demo-app.yml

EXPOSE 8080

WORKDIR /app

ENTRYPOINT ["java","-jar","telco-configurator.war"]
