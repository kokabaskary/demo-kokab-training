package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HotelsHomePage;
import org.testng.Assert;

public class HotelsSD {


private HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I am on Hotels website homepage$")
    public void iamOnHotelsHomePage(){
        Assert.assertEquals(hotelsHomePage.getPageHeader(),"Where to?","unable to find hotels homepage");
    }
    @And("^I click to continue on hotels page$")
    public void clickOnPromo(){
        hotelsHomePage.clickContinueToHotelsPage();
    }

    @When("^I Click on GPS locator button$")
    public void clickOnGPS(){ hotelsHomePage.clickOnGPSButton(); }

    @Then("^I verify destination field is pre-populated with current location$")
    public void verifyDestinationTextField(){
        hotelsHomePage.getDestinationField();
    }

    @When("^I select city \"new York\" from search bar$")
    public void selectCityNewYork() throws InterruptedException {
        hotelsHomePage.enterDestination();
    }
    @When("^I select checkin date as \"Tomorrow\"$")
    public void selectTomorrowCheckIn() throws InterruptedException {
        hotelsHomePage.selectTomorrow();
    }

    @When("^I select checkout date as \"7 days from tomorrow$")
    public void selectSixDateFromtomorrow() throws InterruptedException {
    hotelsHomePage.selectSixthDayFromtomorrow();
    }

    @Then("^I verify \"7\" night is displayed$")
    public void verifySevenNightsDisplayed() throws InterruptedException {
        hotelsHomePage.verifySevenNights();
    }

    @And("^I verify checkin and checkout days are same$")
    public void verifyCheckInOutDaysSame() throws InterruptedException {
        hotelsHomePage.verifyDaysareEqual();
    }


//    public HotelsCalendar getHotelsCalendar() {
//        return hotelsCalendar;
//    }
}
