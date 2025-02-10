import Pages.*;
import Utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InterviewTestCase {

    HomePage homePage;
    NavigationBar navigationBar;
    CareerPage careerPage;
    QualityAssurancePage qualityAssurancePage;
    OpenPositionsPage openPositionsPage;
    LeverApplicationFormPage leverApplicationFormPage;

    @BeforeMethod
    public void setDriver() {
        DriverFactory.setDriver();
        WebDriver driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        navigationBar = new NavigationBar(driver);
        careerPage = new CareerPage(driver);
        qualityAssurancePage = new QualityAssurancePage(driver);
        openPositionsPage = new OpenPositionsPage(driver);
        leverApplicationFormPage = new LeverApplicationFormPage(driver);
    }

    @Test (description = "Insider Interview Text Case")
    public void insiderTestCase() {
        homePage.acceptAllCookies();
        navigationBar.clickNavBarItem("Company");
        navigationBar.clickNavBarDropdownMenuItem("Careers");
        careerPage.checkCareerPageText();
        careerPage.checkLocationsTitle();
        careerPage.checkTeamsTitle();
        careerPage.checkLifeAtInsiderTitle();
        qualityAssurancePage.goToQACareerPage();
        qualityAssurancePage.clickSeeAllQAJobsButton();
        openPositionsPage.selectLocation("Istanbul, Turkiye");
        openPositionsPage.selectDepartment("Quality Assurance");
        openPositionsPage.checkJobsList();
        openPositionsPage.checkJobsPosition("Quality Assurance" , "QA" );
        openPositionsPage.checkJobsDepartment("Quality Assurance");
        openPositionsPage.checkJobsLocation("Istanbul, Turkiye");
        openPositionsPage.clickViewRoleButton();
        leverApplicationFormPage.checkApplyThisJobButton();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
