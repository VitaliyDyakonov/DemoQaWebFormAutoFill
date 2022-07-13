package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage {

    private static String baseURL = "https://demoqa.com/webtables";

    private SelenideElement addPeople = $("#addNewRecordButton");

    private SelenideElement putFirstName = $("#firstName");

    private SelenideElement putLastName = $("#lastName");

    private SelenideElement putEmail = $("#userEmail");

    private SelenideElement putAge = $("#age");

    private SelenideElement putSalary = $("#salary");

    private SelenideElement putDepartment = $("#department");

    private SelenideElement submitButton = $("#submit");

    private String editButton = "#edit-record-";

    private String deleteButton = "#delete-record-";

    private SelenideElement nextButton = $(".-next");

    private SelenideElement previousButton = $(".-previous");

    private ElementsCollection result = $$(".rt-tr-group");

    private SelenideElement rowsNumber = $(by("aria-label","rows per page"));

    public static void openPage(){
        open(baseURL);
    }

    public void fillForms(String fName, String lName, String email, String age, String salary, String department){
        putFirstName.setValue(fName);
        putLastName.setValue(lName);
        putEmail.setValue(email);
        putAge.setValue(age);
        putSalary.setValue(salary);
        putDepartment.setValue(department);
        submitButton.click();
    }

    public void addRecord(String fName, String lName, String email, String age, String salary, String department){
        addPeople.click();
        fillForms(fName,lName,email,age,salary,department);
    }

    public void editRecords(int id,String fName, String lName, String email, String age, String salary, String department){
        $(editButton+id).click();
        fillForms(fName,lName,email,age,salary,department);
    }

    public void deleteRecord(int id){
        $(deleteButton+id).click();
    }
    public ElementsCollection getResult(){
        return result.filter(not(Condition.empty));
    }

    public void setRowsNumber(String nrows){
        rowsNumber.selectOptionContainingText(nrows);
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void clickPreviousButton(){
        previousButton.click();
    }
}
