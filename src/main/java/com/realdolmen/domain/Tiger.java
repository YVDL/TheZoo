package com.realdolmen.domain;

import java.io.Serializable;

public class Tiger  {

    private int id;
    private String name; //moet private staan, encapsulation

    //TODO: Add a List of Foods field + setters & getter

    public Tiger(String name, int id) { //constructor
        this.name = name;
        this.id = id;
    }

    public Tiger(String name) { //overloading, andere parameters dan boven (name, id)
        this.name = name;
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
