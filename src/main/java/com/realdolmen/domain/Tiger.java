package com.realdolmen.domain;

public class Tiger {

    private int id;
    private String name; //moet private staan, encapsulation

    public Tiger(String name, int id) { //constructor
        this.name = name;
        this.id = id;
    }

    public String getName() { //getter
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tiger{id=" + id + ", name=" + name + '}';
    }
}
