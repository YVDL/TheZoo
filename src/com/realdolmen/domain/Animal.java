package com.realdolmen.domain;

public abstract class Animal implements Audible{
    private String name;
    private int age;
    private String animalType;




    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Animal() {

    }

    public String getAnimalType() {
        return animalType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal " +
                "name:'" + name + '\'' +
                ", age:" + age +
                ", animalType:'" + animalType + '\'';
    }
}
