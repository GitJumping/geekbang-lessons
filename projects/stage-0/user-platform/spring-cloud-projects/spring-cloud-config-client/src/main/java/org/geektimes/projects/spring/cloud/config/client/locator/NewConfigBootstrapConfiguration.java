package org.geektimes.projects.spring.cloud.config.client.locator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewConfigBootstrapConfiguration {
    @Bean
    public NewPropertySourceLocator myPropertySourceLocator(){
        return new NewPropertySourceLocator();
    }
}