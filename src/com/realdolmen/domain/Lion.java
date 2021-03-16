package com.realdolmen.domain;

public class Lion extends Animal {



    public Lion() {
        super.setAnimalType("Lion");
    }

    @Override
    public String makeSound() {
        return "Raaawrree";
    }
}
