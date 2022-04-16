package Model.entities;

import Config.errors.StringException;
import Model.shared.Validator;

import java.util.ArrayList;

public class WeddingClient extends Client {
    private String spouse1_name;
    private String spouse2_name;

    public WeddingClient() {}

    @Override
    public String toString() {
        return super.toString() +
            "WeddingClient{" +
                "spouse1_name='" + spouse1_name + '\'' +
                ", spouse2_name='" + spouse2_name + '\'' +
                '}';
    }

    public ArrayList<String> getAttributeNames() {
        ArrayList attributes = super.getAttributeNames();
        attributes.add("spouse1_name");
        attributes.add("spouse2_name");
        return new ArrayList<String>(attributes);
    }

    public void setAttribute(String key, String value) throws StringException {
        switch (key) {
            case "spouse1_name":
                this.setSpouse1_name(key, value);
                break;
            case "spouse2_name":
                this.setSpouse2_name(key, value);
                break;
            default:
                super.setAttribute(key, value);
        }
    }

    private void setSpouse1_name(String key, String spouse1_name) throws StringException {
        Validator.isNullEmpty(key, spouse1_name);
        this.spouse1_name = spouse1_name;
    }

    private void setSpouse2_name(String key, String spouse2_name) throws StringException {
        Validator.isNullEmpty(key, spouse2_name);
        this.spouse2_name = spouse2_name;
    }
}
