package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import javax.servlet.ServletRequest;
import java.util.Map;
import java.util.Set;

public class MyServletRequestConfiguration  implements ConfigSource {

    private final ServletRequest servletRequest;

    private final String name;

    public MyServletRequestConfiguration(String name, ServletRequest servletRequest) {
        this.servletRequest = servletRequest;
        this.name = name;
    }

    @Override
    public Set<String> getPropertyNames() {
        return servletRequest.getParameterMap().keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return servletRequest.getParameter(propertyName);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, String> getProperties() {
        return ConfigSource.super.getProperties();
    }

    @Override
    public int getOrdinal() {
        return ConfigSource.super.getOrdinal();
    }
}
