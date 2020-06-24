package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;


public class RandomSelection_Days {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("83").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void daysTest() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
       Thread.sleep(2000);

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
        int counter = 0;

        while (counter < 3) {
            Random random = new Random();
            int checkboxToSelect = random.nextInt(checkboxes.size());

            if (checkboxes.get(checkboxToSelect).isEnabled()) {

                checkboxes.get(checkboxToSelect).click();
                System.out.println("Selected :: " + labels.get(checkboxToSelect).getText());

                checkboxes.get(checkboxToSelect).click();

                if (labels.get(checkboxToSelect).getText().equals("Friday")) {
                    counter++;
                }
            }
        }

    }
}
