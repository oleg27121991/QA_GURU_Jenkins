package by.veremei.steps;

import by.veremei.pages.DemoqaFormPage;
import io.qameta.allure.Step;

public class CheckTableWithResulSteps {
    DemoqaFormPage demoqaFormPage = new DemoqaFormPage();

    @Step("Проверяем отображение введенных значений в таблице")
    public CheckTableWithResulSteps checkSubmittingForm(String key, String value) {
        demoqaFormPage.checkSubmittingForm(key, value);

        return this;
    }
}
