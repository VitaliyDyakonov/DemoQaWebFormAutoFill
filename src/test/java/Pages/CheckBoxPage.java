package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckBoxPage {

    private String baseURL = "https://demoqa.com/checkbox";

    private SelenideElement expandCloseToggle = $(".rct-icon rct-icon-expand-close");

    private SelenideElement expandOpenToggle = $(".rct-icon rct-icon-expand-open");
}
