package org.geektimes.configuration.microprofile.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

public interface MyOrderedConverter<T> extends Converter<T> {
    int getOrder();

    int MAX_ORDERED = 0;
    int MIN_ORDERED = Integer.MIN_VALUE;
    int DEFAULT_ORDERED = 100;
}
