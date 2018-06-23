package util;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mohammad Mutakim on 11/11/17.
 */
public class ConfigReader {

    private String sauce;
    private String url;
    private String chromeDriverPath;
    private String platform;
    private String browser;
    private String version;

    public ConfigReader() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.url = prop.getProperty("url");
            this.chromeDriverPath = prop.getProperty("chrome_driver_path");
            this.sauce = prop.getProperty("run_test");
//            this.platform = prop.getProperty("platform");
//            this.browser = prop.getProperty("browser");
//            this.version =prop.getProperty("version");


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() { return url; }

    public String getChromeDriverPath() { return chromeDriverPath; }

    public String getSauce() { return sauce; }

////    public String getPlatform(){
////        return platform;
////    }
//    public String getBrowser(){
//        return browser;
//    }
////    public String getVersion(){
////        return version;
////    }

    public void sauceSetup() {
//        DesiredCapabilities caps = new DesiredCapabilities();
        DesiredCapabilities caps = new DesiredCapabilities(browser, version, Platform.extractFromSysProperty(platform));
        caps.setCapability(platform, "platform");
        caps.setCapability(browser, "browser");
        caps.setCapability(version, "version");
    }
}








