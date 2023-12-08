package by.veremei.tests;

import by.veremei.data.TestData;
import by.veremei.pages.DemoqaFormPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Заполнение формы DemoQA")
@Tag("UI")
public class DemoQaFormTest extends BaseTest {
    DemoqaFormPage demoqaFormPage = new DemoqaFormPage();
    TestData data = new TestData();
    private final static String DEMO_QA_PRACTICE_FORM_URL = "/automation-practice-form",

            // Label in table (key)
            STUDENT_NAME = "Student Name",
            STUDENT_EMAIL = "Student Email",
            STUDENT_GENDER = "Gender",
            STUDENT_MOBILE = "Mobile",
            STUDENT_BIRTH = "Date of Birth",
            STUDENT_SUBJECTS = "Subjects",
            STUDENT_HOBBIES = "Hobbies",
            STUDENT_ADDRESS = "Address",
            STUDENT_STATE_AND_CITY = "State and City",
            INVALID_CSS_NAME = "border-color",
            INVALID_CSS_VALUE = "rgb(220, 53, 69)";

    @Test
    @Feature("Заполнение таблицы")
    @Story("Успешное заполнение")
    @Owner("tg - @Veremeioleg")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Заполнение всех полей в таблице и проверка их отображения в форме")
    @Tag("positive")
    void testEnteringCorrectDataIntoTheForm() {
        demoqaFormPage.openPage(DEMO_QA_PRACTICE_FORM_URL)
                .addUserFirstName(data.firstName)
                .addUserLastName(data.lastName)
                .addUserEmail(data.email)
                .checkUserGender(data.gender)
                .addUserPhone(data.phoneNumber)
                .setUserBirth(data.yearBirth, data.month, data.dayOfBirth)
                .selectSubjects(data.subjects)
                .selectHobbies(data.hobbies)
                .choicePicture("1.jpg")
                .addCurrentAddress(data.currentAddress)
                .choiceStateAndCity(data.state, data.city);

        demoqaFormPage.checkSubmittingForm(STUDENT_NAME, data.firstName)
                .checkSubmittingForm(STUDENT_NAME, data.lastName)
                .checkSubmittingForm(STUDENT_EMAIL, data.email)
                .checkSubmittingForm(STUDENT_GENDER, data.gender)
                .checkSubmittingForm(STUDENT_MOBILE, data.phoneNumber)
                .checkSubmittingForm(STUDENT_BIRTH, data.yearBirth)
                .checkSubmittingForm(STUDENT_BIRTH, data.month)
                .checkSubmittingForm(STUDENT_BIRTH, data.dayOfBirth)
                .checkSubmittingForm(STUDENT_SUBJECTS, data.subjects)
                .checkSubmittingForm(STUDENT_HOBBIES, data.hobbies)
                .checkSubmittingForm(STUDENT_ADDRESS, data.currentAddress)
                .checkSubmittingForm(STUDENT_STATE_AND_CITY, data.state)
                .checkSubmittingForm(STUDENT_STATE_AND_CITY, data.city);
    }

    @Test
    @Feature("Заполнение таблицы")
    @Story("Успешное заполнение")
    @Owner("tg - @Veremeioleg")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение обязательных полей в таблице и проверка их отображения в форме")
    @Tag("positive")
    void testEnteringMinimumDataIntoTheForm() {
        step("Открываем страницу с формой", () -> {
            demoqaFormPage.openPage(DEMO_QA_PRACTICE_FORM_URL);
        });
        step("Заполняем обязательные поля", () -> {
            demoqaFormPage.addUserFirstName(data.firstName)
                    .addUserLastName(data.lastName)
                    .checkUserGender(data.gender)
                    .addUserPhone(data.phoneNumber)
                    .sendForm();
        });
        step("Проверяем отображение введенных значений в таблице", () -> {
            demoqaFormPage.checkSubmittingForm(STUDENT_NAME, data.firstName)
                    .checkSubmittingForm(STUDENT_NAME, data.lastName)
                    .checkSubmittingForm(STUDENT_GENDER, data.gender)
                    .checkSubmittingForm(STUDENT_MOBILE, data.phoneNumber);
        });

    }

    @Test
    @Feature("Заполнение таблицы")
    @Story("Неудачное заполнение")
    @Owner("tg - @Veremeioleg")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Отправка пустой формы")
    @Tag("negative")
    void testSendFormWithEmptyFields() {
        step("Открываем страницу с формой", () -> {
            demoqaFormPage.openPage(DEMO_QA_PRACTICE_FORM_URL);
        });
        step("Кликаем на кнопку 'Отправить'", () -> {
            demoqaFormPage.sendForm();
        });
        step("Проверяем что обязательные поля выделились красным", () -> {
            demoqaFormPage.checkInputInvalidBorderColor(INVALID_CSS_NAME, INVALID_CSS_VALUE)
                    .checkRadioInvalidBorderColor(INVALID_CSS_NAME, INVALID_CSS_VALUE);
        });
    }
}
