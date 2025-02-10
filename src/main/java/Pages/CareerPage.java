package Pages;

import Utils.ElementHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CareerPage {

    ElementHelper elementHelper;
    ExtentTest test;

    By careerPageText = By.cssSelector("#page-head>div>div>div>div h1");
    By locationsTitle = By.cssSelector(".category-title-media.ml-0");
    By teamsTitle = By.cssSelector("#career-find-our-calling .category-title-media");
    By lifeAtInsiderTitle = By.xpath("//div[@class='elementor-widget-wrap elementor-element-populated e-swiper-container']//h2");

    public CareerPage(WebDriver driver, ExtentTest test) {
        elementHelper = new ElementHelper(driver);
        this.test = test;
    }

    public void checkCareerPageText() {
        test.info("Verifying Career Page Text");
        Assert.assertTrue(elementHelper.findElement(careerPageText).isDisplayed(), "Career page is not displayed");
    }

    public void checkLocationsTitle(){
        test.info("Verifying Locations Title");
        Assert.assertTrue(elementHelper.findElement(locationsTitle).isDisplayed(), "Location area is not displayed");
    }

    public void checkTeamsTitle(){
        test.info("Verifying Teams Title");
        Assert.assertTrue(elementHelper.findElement(teamsTitle).isDisplayed(), "Teams area is not displayed");
    }

    public void checkLifeAtInsiderTitle(){
        test.info("Verifying Life At Insider Title");
        Assert.assertTrue(elementHelper.findElement(lifeAtInsiderTitle).isDisplayed(), "Life at Insider area is not displayed");
    }
}
