package Model.entities;

import Config.errors.StringException;
import Model.shared.Validator;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private String email_addr;
    private String phys_addr;
    private String phone_num;
    private String pref_contact;
    private boolean is_individual;

    public Client() {}

    @Override
    public String toString() {
        return "Client{" +
                "email_addr='" + email_addr + '\'' +
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

    public boolean isIs_individual() {
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
            default:
                throw new StringException(String.format("INTERNAL SERVICE ERROR, %s does not exist on type Client.", key));
        }
    }

    private void setEmail_addr(String key, String email_addr) throws StringException {
        Validator.isNullEmpty(key, email_addr);
        this.email_addr = email_addr;
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

    private void setIs_individual(boolean is_individual) throws StringException {
        this.is_individual = is_individual;
    }
}
