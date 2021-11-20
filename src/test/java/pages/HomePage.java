package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    String basePageURL = "https://www.hotwire.com/";
    By flightsButton = By.xpath("//*[text()='Flights']");
    //By.xpath("//a[@href='https://www.hotwire.com/flights/']");

    public HomePage goToHomePage() {
        driver.get(basePageURL);
        return this;
    }

    public FlightsUtils goToFlights() {
        click(flightsButton);
        driver.get("https://www.hotwire.com/flights/");
        return new FlightsUtils(driver);
    }

}
