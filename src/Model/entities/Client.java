package Model.entities;

import Config.errors.StringException;
import Model.shared.Validator;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private String email_addr;
    private String spouse1_name;
    private String spouse2_name;
    private String name;
    private String phys_addr;
    private String phone_num;
    private String pref_contact;
    private int is_individual;

    public Client() {}

    @Override
    public String toString() {
        return "Client{" +
                "email_addr='" + email_addr + '\'' +
                ", spouse1_name='" + spouse1_name + '\'' +
                ", spouse2_name='" + spouse2_name + '\'' +
                ", name='" + name + '\'' +
                ", phys_addr='" + phys_addr + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", pref_contact='" + pref_contact + '\'' +
                ", is_individual=" + is_individual +
                '}';
    }

    public ArrayList<String> getAttributeNames() {
        String[] attributes = {"email_addr", "phys_addr", "phone_num", "pref_contact", "is_individual"};
        return new ArrayList<String>(Arrays.asList(attributes));
    }

    public String getName() {
        return name;
    }

    public String getSpouse1_name() {
        return spouse1_name;
    }

    public String getSpouse2_name() {
        return spouse2_name;
    }

    public String getEmail_addr() {
        return email_addr;
    }

    public String getPhys_addr() {
        return phys_addr;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getPref_contact() {
        return pref_contact;
    }

    public int getIs_individual() {
        return is_individual;
    }

    public void setAttribute(String key, String value) throws StringException {
        switch (key) {
            case "email_addr":
                this.setEmail_addr(key, value);
                break;
            case "phys_addr":
                this.setPhys_addr(key, value);
                break;
            case "phone_num":
                this.setPhone_num(key, value);
                break;
            case "pref_contact":
                this.setPref_contact(key, value);
                break;
            case "is_individual":
                this.setIs_individual(value.equals("1"));
                break;
            case "name":
                this.setName(value);
                break;
            case "spouse1_name":
                this.setSpouse1_name(value);
                break;
            case "spouse2_name":
                this.setSpouse2_name(value);
                break;
            default:
                throw new StringException(String.format("INTERNAL SERVICE ERROR, %s does not exist on type Client.", key));
        }
    }

    private void setEmail_addr(String key, String email_addr) throws StringException {
        Validator.isNullEmpty(key, email_addr);
        this.email_addr = email_addr;
    }

    public void setName(String name) {
        if (name == null)
            name = "";
        this.name = name;
    }

    private void setSpouse1_name(String spouse1_name) {
        if (spouse1_name == null)
            spouse1_name = "";
        this.spouse1_name = spouse1_name;
    }

    private void setSpouse2_name(String spouse2_name) {
        if (spouse2_name == null)
            spouse2_name = "";
        this.spouse2_name = spouse2_name;
    }

    private void setPhys_addr(String key, String phys_addr) throws StringException {
        Validator.isNullEmpty(key, phys_addr);
        this.phys_addr = phys_addr;
    }

    private void setPhone_num(String key, String phone_num) throws StringException {
        Validator.isNullEmpty(key, phone_num);
        this.phone_num = phone_num;
    }

    private void setPref_contact(String key, String pref_contact) throws StringException {
        Validator.isNullEmpty(key, pref_contact);
        pref_contact = pref_contact.toLowerCase();
        if (!(pref_contact.equals("email") || pref_contact.equals("phone"))) {
            throw new StringException("BAD REQUEST, pref_contact must be either email or phone.");
        }
        this.pref_contact = pref_contact;
    }

    private void setIs_individual(boolean is_individual) {
        this.is_individual = is_individual ? 1 : 0;
    }
}
