# Hyperon Telco-Configurator Demo App
This is a sample configuration application to demonstrate capabilities of Hyperon.io library. 
Hyperon.io tutorials are available [here](https://www.hyperon.io/docs/tutorials).

## Prerequisites
Make sure you have at least:
- Java 11
- Maven 
To install go to: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
Previous Maven versions might work as well but this was not checked. 
- Higson Studio 4.0.1  
  - Go to: [https://www.hyperon.io/docs/download](https://www.hyperon.io/docs/download)
  - download bundle, unpack it to the directory of your choice and run it as described [here](https://www.hyperon.io/tutorial/installing-hyperon-studio). 
## Setup
Make sure that `mvn` command is accessible through system path. If not, add them.

In file `backend/src/main/resources/application.yml` set `hyperon.database.url` to point Hyperon Studio H2 database file, e.g.:
```properties
hyperon.database.url=jdbc:h2:/your-database-dir/hyperon.demo
```
You can use an attached database in [database](./database) directory
## Running
There are couple ways to run this demo. 

#### 1.Create and deploy war file
You need tomcat server (9.x, can be downloaded [here](https://tomcat.apache.org/download-90.cgi)). Download and extract it 
anywhere. Go back to this demo, execute below maven command:
```shell
mvn clean install
```
it will produce `telco-configurator.war` in `backend/target` directory. 
You can run this war files running below command:
```shell
java -jar telco-configurator.war --spring.config.location=../src/main/resources/ 
```
where `spring.config.location` is a link to [application.yml](./backend/src/main/resources/application.yml) at `backend` project relative to war file 
location 

#### 2.Run backend and frontend separately
Go to `backend` directory, execute below commands:
```shell
mvn clean package
mvn spring-boot:run
```
This will start backend server accessible on port 8080.

In another terminal, go to `frontend` directory, execute below command:
```shell
mvn clean install
npm start
```
This will start angular server accessible on port 4200. If everything ends well, go to [localhost:4200/telco-configurator](localhost:4200/telco-configurator)

#### 3.Run with Docker
telco-configurator-demo is available on docker hub:
```shell
docker pull hyperonio/telco-configurator-demo:latest
```
If you want build application on your own you should: 
This demo application can be run in docker container based on provided [Dockerfile](./Dockerfile). For building image execute code below:
```shell
docker build -t telco-configurator-demo .
```
If image is build, then application can be run in docker container like:
```shell
docker run -p 48080:8080 
    -e hyperon.database.url=<jdbc_url_to_running_db> \
    -e hyperon.database.dialect=<choose> \
    -e hyperon.database.username=<db_username> \
    -e hyperon.database.password=<db_password> \
    -e hyperon.studio.instance-name=hyperon_docker \
    telco-configurator-demo
```

#### 4.Run with Docker compose 
Application can be run with bundle-h2-demo and hyperon-studio images using docker-compose based on [docker-compose.yml](./docker-compose.
yml)
```shell
mvn clean install #prepares application war used in provided Dockerfile

docker-compose up
#or (regarding to docker version) 
docker compose up
```
* By default, Higson Studio will be available at: [host]:38080/higson/app
* By default, Demo application will be available at: [host]:48080/telco-configurator
 
## Studio Configuration
To configure business elements used in this demo just run downloaded bundle from ```hyperon.io```. All business data is located under TELCO profile.
