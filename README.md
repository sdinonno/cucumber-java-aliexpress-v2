# cucumber-java-aliexpress-v2
This project is an improved version of the project "cucumber-java-aliexpress"

#Tech Stack
    1. Java 1.8
    2. Maven 3.8.3
    3. Cucumber 6.11.0
    4. Selenium 
    5. Chromedriver
    6. TestNG 7.4.0

# Code
On pom.xml you will find dependencies and plugins that we will use for the code.
    
## Drivers folder
On this folder you will find the drivers to user.

## src/test/java
On this folder we will find all the code. It is compose by:
    1. pages:
    2. runner:
    3. stepdefs:
    
## src/test/resources/features
On this folder you will find the features files of the scenarios.

# Execution
Inside the directory where the project is located:
    - mvn test

Other ways to run the tests:
    - mvn test -Dcucumber.options="classpath:features/my_first.feature" to run specific feature.






