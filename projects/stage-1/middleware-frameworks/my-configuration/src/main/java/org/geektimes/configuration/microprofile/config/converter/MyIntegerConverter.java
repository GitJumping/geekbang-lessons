package org.geektimes.configuration.microprofile.config.converter;

public class MyIntegerConverter implements MyOrderedConverter<Integer> {

    public final int order;

    public MyIntegerConverter() {
        this(DEFAULT_ORDERED);
    }

    public MyIntegerConverter(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public Integer convert(String value) throws IllegalArgumentException, NullPointerException {
        if (value == null || value.isEmpty())
            throw new NullPointerException();
        return Integer.decode(value);
    }
}
