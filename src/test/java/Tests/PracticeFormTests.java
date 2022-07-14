package Tests;

import Pages.PracticeFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Pages.PracticeFormPage.openPage;
import static com.codeborne.selenide.Selenide.closeWindow;

public class PracticeFormTests {

    PracticeFormPage practicePage = new PracticeFormPage();

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
    public void autoFillForms(){
        practicePage.enterFname("Vitaliy").enterLname("Dyakonov").enterEmail("test@gmail.com").chooseGender(1).enterMobileNumber("7999999999").enterBirthDay("16","April","1999").enterSubjs("Maths").chooseHobbies(2).uploadPicture("src/test/resources/test.JPG").enterAddress("Pushkina Street 228").chooseState("Uttar Pradesh").chooseCity("Lucknow").submitForm();
        practicePage.validateResult(List.of("Vitaliy Dyakonov","test@gmail.com","Male","7999999999","16 April,1999","Maths","Reading","test.jpg","Pushkina Street 228","Uttar Pradesh Lucknow")).closeTablet();
    }
}
