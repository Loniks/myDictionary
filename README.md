# My dictionary [Demo](englishdictionary.herokuapp.com)

A simple application that shows users an English vocabulary of specific person. Every visitor can rate the meaning of every word in the dictionary of particular. According to the ratings, app creates a chart of words for every user (the most rated words are on the top of the page).
## Quickstart

1. Install PostgreSQL on port 5432(by default) or change port in application.properties file
2. Create dictionary (`CREATE DATABASE  IF NOT EXISTS mydictionary;`)
3. Build and run the app (`gradle run`) or use IntelliJ 14+ to run application (main method of MyDictionaryApplication class).
4. Point you browser to `http://localhost:8080`

## Web UI

The application provides a custom web UI.  Every registered user can vote for several words in dictionaries of other users. UI using the REST API shows the result of voting users in the words chart. The UI is rendered using AngularJS and Bootstrap CSS. Words have 3 type:
- green for words with rating more than 0(zero)
- yellow for 0 rating words 
- red for less than 0 words
 
![Chart](https://cloud.githubusercontent.com/assets/11942950/8761619/df3ee620-2d62-11e5-8b98-6bf3a495bfa5.jpg)

## Technologies used

- [Spring Boot](http://projects.spring.io/spring-boot/)
- [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
- [Spring Data REST](http://projects.spring.io/spring-data-rest/)
- [PostgreSQL](http://www.postgresql.org/)
- [AngularJS](https://angularjs.org/)
- [Bootstrap CSS](http://getbootstrap.com/css/)
- [AngularStrap](http://mgcrea.github.io/angular-strap/)
- [Gradle](http://gradle.org/)
- [JUnit](http://junit.org/)
