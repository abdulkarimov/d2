package org.itstep.jdbc.config;

import org.itstep.jdbc.entity.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDBManager {
    private static final String QUERY = "Select * from test.items";
    private static final String QUERY2 = "insert into test.items values(null,?,?)";
    private static final String QUERY3 = "delete from test.items where id = ?";

    public void setConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "")) {
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllItemspls() {
        List<Items> itemList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery(); //ctrl alt v

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");

                Items items = new Items(id, name, price);
                itemList.add(items);
            }
                System.out.println(itemList.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddItem(String name , Double price) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); PreparedStatement preparedStatement = connection.prepareStatement(QUERY2)) {

            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2, price);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteByID(Integer id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); PreparedStatement preparedStatement = connection.prepareStatement(QUERY3)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
