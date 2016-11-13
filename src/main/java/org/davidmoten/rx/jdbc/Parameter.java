package org.davidmoten.rx.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.github.davidmoten.guavamini.Lists;

/**
 * Encapsulates a query parameter.
 */
final class Parameter {

    private final String name;
    /**
     * Actual query parameter value to be encapsulated.
     */
    private final Object value;

    /**
     * Constructor.
     * 
     * @param parameter
     */
    Parameter(Object value) {
        this(null, value);
    }

    Parameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the parameter value.
     * 
     * @return
     */
    Object value() {
        return value;
    }

    boolean hasName() {
        return name != null;
    }

    String name() {
        return name;
    }

    public static ParameterListBuilder named(String name, String value) {
        return new ParameterListBuilder(Lists.newArrayList(new Parameter(name, value)));
    }

    public static class ParameterListBuilder {
        private final List<Parameter> list;

        public ParameterListBuilder(List<Parameter> list) {
            this.list = list;
        }

        public ParameterListBuilder named(String name, String value) {
            list.add(new Parameter(name, value));
            return this;
        }

        public List<Parameter> list() {
            return list;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (value instanceof String)
            builder.append("'");
        builder.append(value);
        if (value instanceof String)
            builder.append("'");
        return builder.toString();
    }

}