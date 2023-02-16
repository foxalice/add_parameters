package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("ru"));

    public static String firstname = faker.name().firstName();
    public static String lastname = faker.name().firstName();
    public static String email = faker.internet().emailAddress();

    public String gender = "Female";
    public String phone = "1234567890";
    public String birthDay = "5";
    public String birthMonth = "March";
    public String birthYear = "2009";
    public String subjects [] = {"Economics"};
    public String hobbies [] = {"Sports"};
    public String adress = "Some address 1";
    public String state = "NCR";
    public String city = "Delhi";
    public String img = "1.png";

}
