package Model;

import Config.ConnectionManager;
import Model.entities.Product;
import Model.interfaces.IProductModel;

import java.sql.Connection;
import java.util.ArrayList;

public class ProductModel implements IProductModel {
    private Connection conn;

    public ProductModel() {
        this.conn = ConnectionManager.getConnection();
    }


    @Override
    public ArrayList<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(int id) {
        return null;
    }

    @Override
    public void createProduct(String type, String flavor, String size, int stock) {

    }

    @Override
    public void updateProduct(int id, String type, String flavor, String size, int stock) {

    }
}
