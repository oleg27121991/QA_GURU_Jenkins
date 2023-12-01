package by.veremei.pages;
/**
 * Страница с тестом формы demoqa.com/automation-practice-form
 */

import by.veremei.pages.components.CalendarComponent;
import by.veremei.pages.components.TableWithResultComponent;
import com.codeborne.selenide.*;

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


    public void openPage(String url) {
        Selenide.open(url);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public DemoqaFormPage addUserFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);

        return this;
    }

    public DemoqaFormPage addUserLastName(String lastName) {
        inputLastName.sendKeys(lastName);

        return this;
    }

    public void addUserEmail(String email) {
        inputUserEmail.sendKeys(email);
    }

    public DemoqaFormPage checkUserGender(String gender) {
        $(byText(gender)).click();

        return this;
    }

    public DemoqaFormPage addUserPhone(String phoneNumber) {
        inputUserNumber.sendKeys(phoneNumber);

        return this;
    }

    public void setUserBirth(String year, String mouth, String day){
        inputCalendar.click();
        calendar.setDate(year, mouth, day);
    }

    public void selectSubjects(String subjects) {
        inputSubjects.setValue(subjects);
        inputSubjects.pressEnter();
    }

    public void selectHobbies(String hobby) {
        checkboxHobbies.$(byText(hobby)).click();
    }

    public void choicePicture(String imgName) {
        inputUploadPicture.uploadFromClasspath(imgName);
    }

    public void addCurrentAddress(String address) {
        textAreaCurrentAddress.sendKeys(address);
    }

    public void choiceStateAndCity(String state, String city) {
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        selectCity.pressEnter();
    }

    public void sendForm() {
        buttonSendForm.click();
    }

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
