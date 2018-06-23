package framework.mobile_pages;

import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.testng.Assert;

public class LandingPage extends MobileBasePage {

//    @AndroidFindBy(id = "com.hcom.android:id/btnPositive")
    @AndroidFindBy(xpath = ".//*[@class='android.widget.Button']")
    @iOSFindBy(accessibility = "yesButton")
    private MobileElement yesButton;

    @AndroidFindBy(accessibility = "Open drawer menu")
    private MobileElement mainMenu;

    @AndroidFindBy(id = "com.hcom.android:id/drawer_header_sign_in")
    private MobileElement signInButton;

    @AndroidFindBy(xpath = ".//*[@class='android.widget.LinearLayout']")
   private MobileElement errorMessage;

    public void tapOnYesButton() {
        tapOn(yesButton);
    }

    public void tapOnMainMenuButton() {
        tapOn(mainMenu);
    }

    public void tapOnSignInButton() {
        tapOn(signInButton);
    }

    public void verifyErrorMessage(){
        Assert.assertEquals(errorMessage,"We no longer support signing in with this version of the app. Please update to the latest version.");
    }
}
