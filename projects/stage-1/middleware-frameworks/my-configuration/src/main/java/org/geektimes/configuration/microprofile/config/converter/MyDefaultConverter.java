package org.geektimes.configuration.microprofile.config.converter;

public class MyDefaultConverter implements MyOrderedConverter<String> {
    @Override
    public int getOrder() {
        return DEFAULT_ORDERED;
    }

    @Override
    public String convert(String value) throws IllegalArgumentException, NullPointerException {
        return value;
    }
}
