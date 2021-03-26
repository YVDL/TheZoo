package com.realdolmen.repositories;

import com.realdolmen.domain.Tiger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Anatomy of a Class: AccessModifier class ClassName
public class TigerRepository {


    //Anatomy of a method: AccessModifier ReturnType methodName(ParameterType parameterName){MethodBody}
    public List<Tiger> getTigersFromDb() {
        String url = "jdbc:mysql://localhost:3306/zoo";
        try(Connection myConnection = DriverManager.getConnection(url,"root","P@ssw0rd");) {
            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("select * from Lion");
            List<Tiger> myTigerList = new ArrayList<>();
            while (myResultSet.next()){
                int id = myResultSet.getInt("id");
                String name = myResultSet.getString("name");
                myTigerList.add(new Tiger(name, id));
            }
            return myTigerList;

        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
            return null;
        }
    }
}
