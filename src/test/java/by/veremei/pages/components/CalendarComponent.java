package by.veremei.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final static SelenideElement selectYear = $(".react-datepicker__year-select"),
                                   selectMonth = $(".react-datepicker__month-select");

    public void setDate(String year, String mouth, String day){
        selectYear.selectOption(year);
        selectMonth.selectOption(mouth);
        $(".react-datepicker__day.react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
    }
}
