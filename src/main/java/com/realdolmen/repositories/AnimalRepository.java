package com.realdolmen.repositories;

import com.realdolmen.domain.Tiger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalRepository {

    public AnimalRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Tiger> getTigers() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "P@ssw0rd")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Tiger");
            ArrayList<Tiger> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                Tiger tigerFromDb = new Tiger(resultSet.getString("Name"));
                arrayList.add(tigerFromDb);
            }
            return arrayList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return Collections.emptyList();
        }
    }
}
