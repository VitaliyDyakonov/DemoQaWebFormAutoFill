package Tests;

import Pages.WebTablesPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Pages.WebTablesPage.openPage;
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
        webTablesPage.getAddedResult().shouldHave(text("pipka"),text("bibka"),text("zhepka@gmail.com"),text("10"),text("20"),text("idk"));
    }

    @Test
    public void addSeveralRecords(){
        webTablesPage.setRowsNumber("15");
        for(int i=1; i<6; i++){
            webTablesPage.addRecord("TestFname"+i,"TestLname"+i,"Test"+i+"@gmail.com","1","1","TestDep"+i);
        }
    }
}
