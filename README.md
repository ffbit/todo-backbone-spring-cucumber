# Cucumber, Spring Framework and Backbone.JS todo example

The goal of this project is to test [Backbone.JS todo example]
(http://documentcloud.github.com/backbone/examples/todos/index.html)
with [Cucumber](http://cukes.info/) and shared [Spring JPA]
(http://www.springsource.org/spring-data/jpa) datase transactions.

## How to run web application

1. Run `mvn clean jetty:run` or `mvn clean package t7:run`
2. Open [http://localhost:8080/](http://localhost:8080/) in your favourite browser

## How to test

1. Install [Apache Maven](http://maven.apache.org/)
2. Install [Mozilla Firefox](http://www.mozilla.org/firefox/new/) web browser
3. Run `mvn clean integration-test`

## Status

Unstable
