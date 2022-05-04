package Model.entities;

import Config.errors.StringException;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;

public class Ingredient {
    private String name;
    private int stock;

    public Ingredient() {}

    public ArrayList<String> getAttributeNames() {
        String[] attributes = {"name", "stock"};
        return new ArrayList<String>(Arrays.asList(attributes));
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setAttribute(String key, String value) throws StringException {
        switch (key) {
            case "name":
                this.setName(value);
                break;
            case "stock":
                this.setStock(Integer.parseInt(value));
                break;
            default:
                throw new StringException(String.format("INTERNAL SERVICE ERROR, %s does not exist on type Client.", key));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
