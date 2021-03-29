package com.realdolmen.services;

import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.FoodRepository;
import com.realdolmen.repositories.TigerRepository;

import java.util.List;

//Services can act as a Passthrough class, meaning that it just passes objects to methods in the repository.
//it can have some business logic, but it's not necessary.
//Anatomy of a Class: AccessModifier class ClassName
public class TigerService {
    //TigerService has a TigerRepository reference
    //Anatomy of a Field or aka Class variable: AccessModifier Type fieldName = new ConstructorName(value aka Argument);
    private TigerRepository tigerRepository = new TigerRepository(); //this creates an instance/object of TigerRepository and puts it in a variable named 'tigerRepository'

    //TODO: to be able to link foodRepository to this Service add a FoodRepository field + initiate it
    private FoodRepository foodRepository = new FoodRepository();

    //Anatomy of a method: AccessModifier ReturnType methodName(ParameterType parameterName){MethodBody}
    public List<Tiger> getTigers() {
        /* TODO: fill in the Food list field of each Tiger in the list
         * HINT: use a for each and call the method findFoodsByAnimalId in FoodRepository to get a food list specific for 1 animal */
        List<Tiger> tigers = tigerRepository.getTigersFromDb();
        for (Tiger tiger : tigers) {
            tiger.setFoods(foodRepository.findAllFoodByAnimalId(tiger.getId()));
        }
        return tigers; //returns the tiger list because getTigers() has a return type of List<Tiger>
        // and now each tiger also has a list of foods
    }


    public void addATiger(Tiger tiger) { //tiger is the tiger that was created in "addNewTiger" method in MyApplication
        tigerRepository.addATigerInDb(tiger); // tiger table is added to DB, also see TigerRepository
    }
}
