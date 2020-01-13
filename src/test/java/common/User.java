package common;

import java.util.Date;

public class User {

    private String email;
    private String name;
    private String surname;
    private String password;
    private String BDday;
    private String BDmonth;
    private String BDyear;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state; // Maybe we need to define a class or enum for it. Discuss it in the PR review.
    private String postCode;
    private String other;
    private String phone;
    private String mobile;
    private String alias;


    public User() {
        this.email = generateEmail();

        // The values of the following fields could be generated randomly, or get them from property file via
        // PropertyLoader class which is provided.
        // Discuss with the team in the PR review.
        this.name = "Firstname";
        this.surname = "Lastname";
        this.password = "Qwerty";
        this.BDday = "1";
        this.BDmonth = "1";
        this.BDyear = "2000";
        this.company = "company";
        this.address1 = "Qwerty, 123";
        this.address2 = "zxcvb";
        this.city = "Qwerty";
        this.state = "Colorado";
        this.postCode = "12345";
        this.other = "Qwerty";
        this.phone = "12345123123";
        this.mobile = "12345123123";
        this.alias = "hf";
    }

    private String generateEmail() {
        String timestamp = String.valueOf(new Date().getTime());
        return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getBDday() {
        return BDday;
    }

    public String getBDmonth() {
        return BDmonth;
    }

    public String getBDyear() {
        return BDyear;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getOther() {
        return other;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAlias() {
        return alias;
    }

}

