package com.realdolmen.domain;

public class Lion extends Animal {

    public Lion(String name, int age) {
        super(name, age);
    }

    public Lion() {
        super();
    }

    @Override
    public String makeSound() {
        return "Raaawrree";
    }
}
