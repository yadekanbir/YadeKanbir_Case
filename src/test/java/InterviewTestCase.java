import Pages.*;
import Utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class InterviewTestCase {

    HomePage homePage;
    NavigationBar navigationBar;
    CareerPage careerPage;
    QualityAssurancePage qualityAssurancePage;
    OpenPositionsPage openPositionsPage;
    LeverApplicationFormPage leverApplicationFormPage;

    static ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setDriver() {
        DriverFactory.setDriver();
        WebDriver driver = DriverFactory.getDriver();

        if(extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/Spark.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        test = extent.createTest("Insider Interview Test Case");

        homePage = new HomePage(driver, test);
        navigationBar = new NavigationBar(driver, test);
        careerPage = new CareerPage(driver, test);
        qualityAssurancePage = new QualityAssurancePage(driver, test);
        openPositionsPage = new OpenPositionsPage(driver, test);
        leverApplicationFormPage = new LeverApplicationFormPage(driver, test);

    }

    @Test(description = "Insider Interview Test Case")
    public void insiderTestCase() {
        try {
            homePage.checkInsiderLogo();
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
            openPositionsPage.checkJobsPosition("Quality Assurance", "QA");
            openPositionsPage.checkJobsDepartment("Quality Assurance");
            openPositionsPage.checkJobsLocation("Istanbul, Turkiye");
            openPositionsPage.clickViewRoleButton();
            leverApplicationFormPage.checkApplyThisJobButton();
            test.pass("Test executed successfully.");
        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        extent.flush();
    }
}
