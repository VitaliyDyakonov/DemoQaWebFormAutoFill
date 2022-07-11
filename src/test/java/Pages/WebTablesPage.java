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

    private ElementsCollection result = $$(".rt-tr-group");

    private SelenideElement rowsNumber = $(".select-wrap.-pageSizeOptions");

    public static void openPage(){
        open(baseURL);
    }

    public void addRecord(String fName, String lName, String email, String age, String salary, String department){
        addPeople.click();
        putFirstName.setValue(fName);
        putLastName.setValue(lName);
        putEmail.setValue(email);
        putAge.setValue(age);
        putSalary.setValue(salary);
        putDepartment.setValue(department);
        submitButton.click();
    }

    public SelenideElement getAddedResult(){
        return result.filter(not(Condition.empty)).last();
    }

    public void setRowsNumber(String nrows){
        rowsNumber.setValue(nrows);
    }
}
