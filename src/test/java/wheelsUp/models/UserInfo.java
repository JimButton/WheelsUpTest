package wheelsUp.models;

import com.github.javafaker.Faker;

public class UserInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String companyName;
    private String streetAddress;
    private String city;
    private String zipCode;
    private String state;
    private String country;
    Faker faker = new Faker();


    public UserInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = faker.internet().emailAddress();
        this.phoneNumber = faker.phoneNumber().phoneNumber();
        this.companyName = faker.company().name();
        this.streetAddress = faker.address().streetAddress();
        this.city = faker.address().city();
        this.zipCode = faker.address().zipCode();
        this.state = faker.address().state();
        this.country = faker.address().country();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}