package Tests;

import Pages.RadioButtonPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Pages.RadioButtonPage.openPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWindow;

public class RadioButtonTests {

    RadioButtonPage radioButtonPage = new RadioButtonPage();

    @BeforeAll
    static void setUp(){
        Configuration.browserSize="1920x1080";
    }

    @BeforeEach
    public void prepareForTest(){
        openPage();
    }

    @AfterEach
    public void closePage(){
        closeWindow();
    }

    @Test
    public void chooseYes(){
        radioButtonPage.selectRadio(0);
        radioButtonPage.getResult().shouldHave(text("You have selected "), text("Yes"));
    }

    @Test
    public void chooseImpressive(){
        radioButtonPage.selectRadio(1);
        radioButtonPage.getResult().shouldHave(text("You have selected "), text("Impressive"));
    }

    @Test
    public void chooseAnotherButton(){
        radioButtonPage.selectRadio(0);
        radioButtonPage.getResult().shouldHave(text("You have selected "), text("Yes")).shouldNotHave(text("Impressive"));
        radioButtonPage.selectRadio(1);
        radioButtonPage.getResult().shouldHave(text("You have selected "), text("Impressive")).shouldNotHave(text("Yes"));
    }

}
