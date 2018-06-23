package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.List;

public class HotelsHomePage extends BasePage {

//    private By pageHeader = By.id("");
//    private By gpsButton = By.id("");
//    private By destinationTextField = By.id("");


    private By pageheader = By.xpath("//h1[@class='cont-hd-alt widget-query-heading']");
    private By gpsbutton = By.xpath("//button[@type='button']");
    private By destinationTextField = By.id("qf-0q-destination");
    private By destination = By.xpath("//input[@id='qf-0q-destination']");
    private By nights = By.xpath("//*[@class='widget-query-num-nights']//self::span");
    private By promolocator = By.linkText("Continue to Hotels.com");
    private By daysequalquery1 = By.xpath(".//div[@class='widget-query-group widget-query-dates']/div[1]/span[1]");
    private By daysequalquery2 = By.xpath(".//div[@class='widget-query-group widget-query-dates']/div[2]/span[1]");


    public void clickContinueToHotelsPage(){
        boolean promoPage = SharedSD.getDriver().findElement(promolocator).isDisplayed();
        if (promoPage){
            clickOn(promolocator); }
    }

//    public void  clickContinueToHotelsPage(){
//        boolean promoPage;
//        if (SharedSD.getDriver().findElement(promolocator).isDisplayed()) promoPage = true;
//        else promoPage = false;
//    }
    //entering destination and doing autocomplete
    public void enterDestination() throws InterruptedException {
        WebElement web = SharedSD.getDriver().findElement(destination);
        web.click();
        sendText(destination,"New York");

        List<WebElement> citylist = SharedSD.getDriver().findElements(By.xpath("//*[@class='autosuggest-city']"));
        for (WebElement city : citylist) {
            if (city.getText().equalsIgnoreCase(" York, New York, United States of America")){

                city.click();
                Thread.sleep(2000);
                break;
            } }
    }

    //verifying if the 7 nights are selected and the days the same i.e saturday to saturday
    public void verifyDaysareEqual() throws InterruptedException {

        List<WebElement> queryDay = SharedSD.getDriver().findElements(By.xpath(".//*[@class='widget-query-day']"));
        String day1 = getTextFromElement(daysequalquery1);
        String day2 = getTextFromElement(daysequalquery2);

        if (day1.equals(day2)){
            System.out.println("query days are equal");
        } else {
            System.out.println("please select 7 nights");
        }
//        Assert.assertEquals(daysequalquery1,daysequalquery2);

    }

    //verify if the total number of nights selected are displaying 7 in the briefcase
    public void verifySevenNights() throws InterruptedException {
//
        String text = getTextFromElement(nights);
        if (text.contains("7")) {
            System.out.println("seven nights are selected");
        } else {
            System.out.println("select seven nights");
        }
//        Assert.assertEquals(nights,"7");
    }


    public void selectTomorrow() throws InterruptedException { selectTomorrowDateFromCalendar(); }

    public void selectSixthDayFromtomorrow() throws InterruptedException { selectSixDaysFromTomorrow(); }

    public String getPageHeader() {
        return getTextFromElement(pageheader);
    }

    public void clickOnGPSButton(){clickOn(gpsbutton);}

    public String getDestinationField(){ return getTextFromElement(destinationTextField); }


}
