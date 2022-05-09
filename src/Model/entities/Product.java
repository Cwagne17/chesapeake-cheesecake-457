package Model.entities;

import Config.errors.StringException;

import java.util.ArrayList;
import java.util.Arrays;

public class Product {
    private int id;
    private String type;
    private String flavor;
    private String size;
    private int stock;

    public ArrayList<String> getAttributeNames() {
        String[] attributes = {"id", "type", "flavor", "size", "stock"};
        return new ArrayList<String>(Arrays.asList(attributes));
    }

    public void setAttribute(String key, String value) throws StringException {
        switch (key) {
            case "id":
                this.setId(Integer.parseInt(value));
                break;
            case "type":
                this.setType(value);
                break;
            case "flavor":
                this.setFlavor(value);
                break;
            case "size":
                this.setSize(value);
                break;
            case "stock":
                this.setStock(Integer.parseInt(value));
                break;
            default:
                throw new StringException(String.format("INTERNAL SERVICE ERROR, %s does not exist on type Order.", key));
        }
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
}
