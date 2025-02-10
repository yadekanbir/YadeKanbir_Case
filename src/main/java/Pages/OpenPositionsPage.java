package Pages;

import Utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OpenPositionsPage {

    ElementHelper elementHelper;

    By drpBtn_Department = By.xpath("//span[@id=\"select2-filter-by-department-container\"]/..//b");
    By drpdownList = By.cssSelector(".select2-container--open ul>li");
    By drpdownLWait = By.cssSelector(".select2-container--open ul>li:nth-child(2)");
    By drpBtn_Location = By.cssSelector(".select2-selection__arrow>b");
    By jobsList = By.cssSelector("#career-position-list");
    By jobsPosition = By.cssSelector(".position-title.font-weight-bold");
    By jobsLocation = By.cssSelector(".position-list>div>div>div");
    By jobsDepartment = By.cssSelector(".position-department");
    By viewRoleButton = By.cssSelector(".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5");

    public OpenPositionsPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void selectLocation(String location) {
        elementHelper.waitDropdown(drpdownLWait, drpBtn_Location);
        elementHelper.clickWithText(drpdownList, location);
    }

    public void selectDepartment(String department) {
        elementHelper.waitDropdown(drpdownLWait, drpBtn_Department);
        elementHelper.clickWithText(drpdownList, department);
    }

    public void checkJobsList() {
        Assert.assertTrue(elementHelper.findElement(jobsList).isDisplayed(), "Jobs list is not displayed");
    }

    public void checkJobsPosition(String position1, String position2) {
        elementHelper.checkAllElementsText2(jobsPosition, position1, position2);
    }


    public void checkJobsLocation(String location) {
        elementHelper.checkAllElementsText(jobsLocation, location);
    }

    public void checkJobsDepartment(String department) {
        elementHelper.checkAllElementsText(jobsDepartment, department);
    }

    public void clickViewRoleButton() {
        elementHelper.click(viewRoleButton);
    }
}
