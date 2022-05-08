package View.Product;


import Controller.ProductController;

import javax.swing.*;

public class ProductDashboard extends JPanel {
    private ProductController productController;

    public ProductDashboard() {
        this.productController = new ProductController(this);
    }

    public void getProducts() {
        productController.getProducts();
    }
}
