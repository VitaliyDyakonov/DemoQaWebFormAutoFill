package Pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckBoxPage {


    private static String baseURL = "https://demoqa.com/checkbox";

    private SelenideElement treeNode = $("#tree-node");

    private SelenideElement result = $("#result");
    private SelenideElement expandAll = $(".rct-option.rct-option-expand-all");

    private SelenideElement collapseAll = $(".rct-option.rct-option-collapse-all");

    private String expandCloseToggle = ".rct-icon.rct-icon-expand-close";

    private String expandOpenToggle = ".rct-icon.rct-icon-expand-open";

    private String checkBoxButton = ".rct-checkbox";


    public static void openPage(){
        open(baseURL);
    }

    public SelenideElement getTreeNode(){
        return treeNode;
    }

    public SelenideElement getResult(){return result;}
    public void expandAll() {
        expandAll.click();
    }

    public void collapseAll(){
        collapseAll.click();
    }

    public void clickOpenToggle(int id){
        $(expandOpenToggle, id).click();
    }

    public void clickCloseToggle(int id){
        $(expandCloseToggle, id).click();
    }

    public void clickCheckBoxButton(int id){$(checkBoxButton, id).click();}
}
