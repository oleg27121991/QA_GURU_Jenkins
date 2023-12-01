package by.veremei.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableWithResultComponent {
    private final static SelenideElement tableWithResult = $(".table-responsive");


    public void checkTable(String key, String value) {
        tableWithResult.$(byText(key)).parent().shouldHave(text(value));
    }
}
