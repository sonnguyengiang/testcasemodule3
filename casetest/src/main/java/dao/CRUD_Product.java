package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;

public class CRUD_Product {
    static Connection connection = ConnectionCSDL.getConnection();

    public static ArrayList<Product> getList() throws SQLException {
        String select = "select * from product";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Product> list = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            float price = resultSet.getFloat("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            int id_type = resultSet.getInt("id_type");
            String mota = resultSet.getString("mota");
            Product product = new Product(id, name, price, quantity, color, id_type, mota);
            list.add(product);
        }
        return list;
    }

    public static void create(Product product) throws SQLException {
        String create = "INSERT INTO `casetest`.`product` (`name`, `price`, `quantity`, `color`, `id_type`, `mota`) VALUES (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setFloat(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setInt(5, product.getId_type());
        preparedStatement.setString(6, product.getMota());
        preparedStatement.execute();
    }

    public static void delete(int id) throws SQLException {
        String delete = "DELETE FROM `casetest`.`product` WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public static void edit(Product product, int id_edit) throws SQLException {
        String edit = "UPDATE `casetest`.`product` SET `name` = ?, `price` = ?, `quantity` = ?, `color` = ?, `id_type` = ?, `mota` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setFloat(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setInt(5, product.getId_type());
        preparedStatement.setString(6, product.getMota());
        preparedStatement.setInt(7, id_edit);
        preparedStatement.execute();
    }

    public static ArrayList<Product> find(String name_find) throws SQLException {
        String select = "select * from product where name like '%" + name_find + "%'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Product> list = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            float price = resultSet.getFloat("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            int id_type = resultSet.getInt("id_type");
            String mota = resultSet.getString("mota");
            Product product = new Product(id, name, price, quantity, color, id_type, mota);
            list.add(product);
            System.out.println(name);
        }
        return list;
    }

}
