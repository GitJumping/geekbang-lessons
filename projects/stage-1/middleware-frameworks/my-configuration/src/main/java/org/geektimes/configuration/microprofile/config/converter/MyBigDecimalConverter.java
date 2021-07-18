package org.geektimes.configuration.microprofile.config.converter;

import java.math.BigDecimal;

public class MyBigDecimalConverter implements MyOrderedConverter<BigDecimal>{

    public final int order;

    public MyBigDecimalConverter() {
        this(DEFAULT_ORDERED);
    }

    public MyBigDecimalConverter(int order) {
        if (order < 0)
            throw new IllegalArgumentException();
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public BigDecimal convert(String value) throws IllegalArgumentException, NullPointerException {
        if (value == null || value.isEmpty())
            throw new NullPointerException();
        return new BigDecimal(value);
    }
}
