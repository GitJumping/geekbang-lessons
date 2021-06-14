package org.geektimes.projects.spring.cloud.bus.bridge.config.client.locator;

import org.springframework.core.env.EnumerablePropertySource;

import java.util.Properties;

public class NewPropertySource extends EnumerablePropertySource<Properties> {
    public NewPropertySource(String name, Properties source) {
        super(name, source);
    }

    @Override
    public String[] getPropertyNames() {
        return source.stringPropertyNames().toArray(new String[0]);
    }

    @Override
    public Object getProperty(String name) {
        return source.get(name);
    }
}
