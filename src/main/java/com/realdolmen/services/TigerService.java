package com.realdolmen.services;

import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.TigerRepository;

import java.sql.SQLException;
import java.util.List;

//Anatomy of a Class: AccessModifier class ClassName
public class TigerService {
    //TigerService has a TigerRepository reference
    //Anatomy of a Field or aka Class variable: AccessModifier Type fieldName = new ConstructorName(value aka Argument);
    private TigerRepository tigerRepository = new TigerRepository();

    //Anatomy of a methode: AccessModifier ReturnType methodName(ParameterType parameterName){MethodBody}
    public List<Tiger> getTigers()  {
        return tigerRepository.getTigersFromDb(); //return fieldName.methodName();
    }
}
