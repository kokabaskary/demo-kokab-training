package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.mobile_pages.LandingPage;
import framework.mobile_pages.LoginPage;
import org.testng.Assert;

public class MobileLoginSD {

    LandingPage landingPage = new LandingPage();
    LoginPage loginScreen = new LoginPage();

    @Given("^I am on mobile login page$")
    public void iAmOnmobileLoginPage() {
        landingPage.tapOnYesButton();
        //landingPage.tapOnMainMenuButton();
        landingPage.tapOnSignInButton();
    }

    @When("^I sign in using username (.+) and password (.+) in mobile app$")
    public void iAmOnHomePage(String username, String password) {
        loginScreen.enterEmailAddress(username);
        loginScreen.enterPassword(password);
        loginScreen.tapOnSignInButton();
    }
    @Then("^I verify no longer support signing with this version error message on mobile app$")
    public void verifyErrorMessage(){
        landingPage.verifyErrorMessage();
    }
}
