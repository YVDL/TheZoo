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
            Statement myStatement = myConnection.createStatement(); //STEP4 creates a statement Object
            ResultSet myResultSet = myStatement.executeQuery("select * from Tiger"); //STEP5 executes the SQL query
            // first create a list of Tigers to add the tiger objects
            List<Tiger> myTigerList = new ArrayList<>(); //We need to convert the results from the DB 'ResultSet' to a Java ArrayList
            while (myResultSet.next()) { //STEP6 works like Excel with next you move the cursor to the row in the resultset
                int id = myResultSet.getInt("id"); // get the value from the 'id' column in the resultset
                String name = myResultSet.getString("name"); // get the value from the 'name' column in the resultset
                myTigerList.add(new Tiger(name, id)); //add a new Tiger object to the list
            }
            return myTigerList; // return the TigerList, we might not reach here if there's an exception in the code above
        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
            return null; // the getTigersFromDb() method has a return type List<Tiger> so it's required that this returns something
        }
    }

    public void addATigerInDb(Tiger tiger) { //linked from TigerService (Tiger tiger) is what this addATigerInDb receives
        String url = "jdbc:mysql://localhost:3306/zoo?allowMultiQueries=true";
        Connection myConnection = null;
        try { //TRY out this block of code, if an exception occurs it can be caught in the CATCH block
            myConnection = DriverManager.getConnection(url, "root", "P@ssw0rd");
            //INSERT INTO table_name (column1, column2, column3, ...)
            //VALUES (value1, value2, value3, ...);
            myConnection.setAutoCommit(false); //Because we want to manually do Transactions

            PreparedStatement myStatement = myConnection.prepareStatement("insert into Tiger(name) values (?)");
            myStatement.setString(1, tiger.getName()); //Use setString instead of getString, also set doesn't return anything
            myStatement.execute();//executes the query
            myConnection.commit();// at the end of the try block, this commits the Data to the DB and makes it permanent
        } catch (SQLException e) {//CATCH the exception en handle it in this catch block
            while (e != null) {//SQLException can contain nested exceptions, thats why we use the while loop to loop over them
                try {
                    myConnection.rollback(); //if there's an exception rollback everything, so our database doesn't get any invalid values
                    System.out.println(e);
                    e = e.getNextException();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } finally {//FINALLY, always gets executed even when there's an Exception. (Could be an OCA exam question)
            try {
                myConnection.close();//Always close the connection to the database, because it can cause memory leaks https://en.wikipedia.org/wiki/Memory_leak
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
