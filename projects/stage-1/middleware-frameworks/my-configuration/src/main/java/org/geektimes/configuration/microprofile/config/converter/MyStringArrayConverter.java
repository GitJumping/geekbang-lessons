package org.geektimes.configuration.microprofile.config.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyStringArrayConverter implements MyOrderedConverter<String[]> {

    private final String delimiter;

    private final int order;

    public MyStringArrayConverter() {
        this(",");
    }

    public MyStringArrayConverter(String delimiter) {
        this(delimiter, DEFAULT_ORDERED);
    }

    public MyStringArrayConverter(String delimiter, int order) {
        this.delimiter = delimiter;
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public String[] convert(String value) throws IllegalArgumentException, NullPointerException {
        StringTokenizer tokenizer = new StringTokenizer(value, delimiter);
        List<String> tokens = new ArrayList<>();
        int size = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!delimiter.equals(token)) {
                size++;
                tokens.add(token);
            }
        }
        return tokens.toArray(new String[size]);
    }

}
