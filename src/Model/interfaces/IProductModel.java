package Model.interfaces;

import Model.entities.Product;

import java.util.ArrayList;

public interface IProductModel {

    public ArrayList<Product> getProducts();

    public Product getProduct(int id);

    public void createProduct(String type, String flavor, String size, int stock);

    public void updateProduct(int id, String type, String flavor, String size, int stock);

}
