package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class AddToCart {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to tru to make it work
        chromeOptions.setHeadless(false);//to run browser without GUI. Makes browser invisible.
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        List<WebElement> prices = driver.findElements(By.cssSelector("[class='a-price'] > [class='a-offscreen']"));
        List<WebElement> descriptions = driver.findElements(By.cssSelector("[class='a-size-base-plus a-color-base a-text-normal']"));
        System.out.println("Number of prices: " + prices.size());
        System.out.println("Number of descriptions: " + descriptions.size());
        Random random = new Random();
        int randomNumber = random.nextInt(descriptions.size());
        WebElement randomPrice = prices.get(randomNumber);
        WebElement randomItem = descriptions.get(randomNumber);
        String expectedDescription = randomItem.getText().trim();
        String expectedPrice = randomPrice.getText().trim();
        randomItem.click();//click on random item
        WebElement quantity = driver.findElement(By.xpath("//span[text()='Qty:']/following-sibling::span"));
        int actual = Integer.parseInt(quantity.getText().trim());
        Assert.assertEquals(actual, 1);
        WebElement productTitle = driver.findElement(By.id("productTitle"));
        WebElement productPrice = driver.findElement(By.cssSelector("[id='priceInsideBuyBox_feature_div'] > div"));
        String actualDescription = productTitle.getText().trim();
        String actualPrice = productPrice.getText().trim();
        Assert.assertEquals(actualDescription, expectedDescription);
        Assert.assertEquals(actualPrice, expectedPrice);

    }
    }

