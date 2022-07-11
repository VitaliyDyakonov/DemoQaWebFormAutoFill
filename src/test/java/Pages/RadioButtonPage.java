package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonPage {

    private static String baseURL = "https://demoqa.com/radio-button";


    private SelenideElement result = $(".mt-3");

    public static void openPage(){
        open(baseURL);
    }

    public void selectRadio(int id){
        $(".custom-control-label",id).click();
    }

    public SelenideElement getResult(){
        return result;
    }
}
