package Pages;

import Utils.ElementHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LeverApplicationFormPage {

    ElementHelper elementHelper;
    ExtentTest test;

    By applyThisJobButton = By.xpath("//div[@class='postings-btn-wrapper']/a[.='Apply for this job']");

    public LeverApplicationFormPage(WebDriver driver, ExtentTest test) {
        this.elementHelper = new ElementHelper(driver);
        this.test = test;
    }

    public void checkApplyThisJobButton() {
        test.info("Verifying 'Apply This Job' Button");
        elementHelper.switchWindows();
        Assert.assertTrue(elementHelper.findElement(applyThisJobButton).isDisplayed(), "Apply this job button is not displayed");
    }
}
