package Model.entities;

import Config.errors.StringException;
import Model.shared.Validator;

import java.util.ArrayList;
import java.util.Arrays;

public class IndividualClient extends Client {
    private String name;

    public IndividualClient() {}

    @Override
    public String toString() {
        return super.toString() +
            "IndividualClient{" +
                "name='" + name + '\'' +
                '}';
    }

    public ArrayList<String> getAttributeNames() {
        ArrayList attributes = super.getAttributeNames();
        attributes.add("name");
        return new ArrayList<String>(attributes);
    }

    public void setAttribute(String key, String value) throws StringException {
        switch (key) {
            case "name":
                this.setName(key, value);
                break;
            default:
                super.setAttribute(key, value);
        }
    }

    private void setName(String key, String name) throws StringException {
        Validator.isNullEmpty(key, name);
        this.name = name;
    }
}
