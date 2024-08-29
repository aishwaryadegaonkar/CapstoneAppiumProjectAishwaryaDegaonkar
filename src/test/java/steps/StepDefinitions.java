package steps;


import java.net.MalformedURLException;
 
 
import io.cucumber.java.en.*;
import pages.HomePage;
import utils.DriverManager;
 
public class StepDefinitions {
    private HomePage hpage;
    @Given("I launch the app")
    public void i_launch_the_app() throws MalformedURLException {
 
        hpage = new HomePage(DriverManager.getDriver());
    }
 
    @Then("I should see the home screen with the General Store")
    public void i_should_see_the_home_screen_with_the_general_store() {
        hpage.isHomeScreenTitleDisplayed();
        DriverManager.quitDriver();
    }
 
 
}
 