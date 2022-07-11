package Tests;

import Pages.CheckBoxPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Pages.CheckBoxPage.openPage;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWindow;

public class CheckBoxTests {

    CheckBoxPage checkBoxPage = new CheckBoxPage();

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
    public void expandAllTest(){
        checkBoxPage.expandAll();
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Notes"),text("Commands"),text("Documents"),text("WorkSpace"),text("React"),text("Angular"),text("Veu"),text("Office"),text("Public"),text("Private"),text("Classified"),text("General"),text("Downloads"),text("Word File.doc"),text("Excel File.doc"));
    }

    @Test
    public void collapseAllTest(){
        checkBoxPage.expandAll();
        checkBoxPage.collapseAll();
        checkBoxPage.getTreeNode().shouldHave(text("Home")).shouldNotHave(text("Desktop"),text("Notes"),text("Commands"),text("Documents"),text("WorkSpace"),text("React"),text("Angular"),text("Veu"),text("Office"),text("Public"),text("Private"),text("Classified"),text("General"),text("Downloads"),text("Word File.doc"),text("Excel File.doc"));
    }

    @Test
    public void expandHomeTest(){
        checkBoxPage.clickCloseToggle(0);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads"));
        checkBoxPage.clickOpenToggle(0);
        checkBoxPage.getTreeNode().shouldHave(text("Home")).shouldNotHave(text("Desktop"),text("Documents"),text("Downloads"));
    }

    @Test
    public void expandDesktopTest(){
        checkBoxPage.clickCloseToggle(0);
        checkBoxPage.clickCloseToggle(0);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldHave(text("Notes"),text("Commands"));
        checkBoxPage.clickOpenToggle(1);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldNotHave(text("Notes"),text("Commands"));
    }

    @Test
    public void expandDocumentsTest(){
        checkBoxPage.clickCloseToggle(0);
        checkBoxPage.clickCloseToggle(1);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldHave(text("WorkSpace"),text("Office"));
        checkBoxPage.clickCloseToggle(1);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldHave(text("WorkSpace"),text("Office")).shouldHave(text("React"),text("Angular"),text("Veu"));
        checkBoxPage.clickOpenToggle(2);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldHave(text("WorkSpace"),text("Office")).shouldNotHave(text("React"),text("Angular"),text("Veu"));
        checkBoxPage.clickCloseToggle(2);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldHave(text("WorkSpace"),text("Office")).shouldHave(text("Public"),text("Private"),text("Classified"),text("General"));
        checkBoxPage.clickOpenToggle(2);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldHave(text("WorkSpace"),text("Office")).shouldNotHave(text("Public"),text("Private"),text("Classified"),text("General"));
    }

    @Test
    public void expandDownloadsTest(){
        checkBoxPage.clickCloseToggle(0);
        checkBoxPage.clickCloseToggle(2);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldHave(text("Word File.doc"),text("Excel File.doc"));
        checkBoxPage.clickOpenToggle(1);
        checkBoxPage.getTreeNode().shouldHave(text("Home"),text("Desktop"),text("Documents"),text("Downloads")).shouldNotHave(text("Word File.doc"),text("Excel File.doc"));
    }

    @Test
    public void checkBoxButtonTest(){
        checkBoxPage.getResult().shouldNotBe(exist);
        checkBoxPage.clickCheckBoxButton(0);
        checkBoxPage.getResult().shouldHave(text("You have selected :"),text("home"),text("desktop"),text("notes"),text("commands"),text("documents"),text("workspace"),text("react"),text("angular"),text("veu"),text("office"),text("public"),text("private"),text("classified"),text("general"),text("downloads"),text("wordFile"),text("excelFile"));
        checkBoxPage.clickCloseToggle(0);
        checkBoxPage.clickCheckBoxButton(1);
        checkBoxPage.getResult().shouldHave(text("You have selected :"),text("documents"),text("workspace"),text("react"),text("angular"),text("veu"),text("office"),text("public"),text("private"),text("classified"),text("general"),text("downloads"),text("wordFile"),text("excelFile"));
        checkBoxPage.getResult().shouldNotHave(text("home"),text("desktop"),text("notes"),text("commands"));
        checkBoxPage.clickCheckBoxButton(2);
        checkBoxPage.getResult().shouldHave(text("You have selected :"),text("downloads"),text("wordFile"),text("excelFile"));
        checkBoxPage.getResult().shouldNotHave(text("documents"),text("workspace"),text("react"),text("angular"),text("veu"),text("office"),text("public"),text("private"),text("classified"),text("general"));
        checkBoxPage.clickCheckBoxButton(3);
        checkBoxPage.getResult().shouldNotBe(exist);
    }
}
