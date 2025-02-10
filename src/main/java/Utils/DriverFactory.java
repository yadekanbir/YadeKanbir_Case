package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driverThreadLocal.set(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        getDriver().manage().deleteAllCookies();
        getDriver().get("https://useinsider.com/");
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static synchronized void quitDriver() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
