package Pages;

import Utils.ElementHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage {

    ElementHelper elementHelper;
    ExtentTest test;

    By seeAllQAJobsButton = By.cssSelector("#page-head>div>div>div>div>div a");

    public QualityAssurancePage(WebDriver driver, ExtentTest test) {
        elementHelper = new ElementHelper(driver);
        this.test = test;
    }

    public void goToQACareerPage(){
        test.info("Go to QACareerPage");
        elementHelper.goToURL("https://useinsider.com/careers/quality-assurance/");
    }

    public void clickSeeAllQAJobsButton() {
        test.info("Click SeeAllQAJobsButton");
        elementHelper.click(seeAllQAJobsButton);
    }
}
