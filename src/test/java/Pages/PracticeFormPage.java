package Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private static String baseURL = "https://demoqa.com/automation-practice-form";

    private SelenideElement firstName = $("#firstName");

    private SelenideElement lastName = $("#lastName");

    private SelenideElement email = $("#userEmail");

    private String gender = ".custom-control.custom-radio.custom-control-inline";

    private SelenideElement mobileNumber = $("#userNumber");

    private SelenideElement birthDate = $("#dateOfBirthInput");

    private SelenideElement nextMonth = $(".react-datepicker__navigation.react-datepicker__navigation--next");

    private SelenideElement previousMonth = $(".react-datepicker__navigation.react-datepicker__navigation--previous");

    private SelenideElement monthList = $(".react-datepicker__month-select");

    private SelenideElement yearList = $(".react-datepicker__year-select");

    private String dayOfBirth = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";

    private SelenideElement subjects = $("#subjectsInput");

    private ElementsCollection subj = $$(".subjects-auto-complete__menu-list.subjects-auto-complete__menu-list--is-multi.css-11unzgr");

    private String hobbies = "hobbies-checkbox-";

    private SelenideElement fileUpload = $("#uploadPicture");

    private SelenideElement address = $("#currentAddress");

    private SelenideElement state = $("#react-select-3-input");

    private ElementsCollection stateList = $$(".css-11unzgr");

    private SelenideElement city = $("#react-select-4-input");

    private ElementsCollection cityList = $$(".css-26l3qy-menu");

    private SelenideElement submitButton = $("#submit");

    private ElementsCollection result = $$("td:nth-of-type(2)");

    private SelenideElement closeButton = $("#closeLargeModal");

    public static void openPage(){
        open(baseURL);
    }

    public PracticeFormPage enterFname(String name){
        firstName.setValue(name);
        return this;
    }

    public PracticeFormPage enterLname(String lName){
        lastName.setValue(lName);
        return this;
    }

    public PracticeFormPage enterEmail(String userEmail){
        email.setValue(userEmail);
        return this;
    }

    public PracticeFormPage chooseGender(int id){
        $(gender,id).click();
        return this;
    }

    public PracticeFormPage enterMobileNumber(String number){
        mobileNumber.setValue(number);
        return this;
    }

    public PracticeFormPage enterBirthDay(String day, String month, String year){
        birthDate.click();
        monthList.selectOptionContainingText(month);
        yearList.selectOptionContainingText(year);
        $(String.format(dayOfBirth, day)).click();
        return this;
    }

    public PracticeFormPage enterSubjs(String userSubject){
        subjects.setValue(userSubject);
        subjects.pressEnter();
        return this;
    }

    public PracticeFormPage chooseHobbies(int id){
        $(by("for",hobbies+id)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String picture){
        fileUpload.uploadFile(new File(picture));
        return this;
    }

    public PracticeFormPage enterAddress(String userAddress){
        address.setValue(userAddress);
        return this;
    }

    public PracticeFormPage chooseState(String userState){
        state.setValue(userState).pressEnter();
        return this;
    }

    public PracticeFormPage chooseCity(String userCity){
        city.setValue(userCity).pressEnter();
        return this;
    }

    public void submitForm(){
        submitButton.click();
    }

    public PracticeFormPage validateResult(List<String> expectedResult){
        result.shouldHave(CollectionCondition.texts(expectedResult));
        return this;
    }

    public void closeTablet(){
        closeButton.click();
    }
}
