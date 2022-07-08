package Tests;

import Pages.TextBoxPage;
import com.codeborne.selenide.Configuration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static org.assertj.core.api.Assertions.*;

public class TextBoxTests {

    String userName = "Bipka";
    String email = "bibka@zhmih.com";
    String curAdr = "Miami beach 22";
    String permAdr = "PENZA 228";
    static TextBoxPage page = new TextBoxPage();

    @BeforeAll
    static void setUp(){
        Configuration.startMaximized = true;

    }

    @Test
    public void formFillTest(){
        page.openPage().typeName(userName).typeEmail(email).typeAddress(curAdr).typePermAddress(permAdr).submitForm();
        page.nameField.shouldHave(text(userName));
        page.emailField.shouldHave(text(email));
        page.curAddressField.shouldHave(text(curAdr));
        page.perAddressField.shouldHave(text(permAdr));
    }
}
