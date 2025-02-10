package Pages;

import Utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    ElementHelper elementHelper;

    By closePopupButton = By.cssSelector("");
    By acceptAllButton = By.cssSelector(".cli-bar-btn_container>a:nth-child(1)");
    By insiderLogo = By.cssSelector("#navigation>div:nth-child(2)>a>img");

    public HomePage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    public void acceptAllCookies() {
        elementHelper.click(acceptAllButton);
    }

}
