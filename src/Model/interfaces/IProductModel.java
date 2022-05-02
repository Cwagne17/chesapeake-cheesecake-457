package Model.interfaces;

import Model.dto.CreateProductDto;
import Model.dto.UpdateProductDto;
import Model.entities.Product;

import java.util.ArrayList;

public interface IProductModel {

    public ArrayList<Product> getProducts();

    public void createProduct(CreateProductDto createProductDto);

    public void updateProduct(UpdateProductDto updateProductDtoDto);

}
