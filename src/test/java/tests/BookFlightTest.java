package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class BookFlightTest extends BaseTest {

    @Test
    public void bookFlight() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        homePage.selectAllOptions().
                setUpFlight("sfo", "LAX").
                setUpFlightDates().
                clickFindAFlight().
                expectAtLeastOneElementFound();
    }
}
