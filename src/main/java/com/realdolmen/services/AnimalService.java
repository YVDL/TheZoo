package com.realdolmen.services;

import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.AnimalRepository;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    private AnimalRepository animalRepository = new AnimalRepository();

    public List<Tiger> getTigers() {
        return animalRepository.getTigers();
    }
}
