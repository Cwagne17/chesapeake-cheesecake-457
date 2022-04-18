package Model.dto;

import Config.errors.StringException;
import Model.shared.Validator;

public class CreateClientDto {
    private String email_addr;
    private String spouse1_name;
    private String spouse2_name;
    private String name;
    private String phys_addr;
    private String phone_num;
    private String pref_contact;
    private int is_individual;

    public CreateClientDto(
        String email_addr,
        String spouse1_name,
        String spouse2_name,
        String name,
        String phys_addr,
        String phone_num,
        String pref_contact,
        boolean is_individual
    ) throws StringException {
        Validator.isNullEmpty("email_addr", email_addr);
        Validator.isNullEmpty("phys_addr", phys_addr);
        Validator.isNullEmpty("phone_num", phone_num);
        Validator.isNullEmpty("pref_contact", pref_contact);
        if (is_individual) {
            Validator.isNullEmpty("name", name);
        } else {
            Validator.isNullEmpty("spouse1_name", spouse1_name);
            Validator.isNullEmpty("spouse2_name", spouse2_name);
        }

        this.email_addr = email_addr;
        this.spouse1_name = spouse1_name;
        this.spouse2_name = spouse2_name;
        this.name = name;
        this.phys_addr = phys_addr;
        this.phone_num = phone_num;
        this.pref_contact = pref_contact;
        this.is_individual = is_individual ? 1 : 0;
    }

    public String getEmail_addr() {
        return email_addr;
    }

    public String getSpouse1_name() {
        return spouse1_name;
    }

    public String getSpouse2_name() {
        return spouse2_name;
    }

    public String getName() {
        return name;
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
}
