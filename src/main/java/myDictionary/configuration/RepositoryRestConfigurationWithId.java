package myDictionary.configuration;

import myDictionary.domain.Word;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Customized application configuration for Spring Data REST. Class is adding to JSON object of {@link Word}
 * instances Id.
 *
 * @author Dmytro Bondar
 * @see org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
 */
@Configuration
public class RepositoryRestConfigurationWithId  extends RepositoryRestMvcConfiguration {

    /**
     * Method is changing config of {@code RepositoryRestConfiguration} for exposing Id for {@link Word} instance.
     *
     * @param config
     * @see org.springframework.data.rest.core.config.RepositoryRestConfiguration
     */
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Word.class);
    }
}