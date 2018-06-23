package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {

	public void clickOn(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}
	public void selectTomorrowDateFromCalendar() throws InterruptedException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);

        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("d");
        String tomorrowDate = dateFormat.format(date);

        SharedSD.getDriver().findElement(By.xpath(".//*[@id='qf-0q-localised-check-in']")).click();
        List<WebElement> days = SharedSD.getDriver().findElements(By.xpath(".//*[@class='widget-datepicker-bd']/descendant::a"));
        for (WebElement day :days) {
            String expectedDate = day.getText();
            if (expectedDate.equals(tomorrowDate)){
                day.click();
                Thread.sleep(6000);
                break;
            } }
    }

public void selectSixDaysFromTomorrow() throws InterruptedException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, 8);

    Date date = calendar.getTime();
    DateFormat dateFormat = new SimpleDateFormat("d");
    String seventhDateFromTomorrow = dateFormat.format(date);

    SharedSD.getDriver().findElement(By.xpath(".//*[@id='qf-0q-localised-check-out']")).click();
    List<WebElement> days = SharedSD.getDriver().findElements(By.xpath(".//*[@class='widget-datepicker-bd']/descendant::a"));
    for (WebElement day :days) {
        String expectedDate = day.getText();
        if (expectedDate.equals(seventhDateFromTomorrow)) {
            day.click();
            Thread.sleep(9000);
            break;
        } }
}

    public void clickOnBrowserBackArrow() { SharedSD.getDriver().navigate().back(); }

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}
}
