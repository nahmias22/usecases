package com.demo.usecases.common;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UseCaseContext<I> {

    private I input;
    private Map<String, Object> attributes;
    private Function<UseCaseContext, Object> mapper;

    public UseCaseContext() {
    }

    public UseCaseContext(I input) {
        this.input = input;
        this.attributes = new HashMap<>();
    }

    public  UseCaseContext(I input, Function mapper) {

        UseCaseContext<I> ctx = new UseCaseContext(input);
        ctx.setMapper(mapper);
    }

    public I getInput() {
        return input;
    }

    public void attr(String key, Object o) {
        attributes.put(key, o);
    }

    public <T> T attr(String key) {
        return (T) attributes.get(key);
    }

    public void setMapper(Function<UseCaseContext, Object> mapper) {
        this.mapper = mapper;
    }

    public <O> O map() {
        return this.mapper != null ? (O) this.mapper.apply(this) : null;
    }
}
