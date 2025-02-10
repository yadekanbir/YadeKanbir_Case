package Pages;

import Utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage {

    ElementHelper elementHelper;

    By seeAllQAJobsButton = By.cssSelector("#page-head>div>div>div>div>div a");

    public QualityAssurancePage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    public void goToQACareerPage(){
        elementHelper.goToURL("https://useinsider.com/careers/quality-assurance/");
    }

    public void clickSeeAllQAJobsButton() {
        elementHelper.click(seeAllQAJobsButton);
    }
}
