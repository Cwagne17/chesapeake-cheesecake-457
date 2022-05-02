package Model;

import Model.dto.CreateProductDto;
import Model.dto.UpdateProductDto;
import Model.entities.Product;
import Model.interfaces.IProductModel;

import java.util.ArrayList;

public class ProductModel implements IProductModel {
    @Override
    public ArrayList<Product> getProducts() {
        return null;
    }

    @Override
    public void createProduct(CreateProductDto createProductDto) {

    }

    @Override
    public void updateProduct(UpdateProductDto updateProductDtoDto) {

    }
}
