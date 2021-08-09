package services;

import dao.CRUD_Product;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductServices {
    public ArrayList<Product> list = new ArrayList<>();

    public void Create(){
        try {
            list = CRUD_Product.getList();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void createProduct(Product product){
        try {
            CRUD_Product.create(product);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        list.add(product);
    }

    public void delete(int index){
        Create();
        try {
            CRUD_Product.delete(list.get(index).getId());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        list.remove(index);
    }

    public void edit(Product product, int index){
        Create();
        try {
            CRUD_Product.edit(product, list.get(index).getId());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        list.set(index, product);
    }
}
