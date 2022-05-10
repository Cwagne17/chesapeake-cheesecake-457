package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Product;
import Model.interfaces.IProductModel;
import Model.shared.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductModel implements IProductModel {
    private Connection conn;

    public ProductModel() {
        this.conn = ConnectionManager.getConnection();
    }


    @Override
    public ArrayList<Product> getProducts() throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                        "FROM chesapeake457.Product"
        );
        ResultSet res = stmt.executeQuery();
        return this.buildResponse(res);
    }

    @Override
    public Product getProduct(int id) throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                        "FROM chesapeake457.Product" +
                        "WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        ArrayList<Product> products = this.buildResponse(res);
        return products.get(0);
    }

    @Override
    public void createProduct(String type, String flavor, String size, int stock) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO chesapeake457.Product" +
                        "(type, flavor, size, stock)" +
                        "VALUES (?, ?, ?, ?)"
        );
        stmt.setString(1, type);
        stmt.setString(2, flavor);
        stmt.setString(3, size);
        stmt.setInt(4, stock);

        stmt.executeUpdate();
    }

    @Override
    public void updateProduct(int id, String type, String flavor, String size, int stock) throws SQLException, StringException {
        Product curr_product = this.getProduct(id);
        if (Validator.exists(type)) {
            curr_product.setType(type);
        }
        if (Validator.exists(flavor)) {
            curr_product.setFlavor(flavor);
        }
        if (Validator.exists(size)) {
            curr_product.setSize(size);
        }
        if (Validator.exists(Integer.toString(stock))) {
            curr_product.setStock(stock);
        }

        PreparedStatement stmt = this.conn.prepareStatement(
                "UPDATE chesapeake457.Product" +
                        "SET type = ?, flavor = ?, size = ?, stock = ?" +
                        "WHERE (id= ?)"
        );
        stmt.setString(1, type);
        stmt.setString(2, flavor);
        stmt.setString(3, size);
        stmt.setInt(4, stock);
        stmt.setInt(5, id);

        stmt.executeUpdate();
    }

    private ArrayList<Product> buildResponse(ResultSet res) throws SQLException, StringException {
        ArrayList<Product> products = new ArrayList<>();

        ArrayList<String> attributes = new Product().getAttributeNames();
        while (res.next()) {
            Product obj = new Product();
            for(String attr: attributes) {
                obj.setAttribute(attr, res.getString(attr));
            }
            products.add(obj);
        }
        return products;
    }
}
