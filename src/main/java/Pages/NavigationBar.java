package Pages;

import Utils.ElementHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {

    ElementHelper elementHelper;
    ExtentTest test;

    By navBarItem = By.cssSelector("#navbarDropdownMenuLink");
    By dropdownMenuItem = By.cssSelector(".show .dropdown-sub");

    public NavigationBar(WebDriver driver, ExtentTest test) {
        elementHelper = new ElementHelper(driver);
        this.test = test;
    }

    public void clickNavBarItem(String item){
        test.info("Navigate to " + item);
        elementHelper.clickWithText(navBarItem, item);
    }

    public  void clickNavBarDropdownMenuItem(String item){
        test.info("Navigate to " + item);
        elementHelper.clickWithText(dropdownMenuItem, item);
    }
}
