package pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FlightsUtils extends BasePage {
    public FlightsUtils(WebDriver driver) {
        super(driver);
    }

    By flyFromBy = By.className("uitk-faux-input");
    //By.xpath("//*[text()='Leaving from']");
    //By.xpath("//input[@placeholder='Origin city or airport']");
    By flyToBy = By.xpath("//*[text()='Going to']");
    //By.xpath("//input[@placeholder='Destination city or airport']");
    By departingBy = By.id("d1-btn");
    By returningBy = By.id("d2-btn");
    By findAFlightBy = By.xpath("//*[text()='Find a deal']");
    By flightsList = By.id("flightModuleList");

    public FlightsUtils setUpFlight(String flyFrom, String flyTo) {
        fillIn(flyFromBy, flyFrom);
        fillIn(flyToBy, flyTo);
        return this;
    }

    public FlightsUtils setUpFlightDates() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, +1);
        Date toDate1 = calendar.getTime();
        String afterOneDay = dateFormat.format(toDate1);
        calendar.add(Calendar.DATE, +20);
        Date toDate2 = calendar.getTime();
        String after20Days = dateFormat.format(toDate2);
        fillIn(departingBy, afterOneDay);
        fillIn(returningBy, after20Days);
        return this;
    }

    public FlightsUtils clickFindAFlight() {
        click(findAFlightBy);
        return this;
    }

    public FlightsUtils expectAtLeastOneElementFound() {
        boolean exists = driver.findElements(flightsList).size() != 0;
        Assert.assertEquals(exists, true);
        return this;
    }
}
