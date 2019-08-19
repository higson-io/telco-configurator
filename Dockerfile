FROM openjdk:11-jdk
MAINTAINER Maciej Główka <maciej.glowka@decerto.pl>
MAINTAINER Artur Osiak <artur.osiak@decerto.pl>

COPY ./backend/target/telco-configurator.war /app/telco-configurator.war
COPY ./docker/app.yml /root/conf/hyperon-demo-app.yml

EXPOSE 8080

WORKDIR /app

ENTRYPOINT ["java","-jar","telco-configurator.war"]