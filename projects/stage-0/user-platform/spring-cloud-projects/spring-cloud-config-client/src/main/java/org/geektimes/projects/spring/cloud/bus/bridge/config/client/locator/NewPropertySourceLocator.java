package org.geektimes.projects.spring.cloud.bus.bridge.config.client.locator;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Properties;

public class NewPropertySourceLocator implements PropertySourceLocator {
    private final static String DEFAULT_LOCATION = "classpath:config/default.properties";

    @Override
    public PropertySource<?> locate(Environment environment) {
        Properties properties = new Properties();
        try {
            ResourceLoader resourceLoader = new DefaultResourceLoader(getClass().getClassLoader());
            Resource resource = resourceLoader.getResource(DEFAULT_LOCATION);
            properties.load(resource.getInputStream());
        } catch (IOException ignored) {
        }
        return new NewPropertySource("myPropertySource", properties);
    }

}
