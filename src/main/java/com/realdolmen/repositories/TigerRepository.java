package com.realdolmen.repositories;

import com.realdolmen.domain.Tiger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Repository communicates with the database
//Anatomy of a Class: AccessModifier class ClassName
public class TigerRepository {


    //Anatomy of a method: AccessModifier ReturnType methodName(ParameterType parameterName){MethodBody}
    public List<Tiger> getTigersFromDb() { //
        String url = "jdbc:mysql://localhost:3306/zoo"; //STEP2
        try (Connection myConnection = DriverManager.getConnection(url, "root", "P@ssw0rd");) { //STEP3 and STEP7 Try-With-Resource makes it possible to autoclose the connection
            Statement myStatement = myConnection.prepareStatement("select * from Tiger"); //STEP4 creates a statement Object
            ResultSet myResultSet = myStatement.executeQuery("select * from Tiger"); //STEP5 executes the SQL query
            // first create a list of Tigers to add the tiger objects
            List<Tiger> myTigerList = new ArrayList<>(); //We need to convert the results from the DB 'ResultSet' to a Java ArrayList
            while (myResultSet.next()) { //STEP6 works like Excel with next you move the cursor to the row in the resultset
                int id = myResultSet.getInt("id"); // get the value from the 'id' column in the resultset
                String name = myResultSet.getString("name"); // get the value from the 'name' column in the resultset
                myTigerList.add(new Tiger(name, id)); //add a new Tiger object to the list
            }
            return myTigerList; // return the TigerList

        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
            return null; // the getTigersFromDb() method has a return type List<Tiger> so it's required that this returns something
        }
    }

    public void addATigerInDb(Tiger tiger) { //linked from TigerService (Tiger tiger) is what this addATigerInDb receives
        String url = "jdbc:mysql://localhost:3306/zoo";
        Connection myConnection = null;
        try {
            myConnection = DriverManager.getConnection(url, "root", "P@ssw0rd");
            //INSERT INTO table_name (column1, column2, column3, ...)
            //VALUES (value1, value2, value3, ...);
            myConnection.setAutoCommit(false);

            PreparedStatement myStatement = myConnection.prepareStatement("insert into Tiger(name) values (?)");
            myStatement.setString(1, tiger.getName()); //Use setString instead of getString, also set doesn't return anything
            myStatement.execute();
            if (true) {
                throw new SQLException("BUG !!!!");
            }
            myConnection.commit();// at the end of the try block, this commits the Data to the DB
        } catch (SQLException e) {
            while (e != null) {
                try {
                    myConnection.rollback();
                    System.out.println(e);
                    e = e.getNextException();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }finally {
            try {
                myConnection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
