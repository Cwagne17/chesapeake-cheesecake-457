package Model.entities;

import Config.errors.StringException;

import java.util.ArrayList;
import java.util.Arrays;

public class Package {
    private String name;
    private double cost;

    public ArrayList<String> getAttributeNames() {
        String[] attributes = {"name", "cost"};
        return new ArrayList<String>(Arrays.asList(attributes));
    }

    public void setAttribute(String key, String value) throws StringException {
        switch (key) {
            case "name":
                this.setName(value);
                break;
            case "cost":
                this.setCost(Double.parseDouble(value));
                break;
            default:
                throw new StringException(String.format("INTERNAL SERVICE ERROR, %s does not exist on type Order.", key));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
