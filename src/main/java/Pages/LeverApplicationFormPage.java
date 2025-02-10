package Pages;

import Utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LeverApplicationFormPage {

    ElementHelper elementHelper;

    By applyThisJobButton = By.xpath("//div[@class='postings-btn-wrapper']/a[.='Apply for this job']");

    public LeverApplicationFormPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkApplyThisJobButton() {
        elementHelper.switchWindows();
        Assert.assertTrue(elementHelper.findElement(applyThisJobButton).isDisplayed(), "Apply this job button is not displayed");
    }
}
