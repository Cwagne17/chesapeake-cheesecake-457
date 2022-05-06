package Model.interfaces;

import Config.errors.StringException;
import Model.entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductModel {

    public ArrayList<Product> getProducts() throws SQLException, StringException;

    public Product getProduct(int id) throws SQLException, StringException;

    public void createProduct(String type, String flavor, String size, int stock) throws SQLException;

    public void updateProduct(int id, String type, String flavor, String size, int stock) throws SQLException, StringException;

}
