package stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.ConfigReader;

public class SharedSD {

	private static WebDriver driver = null;
	public static final String USERNAME = "Aelya";
	public static final String ACCESS_KEY = "ebf5ee42-64c8-4c12-a28c-227595ec63cc";
	public static final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	public static WebDriver driverSauce = null;

	@Before("@web")
	public static void before() {

		ConfigReader configReader = new ConfigReader();
		System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(configReader.getUrl());
	}
    @Before("@sauce")
    public static void sauceSetup(String browser, String version, String platform) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities(browser, version, Platform.extractFromSysProperty(platform));
        ConfigReader config = new ConfigReader();
////	    WebDriver sauceDriver = new RemoteWebDriver(new URL("<http://ondemand.saucelabs.com/wd/hub>");
        WebDriver sauceDriver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
        sauceDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverSauce.get(config.getSauce());
    }

//	@Before("@sauce")
//	public static void sauce() throws MalformedURLException {
//        ConfigReader configReader1 = new ConfigReader();
////        System.setProperty("<http://ondemand.saucelabs.com/wd/hub>",configReader1.getSauce());
//        configReader1.sauceSetup();
//        DesiredCapabilities cap = new DesiredCapabilities(configReader1.sauceSetup());
////        DesiredCapabilities capabilities = new DesiredCapabilities(Platform.extractFromSysProperty());
//         driverSauce = new RemoteWebDriver(new URL(SAUCE_URL),cap);
//        driverSauce.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        driverSauce.navigate().to("https://saucelabs.com/test/guinea-pig");
////        driverSauce.get("https://saucelabs.com/test/guinea-pig");
//        driverSauce.get(configReader1.getSauce());
//    }

//		driverSauce.get("https://saucelabs.com/test/guinea-pig");


	@After("@web")
	public static void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}
	@After("@sauce")
	public static void afterSauce(){
	    if(driverSauce != null){
	        driverSauce.manage().deleteAllCookies();
	        driverSauce.quit();
        }
    }

	public static WebDriver getDriver() { return driver; }
	public static WebDriver getRemoteDriver(){return driverSauce; }
}
