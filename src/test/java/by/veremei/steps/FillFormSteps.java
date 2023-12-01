package by.veremei.steps;

import by.veremei.pages.DemoqaFormPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class FillFormSteps {
    DemoqaFormPage demoqaFormPage = new DemoqaFormPage();
    @Step("Открываем страницу с формой")
    public FillFormSteps openFormPage(String url) {
        Selenide.open(url);
        return this;
    }

    @Step("Вводим имя пользователя")
    public FillFormSteps setUserFirstName(String firstName) {
        demoqaFormPage.addUserFirstName(firstName);
        return this;
    }

    @Step("Вводим фамилию пользователя")
    public FillFormSteps setLastName(String lastName) {
        demoqaFormPage.addUserLastName(lastName);
        return this;
    }

    @Step("Вводим email пользователя")
    public FillFormSteps setEmail(String email) {
        demoqaFormPage.addUserEmail(email);
        return this;
    }

    @Step("Выбираем пол пользователя")
    public FillFormSteps checkUserGender(String gender) {
        demoqaFormPage.checkUserGender(gender);
        return this;
    }

    @Step("Вводим телефон пользователя")
    public FillFormSteps setUserPhone(String phone) {
        demoqaFormPage.addUserPhone(phone);
        return this;
    }

    @Step("Выбираем дату рождения пользователя")
    public FillFormSteps checkUserBirth(String year, String mouth, String day) {
        demoqaFormPage.setUserBirth(year, mouth, day);
        return this;
    }

    @Step("Вводим названия предметов")
    public FillFormSteps setSubjects(String subjects) {
        demoqaFormPage.selectSubjects(subjects);
        return this;
    }

    @Step("Выбираем хобби пользователя")
    public FillFormSteps checkUserHobbies(String hobby) {
        demoqaFormPage.selectHobbies(hobby);
        return this;
    }

    @Step("Загружаем изображение")
    public FillFormSteps enterImg(String imgName) {
        demoqaFormPage.choicePicture(imgName);
        return this;
    }

    @Step("Вводим текущий адрес")
    public FillFormSteps setCurrentAddress(String address) {
        demoqaFormPage.addCurrentAddress(address);
        return this;
    }

    @Step("Выбираем штат и город")
    public void checkStateAndCity(String state, String city) {
        demoqaFormPage.choiceStateAndCity(state, city);
    }
}
