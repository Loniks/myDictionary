package myDictionary;

import myDictionary.configuration.RepositoryRestConfigurationWithId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Core Spring Boot application configuration. Used for bootstrap and data setup. With {@code @SpringBootApplication}
 * using annotations {@code @EnableJpaRepositories} for using Spring Data.
 *
 * @author Dmytro Bondar
 */
@SpringBootApplication
@EnableJpaRepositories
public class MyDictionaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDictionaryApplication.class, args);
    }
}
