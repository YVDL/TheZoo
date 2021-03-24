package com.realdolmen.domain;

public class Tiger {
    private String name;

    public Tiger(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tiger{name='" + name + '\'' + '}';
    }
}
