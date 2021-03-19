package com.realdolmen.domain;

public class Tiger extends Animal {


    public Tiger() {
        super.setAnimalType("Tiger");

    }

    @Override
    public String makeSound() {
        return "Raawr";
    }
}
