package com.realdolmen.services;

import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.TigerRepository;

import java.sql.SQLException;
import java.util.List;

//Services can act as a Passtrough class and can have some bussiness logic, but it's not necessary
//Anatomy of a Class: AccessModifier class ClassName
public class TigerService {
    //TigerService has a TigerRepository reference
    //Anatomy of a Field or aka Class variable: AccessModifier Type fieldName = new ConstructorName(value aka Argument);
    private TigerRepository tigerRepository = new TigerRepository(); //this is an instance
    //TODO: to be able to link foodRepository to this Service add a FoodRepository field + initiate it

    //Anatomy of a methode: AccessModifier ReturnType methodName(ParameterType parameterName){MethodBody}
    public List<Tiger> getTigers() {
        //TODO: fill in the Food list field of each Tiger in the list
        // HINT: use a for each and call the method findFoodsByAnimalId in FoodRepository to get a food list specific for1 animal
        return tigerRepository.getTigersFromDb(); //return fieldName.methodName();
    }


    public void addATiger(Tiger tiger) { //tiger is the tiger that was created in "addNewTiger" method in MyApplication
        tigerRepository.addATigerInDb(tiger); // tiger is added to DB, see TigerRepository
    }
}
