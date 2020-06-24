package utilitis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver (String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("83").setup();
            return new ChromeDriver();
        }else{
            WebDriverManager.chromedriver().setup();
            return new FirefoxDriver();
        }
    }
}
