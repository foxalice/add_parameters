package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationTestWithFaker extends TestBase{
    private TestData testData = new TestData();
    @Test
    @Tag("remote")
    void registrationTestSuccessful() {

        step("Открыть страницу регистрации",() -> {
        registrationPagewithfaker.openPage();
        });
        step("Заполнить поля данными",() -> {
        registrationPagewithfaker.setFirstName(testData.firstname)
                .setLastName(testData.lastname)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhone(testData.phone)
                .setUserBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setImage(testData.img)
                .setCurrentAddressInput(testData.adress)
                .setState(testData.state)
                .setCity(testData.city);
        });
        step("Нажать кнопку подтвердить",() -> {
        registrationPagewithfaker.clickSubmitButton();
        });
        step("Модальное окно с проверочными данными становится видимым",() -> {
        registrationPagewithfaker.RegistrationResultsModal();
        });
        step("Проверить введенные данные",() -> {
        registrationPagewithfaker
                .verifyTableValues("Student Name", testData.firstname + " " + testData.lastname)
                .verifyTableValues("Student Email", testData.email)
                .verifyTableValues("Gender", testData.gender)
                .verifyTableValues("Mobile", testData.phone)
                .verifyTableValues("Date of Birth", testData.birthDay+" "+testData.birthMonth+","+testData.birthYear)
                .verifyTableValues("Address", testData.adress)
                .verifyTableValues("Subjects", testData.subjects[0])
                .verifyTableValues("Hobbies", testData.hobbies[0])
                .verifyTableValues("Picture", testData.img)
                .verifyTableValues("State and City", testData.state);
        });

    }

}
