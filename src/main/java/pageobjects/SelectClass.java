package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {
    public void selectindex(WebElement ele, int i) {
        Select s = new Select(ele);
        s.selectByIndex(i);
    }

    public void selectvalue(WebElement ele, String value) {
        Select s = new Select(ele);
        s.selectByValue(value);
        ;

    }

    public void selectvisibletext(WebElement ele, String text) {
        Select s = new Select(ele);
        s.selectByVisibleText(text);
    }

    //deselect
    public void deselectall(WebElement ele) {
        Select s = new Select(ele);
        s.deselectAll();
    }

    public void deselectindex(WebElement ele, int i) {
        Select s = new Select(ele);
        s.deselectByIndex(i);
    }

    public void deselectvalue(WebElement ele, String Val) {
        Select s = new Select(ele);
        s.deselectByValue(Val);
    }

    public void deselectvisibletext(WebElement ele, String text) {
        Select s = new Select(ele);
        s.deselectByVisibleText(text);
    }


    public void getalloptions(WebElement ele) {
        Select s = new Select(ele);
        s.getAllSelectedOptions();
    }

    public void getfirstselectoption(WebElement ele) {
        Select s = new Select(ele);
        s.getFirstSelectedOption();
    }

    public void getoption(WebElement ele) {
        Select s = new Select(ele);
        s.getOptions();
    }

    public void ismultiple(WebElement ele) {
        Select s = new Select(ele);
        s.isMultiple();
    }
}
