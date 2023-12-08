package by.veremei.pages;
/**
 * Страница с тестом формы demoqa.com/automation-practice-form
 */

import by.veremei.pages.components.CalendarComponent;
import by.veremei.pages.components.TableWithResultComponent;
import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormPage {
    CalendarComponent calendar = new CalendarComponent();
    TableWithResultComponent table = new TableWithResultComponent();
    private final SelenideElement inputFirstName = $("#firstName"),
                            inputLastName = $("#lastName"),
                            inputUserEmail = $("#userEmail"),
                            radioGender = $(".custom-control-label"),
                            inputUserNumber = $("#userNumber"),
                            inputCalendar = $("#dateOfBirthInput"),
                            inputSubjects = $("#subjectsInput"),
                            checkboxHobbies = $("#hobbiesWrapper"),
                            inputUploadPicture = $("#uploadPicture"),
                            textAreaCurrentAddress = $("#currentAddress"),
                            selectState = $("#react-select-3-input"),
                            selectCity = $("#react-select-4-input"),
                            buttonSendForm = $("#submit");

    @Step("Открываем страницу с формой, убираем рекламу и футер")
    public DemoqaFormPage openPage(String url) {
        Selenide.open(url);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return  this;
    }

    @Step("Вводим имя пользователя")
    public DemoqaFormPage addUserFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    @Step("Вводим фамилию пользователя")
    public DemoqaFormPage addUserLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    @Step("Вводим email пользователя")
    public DemoqaFormPage addUserEmail(String email) {
        inputUserEmail.sendKeys(email);
        return this;
    }

    @Step("Выбираем пол пользователя")
    public DemoqaFormPage checkUserGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    @Step("Вводим телефон пользователя")
    public DemoqaFormPage addUserPhone(String phoneNumber) {
        inputUserNumber.sendKeys(phoneNumber);
        return this;
    }

    @Step("Выбираем дату рождения пользователя")
    public DemoqaFormPage setUserBirth(String year, String mouth, String day){
        inputCalendar.click();
        calendar.setDate(year, mouth, day);
        return this;
    }

    @Step("Вводим названия предметов")
    public DemoqaFormPage selectSubjects(String subjects) {
        inputSubjects.setValue(subjects);
        inputSubjects.pressEnter();
        return this;
    }

    @Step("Выбираем хобби пользователя")
    public DemoqaFormPage selectHobbies(String hobby) {
        checkboxHobbies.$(byText(hobby)).click();
        return this;
    }

    @Step("Загружаем изображение")
    public DemoqaFormPage choicePicture(String imgName) {
        inputUploadPicture.uploadFromClasspath(imgName);
        return this;
    }

    @Step("Вводим текущий адрес")
    public DemoqaFormPage addCurrentAddress(String address) {
        textAreaCurrentAddress.sendKeys(address);
        return this;
    }

    @Step("Выбираем штат и город")
    public void choiceStateAndCity(String state, String city) {
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        selectCity.pressEnter();
    }

    @Step("Кликаем на кнопку 'Отправить'")
    public void sendForm() {
        buttonSendForm.click();
    }

    @Step("Проверяем отображение введенных значений в таблице")
    public DemoqaFormPage checkSubmittingForm(String key, String value) {
        table.checkTable(key, value);

        return this;
    }

    public DemoqaFormPage checkInputInvalidBorderColor(String cssName, String cssValue) {
        inputFirstName.shouldHave(cssValue(cssName, cssValue));
        inputLastName.shouldHave(cssValue(cssName, cssValue));
        inputUserNumber.shouldHave(cssValue(cssName, cssValue));

        return this;
    }

    public void checkRadioInvalidBorderColor(String cssName, String cssValue) {
        radioGender.shouldHave(cssValue(cssName, cssValue));
        radioGender.shouldHave(pseudo(":before", cssName, cssValue));
    }
}
