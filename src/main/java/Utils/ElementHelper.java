package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementHelper {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    public void goToURL(String text) {
        driver.get(text);
        wait.until(ExpectedConditions.urlToBe(text));
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"start\",behavior: \"instant\"});", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.moveToElement(element).build().perform();
    }

    public WebElement findElement(By by) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        scroll(element);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> findElements(By by) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        scroll(elements.get(0));
        return driver.findElements(by);
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitDropdown(By by, By by2) {
        for (int i = 0; i < 20; i++) {
            try {
                findElement(by2).click();
                WebElement element = driver.findElement(by);
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (Exception e) {
                driver.findElement(by2).click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public void waitUntilElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickWithText(By by, String text) {
        boolean check = false;
        for (WebElement elem : findElements(by)) {
            if (elem.getText().equals(text)) {
                elem.click();
                check = true;
                break;
            }
        }
        Assert.assertTrue(check, "Element not found");
    }

    public void checkAllElementsText2(By by, String text1, String text2) {
        boolean allElementsValid = true;
        List<WebElement> elements = findElements(by); // WebElement listesini alıyoruz

        for (WebElement element : elements) {
            String elementText = element.getText();
            if (!(elementText.contains(text1) || elementText.contains(text2))) {
                System.out.println("Element text does not contain required words: " + elementText);
                allElementsValid = false;
            }
        }

        Assert.assertTrue(allElementsValid, "Element text does not contain required words: " + text1 + " " + text2);
    }

    public void checkAllElementsText(By by, String text) {
        boolean check = true;
        wait.until(ExpectedConditions.textToBePresentInElement(findElement(by),text));
        for (WebElement element : findElements(by)) {
            if (!element.getText().contains(text)) {
                System.out.println(element.getText());
                check = false;
            }
        }
        Assert.assertTrue(check, "Element not found");
    }

    public void switchWindows(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}