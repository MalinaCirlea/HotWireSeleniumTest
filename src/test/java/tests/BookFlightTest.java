package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class BookFlightTest extends BaseTest {

    @Test
    public void bookFlight() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        homePage.goToFlights().
                setUpFlight("San Francisco International Airport (SFO)", "LAX").
                setUpFlightDates().
                clickFindAFlight().
                expectAtLeastOneElementFound();
    }
}
