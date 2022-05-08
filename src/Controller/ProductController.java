package Controller;

import Config.errors.StringException;
import Model.ProductModel;
import Model.entities.Product;
import Utils.TableHelpers;
import View.Product.ProductDashboard;
import View.Product.ProductForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private ProductModel productModel = new ProductModel();
    private ProductForm form;
    private ProductDashboard dash;
    private JTable table;

    private List<Product> products;

    public ProductController(ProductDashboard dash) {
        this.dash = dash;
    }

    public ProductController(ProductForm form) {
        this.form = form;
    }

    public void submitProduct(){
        // submit product
        String type = this.form.getTypeText().getText().trim();
        String flavor = this.form.getFlavorText().getText().trim();
        String size = this.form.getSizeText().getText().trim();
        int stock = Integer.valueOf(this.form.getStockText().getText().trim());

        try {
            this.productModel.createProduct(type, flavor, size, stock);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getProducts(){
        try {
            this.products = new ArrayList<>(this.productModel.getProducts());
            table = TableHelpers.getProductTableRows(products);
            this.dash.add(table);
        } catch (SQLException | StringException ex) {
            ex.printStackTrace();
        }
        for(Product product: this.products){
            System.out.println(product);
        }

    }

}
