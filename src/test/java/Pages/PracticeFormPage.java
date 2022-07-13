package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PracticeFormPage {

    private static String baseURL = "https://demoqa.com/automation-practice-form";

    private SelenideElement firstName = $("#firstName");

    private SelenideElement lastName = $("#lastName");

    private SelenideElement email = $("#userEmail");

    private String gender = "#gender-radio-";

    private SelenideElement mobileNumber = $("#userNumber");

    private SelenideElement birthDate = $("#dateOfBirthInput");

    private SelenideElement nextMonth = $(".react-datepicker__navigation.react-datepicker__navigation--next");

    private SelenideElement previousMonth = $(".react-datepicker__navigation.react-datepicker__navigation--previous");

    private SelenideElement monthList = $(".react-datepicker__month-select");

    private SelenideElement yearList = $(".react-datepicker__year-select");

    private SelenideElement currentMonth = $(".react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");

    private SelenideElement subjects = $(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3");

    private ElementsCollection subj = $$(".subjects-auto-complete__menu-list.subjects-auto-complete__menu-list--is-multi.css-11unzgr");

    private SelenideElement address = $("#currentAddress");

    private SelenideElement state = $("#state");

    private ElementsCollection stateList = $$(".css-11unzgr");

    private SelenideElement city = $("#city");

    private ElementsCollection cityList = $$(".css-26l3qy-menu");


}
