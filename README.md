# My dictionary

The sample app what show users a english dictionary of one person. Every user can vote about meaning of every word in dictionary. By result of vote app create chart of words(the most rated word in the top).

## Quickstart

1. Install MySQL on port 3306(by default) or change port in application.properties file
2. Create dictionary (`CREATE DATABASE  IF NOT EXISTS mydictionary;`)
3. Build and run the app (`gradle run`) or use IntelliJ 14+ to run application (main method of MyDictionaryApplication class).
4. Point you browser to `http://localhost:8080`

## Web UI

The application provides a custom web UI using the REST API to display the result of voting in the words chart. Point you browser to `http://localhost:8080`. The UI is rendered using AngularJS and Bootstrap CSS. Words have 3 type: 
- green for words with rating more than 0(zero) 
- yellow for 0 rating words 
- red for less than 0 words
 
![Home page](https://photos-1.dropbox.com/t/2/AABLg8TRJXuGua1ZAOef_oCKuJkEBXl3Usv-5po3CQ8-yQ/12/9510259/jpeg/32x32/1/1437217200/0/2/Dictionary.jpg/CPO6xAQgASACIAMgBCAFIAYgBygBKAI/XnUBwK2KgsmbCSnQNuos6L8ioi9j4r2hloS5pnBvUxY?size=1024x768&size_mode=2)

For adding new word, point your browser to `http://localhost:8080/add`. In this page you find form for adding word name and its meaning. Word saved with default rating 0.

![Add word page](https://photos-3.dropbox.com/t/2/AABFRmncYSAUkznjmh0C2FLSUhKk02gFqieIE6fOtk6PDA/12/9510259/jpeg/32x32/1/1437217200/0/2/addWord.jpg/CPO6xAQgASACIAMgBCAFIAYgBygBKAI/iJQmefRoR1JM8kGglkLQX9tnkd0h8285bgJqnQkVZ30?size=1024x768&size_mode=2)


## Technologies used

- [Spring Boot](http://projects.spring.io/spring-boot/)
- [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
- [Spring Data REST](http://projects.spring.io/spring-data-rest/)
- [MySQL](http://www.mysql.com/)
- [AngularJS](https://angularjs.org/)
- [Bootstrap CSS](http://getbootstrap.com/css/)
- [Gradle](http://gradle.org/)
- [JUnit](http://junit.org/)
