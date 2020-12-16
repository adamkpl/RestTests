# REST Automation tests
Basic examples of API tests.

## Services under test

[Restful-Booker](https://restful-booker.herokuapp.com/)  
[{JSON} Placeholder](https://jsonplaceholder.typicode.com/)

### Test execution

Run any of these commands via CLI or use the `/.run` configurations in IntelliJ IDEA:

```maven
mvn clean test
```
```maven
mvn clean package
```
```maven
mvn -Dtest=com.herokuapp.restfulbooker.** test
```
```maven
mvn --Dtest=com.typicode.jsonplaceholder.** test
```

## Built With
- Java 8
- Maven - dependency management
- REST Assured - Java domain-specific language for easy testing of REST services
- JUnit - a unit test framework
- AssertJ Fluent Assertions
- JSON In Java
- Jackson Databind