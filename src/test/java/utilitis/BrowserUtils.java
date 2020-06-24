package utilitis;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {


        /**
         * Pause test for some time
         *
         * @param seconds
         */
        public static void wait(int seconds) {
            try {
                Thread.sleep(1000 * seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         *
         * @param elements represents collection of WebElements
         * @return collection of strings
         */
        public static List<String> getTextFromWebElements(List<WebElement> elements) {
            List<String> textValues = new ArrayList<>();
            for (WebElement element : elements) {
                if (!element.getText().isEmpty()) {
                    textValues.add(element.getText());
                }
            }
            return textValues;
        }
    }

