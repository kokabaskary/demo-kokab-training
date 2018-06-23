package framework.web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class sauce {


        public static final String USERNAME = "Aelya";
        public static final String ACCESS_KEY = "ebf5ee42-64c8-4c12-a28c-227595ec63cc";
        public static final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

        public static void main(String[] args) throws Exception {

            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "latest");

            WebDriver driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);

            /**
             * Goes to Sauce Lab's guinea-pig page and prints title
             */

            driver.get("https://saucelabs.com/test/guinea-pig");
            System.out.println("title of page is: " + driver.getTitle());

            driver.quit();
        }
    }

