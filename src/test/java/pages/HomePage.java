package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    String basePageURL = "https://www.hotwire.com/packages";
    By flightButton = By.xpath("//*[text()='Hotel']");
    By hotelButton = By.xpath("//*[text()='Flight']");
    By carButton = By.xpath("//*[text()='Car']");

    public HomePage goToHomePage() {
        driver.get(basePageURL);
        return this;
    }

    public FlightsUtils selectAllOptions() {
        //click(flightButton);
        //click(hotelButton);
        click(carButton);
        return new FlightsUtils(driver);
    }
}

