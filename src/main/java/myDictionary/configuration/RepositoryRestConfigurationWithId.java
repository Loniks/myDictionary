package myDictionary.configuration;

import myDictionary.domain.User;
import myDictionary.domain.Word;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Customized application configuration for Spring Data REST. Class is adding to JSON object of {@link Word} and
 * {@link User} instance Id.
 *
 * @author Dmytro Bondar
 * @see org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
 */
@Configuration
public class RepositoryRestConfigurationWithId extends RepositoryRestConfigurerAdapter {
    /**
     * Method is changing config of {@code RepositoryRestConfigurerAdapter} for exposing Id
     * for {@link Word} and {@link User} instances.
     *
     * @param config
     * @see org.springframework.data.rest.core.config.RepositoryRestConfiguration
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Word.class);
        config.exposeIdsFor(User.class);
    }
}
