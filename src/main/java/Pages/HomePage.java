package Pages;

import Utils.ElementHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    ElementHelper elementHelper;
    ExtentTest test;

    By acceptAllButton = By.cssSelector(".cli-bar-btn_container>a:nth-child(1)");
    By insiderLogo = By.cssSelector("#navigation>div:nth-child(2)>a>img");

    public HomePage(WebDriver driver, ExtentTest test) {
        elementHelper = new ElementHelper(driver);
        this.test = test;
    }

    public void acceptAllCookies() {
        test.info("Accepting all cookies");
        elementHelper.click(acceptAllButton);
    }

    public void checkInsiderLogo() {
       test.info("Checking Insider Logo");
        elementHelper.findElement(insiderLogo);
    }

}
