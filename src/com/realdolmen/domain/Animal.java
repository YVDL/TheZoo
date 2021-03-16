package com.realdolmen.domain;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
