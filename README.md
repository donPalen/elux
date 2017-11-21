<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

## REST service to control an appliance

Prerequisites:

- Java 1.8
- Maven
- IntelliJ IDEA (with lombok plugin)

With Spring Boot, run plain old Java program (`public static void main...`) rather than using a container.

To fire up Spring Boot

```java
public static void main( String[] args ) {
  SpringApplication.run(Application.class, args);
}
```

This starts up Tomcat at [http://localhost:8080](http://localhost:8080).
## Start with command line:
```
java -jar elux.jar
```


### Properties 


To customize port for servlet container (default is 8080):

```
server.port=8181
```

To specify a profile to load, in the IDE run configuration, add a VM argument:

```
-Dspring.profiles.active=test
```

### Available urls:

 [http://localhost:8080/api/v1/all](http://localhost:8080/api/v1/all)
 
 [http://localhost:8080/api/v1/create](http://localhost:8080/api/v1/create)
 
 [http://localhost:8080/api/v1/remove/{id}](http://localhost:8080/api/v1/remove/{id})
 
 [http://localhost:8080/api/v1/update/{id}](http://localhost:8080/api/v1/update/{id})


### Message example:
```
{"id":1,"name":"EWF1286GDW2","description":"Front loader washing machine","status":"UNKNOWN"}
```