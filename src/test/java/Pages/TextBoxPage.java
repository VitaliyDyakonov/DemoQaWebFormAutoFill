package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private String baseURL = "https://demoqa.com/text-box";
    //Имя пользователя
    private SelenideElement fullName = $("#userName");
    //Почта пользователя
    private SelenideElement email = $("#userEmail");
    //Адрес пользователя
    private SelenideElement currentAddress = $("#currentAddress");
    //Второй адрес пользователя :)
    private SelenideElement permanentAddress = $("#permanentAddress");

    //Кнопка принять
    private SelenideElement submitButton = $("#submit");

    public SelenideElement nameField = $("p#name");

    public SelenideElement emailField = $("p#email");

    public SelenideElement curAddressField = $("p#currentAddress");

    public SelenideElement perAddressField = $("p#permanentAddress");

    public TextBoxPage openPage(){
        open(baseURL);
        return this;
    }

    public TextBoxPage typeName(String username) {
        fullName.setValue(username);
        return this;
    }

    public TextBoxPage typeEmail(String mail){
        email.setValue(mail);
        return this;
    }

    public TextBoxPage typeAddress(String adres){
        currentAddress.setValue(adres);
        return this;
    }

    public TextBoxPage typePermAddress(String adres){
        permanentAddress.setValue(adres);
        return this;
    }

    public TextBoxPage submitForm(){
        submitButton.click();
        return this;
    }
}
