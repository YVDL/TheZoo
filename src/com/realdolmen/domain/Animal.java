package com.realdolmen.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Animal implements Audible {
    private String name;
    private String animalType;
    private LocalDate birthdate;

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

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
        if (birthdate != null) {
            return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
        } else {
            return 0;
        }
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Animal " + "Birthdate: " + birthdate +
                " name: '" + name + '\'' +
                ", age: " + getAge() +
                ", animalType:'" + animalType + '\'';
    }
}
