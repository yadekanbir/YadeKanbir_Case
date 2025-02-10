package Pages;

import Utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {

    ElementHelper elementHelper;

    By navBarItem = By.cssSelector("#navbarDropdownMenuLink");
    By dropdownMenuItem = By.cssSelector(".show .dropdown-sub");

    public NavigationBar(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    public void clickNavBarItem(String item){
        elementHelper.clickWithText(navBarItem, item);
    }

    public  void clickNavBarDropdownMenuItem(String item){
        elementHelper.clickWithText(dropdownMenuItem, item);
    }

}
