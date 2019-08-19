# Hyperon Telco-Configurator Demo App

This is a sample configuration application to demonstrate capabilities of Hyperon.io library. 

Hyperon.io tutorials are availble [here](https://hyperon.io/tutorials/getting-started).

## Prerequisites

Make sure you have at least:

#### Java 11

#### Maven 3.5 

To install go to:

https://maven.apache.org/download.cgi

Previous Maven versions might work as well but this was not checked. 

#### Hyperon Studio 1.6.49

1. Go to:

https://hyperon.io/download
 
2. download bundle, unpack it to the directory of your choice and run it as described [here](http://hyperon.io/tutorials/deploying-hyperon-studio). 

## Setup

Make sure that ```mvn``` command is accesible through system path. If not, add them.

In file ```backend/src/main/resources/application.yml``` set ```hyperon.database.url``` to point Hyperon Studio H2 database file, e.g.:
```text
hyperon.database.url=jdbc:h2:/srv/hyperon-studio-1.6.49/database/hyperon.demo;AUTO_SERVER=TRUE;MVCC=TRUE;IFEXISTS=TRUE
```
or on Windows
```text
hyperon.database.url=jdbc:h2:c:/hyperon-studio-1.6.49/database/hyperon.demo;AUTO_SERVER=TRUE;MVCC=TRUE;IFEXISTS=TRUE
```

## Running

There are couple ways to run this demo.

### Create and deploy war file
You need tomcat server (9.x, can be downloaded [here](https://tomcat.apache.org/download-90.cgi)). Download and extract it 
anywhere. Go back to this demo, execute below maven command:
```text
mvn clean install
```
it will produce ```telco-configurator.war``` in ```backend/target``` directory. All you need to do is move war file to ```webapps``` 
directory in extracted tomcat directory and run server. Application will be available on:
```localhost:8080/telco-configurator```

### Run backend and frontend separately
2. Go to ```backend``` directory, execute below commands:
```text
mvn clean package
mvn spring-boot:run
```
This will start backend server accessible on port 8080.

In another terminal, go to ```frontend``` directory, execute below command:
```text
mvn clean install
node\npm start
```
This will start angular server accessible on port 4200. If everything ends well, go to 
```localhost:4200/telco-configurator```

### Run with Docker
This demo application can be run in docker container based on provided Dockerfile. For building image execute code below:
```text
docker build -t telco-configurator-demo .
```
Build is optional since telco-configurator-demo is available on docker hub:
```text
hyperonio/telco-configurator-demo:latest
```
If image is build, then application can be run in docker container like:
```text
docker run -p 38080:8080 
    -e mpp.database.url=<jdbc_url_to_running_db>
    -e mpp.database.dialect=<choose>
    -e mpp.database.username=<db_username>
    -e mpp.database.password=<db_password>
    -e mpp.environment.id=hyperon_docker
    telco-configurator-demo
```
OR application can be run with bundle-h2-demo and hyperon-studio images using docker-compose based on docker-compose.yml. Simply run:
```text
docker-compose up
```

* By default Hyperon Studio will be available at: [host]:38080/hyperon/app
* By default Demo application will be available at: [host]:48080/telco-configurator
## Studio Configuration

To configure business elements used in this demo just run downloaded bundle from ```hyperon.io```. All business data is located under TELCO profile.