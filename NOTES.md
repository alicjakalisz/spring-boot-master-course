Enrol here: https://amigoscode.com/courses/spring-boot-master-class

in the project
running project from intellij - no jar files in target folder
mvn clean - to get read target folder
mvn install - to create targer folder with jar files
mvn clean install

profiles- two application.properties files, one application-dev.properties and in DemoApplication edit:

DemoApplication - you can set up the default profile in program arguments:
--spring.profiles.active=dev

running jar on profiles:
go to target folder and java -jar demo.0.0.1-SNAPSHOT.jar and default one is run.
if you want a specific one: java -jar demo.0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
if you want a few at the same time at two separate tabs of terminal:
java -jar demo.0.0.1-SNAPSHOT.jar --spring.profiles.active=prod --server.port=3000
