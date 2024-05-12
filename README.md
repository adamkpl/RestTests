# REST Automation tests
Basic examples of webAPI (REST) tests.

## Services under test

[Restful-Booker](https://restful-booker.herokuapp.com/)  
[{JSON} Placeholder](https://jsonplaceholder.typicode.com/)

### Test execution

Run any of these commands via CLI or use the `/.run` configurations in IntelliJ IDEA:

```maven
mvn test
```
```maven
mvn clean package
```

## Built With / Works with
- Oracle Java 8 / OpenJDK 22
- Maven - dependency management
- REST Assured - Java domain-specific language for easy testing of REST services
- JUnit 4 - a unit test framework
- AssertJ Fluent Assertions
- JSON in Java
- Jackson Databind