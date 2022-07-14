package Tests;

import Pages.WebTablesPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Pages.WebTablesPage.openPage;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWindow;

public class WebTablesTests {

    WebTablesPage webTablesPage = new WebTablesPage();

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
    public void addNewRecordInTable(){
        webTablesPage.addRecord("pipka","bibka","zhepka@gmail.com","10","20","idk");
        webTablesPage.getResult().last().shouldHave(text("pipka"),text("bibka"),text("zhepka@gmail.com"),text("10"),text("20"),text("idk"));
    }

    @Test
    public void addSeveralRecords(){
        webTablesPage.setRowsNumber("5");
        for(int i=1; i<4; i++){
            webTablesPage.addRecord("TestFname"+i,"TestLname"+i,"Test"+i+"@gmail.com","1","1","TestDep"+i);
        }
        webTablesPage.getResult().shouldHave(size(5)).last(2).shouldHave(texts("TestFname1","TestFname2"));
        webTablesPage.clickNextButton();
        webTablesPage.getResult().shouldHave(texts("TestFname3"));
        webTablesPage.clickPreviousButton();
    }

    @Test
    public void editRecords(){
        webTablesPage.editRecords(1, "EditedFName","EditedLName","EditedMail@gmail.com","12","15000","EditedDepartment");
        webTablesPage.getResult().get(0).shouldHave(text("EditedFName"));
    }

    @Test
    public void deleteRecords(){
        webTablesPage.deleteRecord(1);
        webTablesPage.getResult().shouldHave(size(2)).last(2).shouldHave(texts("Alden","Kierra"));
    }
}
