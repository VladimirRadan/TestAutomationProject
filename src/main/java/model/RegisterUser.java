package model;

import com.github.javafaker.Faker;
import lombok.*;

import java.util.Locale;
@Getter
@Setter
public class RegisterUser {

    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private String postCode;
    private String city;
    private String state;
    private String country;
    private String phoneNumber;
    private String email;
    private String password;

    Faker faker = new Faker(new Locale("en-US"));

    public RegisterUser(){
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.address = faker.address().fullAddress();
        this.postCode = faker.address().zipCode();
        this.city = faker.address().city();
        this.state = faker.address().state();
        this.phoneNumber = faker.number().digits(9);
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password(7, 15, true, true, true);
    }





}
