package com.realdolmen.repositories;

import com.realdolmen.domain.Food;
import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.util.PropertiesLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    private final String url = PropertiesLoader.loadPropertiesFile().getProperty("db.url");
    private final String user = PropertiesLoader.loadPropertiesFile().getProperty("db.user");
    private final String password = PropertiesLoader.loadPropertiesFile().getProperty("db.password");

    public List<Food> getAllFoodFromDb() {
        List<Food> foodList = new ArrayList<>();
        try (Connection myConnection = DriverManager.getConnection(url, user, password);) {
            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("select * from Food");

            while (myResultSet.next()) {
                int id = myResultSet.getInt("id");
                String name = myResultSet.getString("foodName");
                foodList.add(new Food(id, name));
            }
            return foodList; // return the FoodList
        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
            return foodList;
        }
    }

    //TODO: add t
    // he method findAllFoodByAnimalId(int animalId) which returns a List of Food
    //HINT: select * from Food where animalId = ?
    public List<Food> findAllFoodByAnimalId(int animalId) {
        List<Food> foodList = new ArrayList<>(); /*I've put my list here, so I can also use it in the catch block.
         In that case it will just return an empty list instead of null. That way my application is less prone to NullPointerExceptions . */
        try (Connection myConnection = DriverManager.getConnection(url, user, password);) {
            PreparedStatement myStatement = myConnection.prepareStatement("select * from Food where animalId = ?");//Remember always use a parameterized (?) query, if you need to add values in your query!
            myStatement.setInt(1, animalId);
            ResultSet myResultSet = myStatement.executeQuery();
            while (myResultSet.next()) {
                int id = myResultSet.getInt("id");
                String name = myResultSet.getString("foodName");
                foodList.add(new Food(id, name));
            }
            return foodList; // return the FoodList
        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
            return foodList;
        }
    }

    //TODO: Extra deleteFoodById(int id)
    /*Delete,update or insert normally doesn't return anything (so void).
     But it could, in that case the newly updated,inserted or deleted object is being returned or only the id of that object */
    public void deleteFoodById(int id){
        try (Connection myConnection = DriverManager.getConnection(url, user, password);) {
            PreparedStatement myStatement = myConnection.prepareStatement("delete from Food where id = ?");//Remember always use a parameterized (?) query, if you need to add values in your query!
            myStatement.setInt(1, id);
            myStatement.execute();
        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
        }
    }

    //TODO: Extra add a method updateFoodName(int id, String foodName) <- id is the primary key of Food
    // Update SQL hint:
    // UPDATE Food SET foodName = ? WHERE id = ?
    public void updateFoodName(int id, String foodName){
        try (Connection myConnection = DriverManager.getConnection(url, user, password);) {
            PreparedStatement myStatement = myConnection.prepareStatement("update Food set foodName = ? where id = ?");//Remember always use a parameterized (?) query, if you need to add values in your query!
            myStatement.setString(1, foodName);
            myStatement.setInt(2, id);
            myStatement.execute();
        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
        }
    }
}
