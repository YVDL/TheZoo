package com.realdolmen.domain;

public enum AnimalType {
    APE("ape", new Ape(), 1), LION("lion", new Lion() , 2), TIGER("tiger", new Tiger() , 3);

    private Animal animal;
    private String displayName;
    private int identity;

    AnimalType(String displayName, Animal animal, int identity) {
        this.animal = animal;
        this.displayName = displayName;
        this.identity = identity;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getIdentity() {
        return identity;
    }
}
