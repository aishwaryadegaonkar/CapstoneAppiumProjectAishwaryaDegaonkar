package steps;

import java.net.MalformedURLException;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverManager;
 
public class GeneralStoreSteps {
    private HomePage homePage;
    
 
    @Given("Open the app")
    public void open_the_app() throws MalformedURLException {
        homePage = new HomePage(DriverManager.getDriver());
    }
 
    @And("I click the country dropdown")
    public void i_click_the_country_dropdown() throws InterruptedException {
        homePage.openCountryDropDown();
    }
 
    @Then("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String string) {
        homePage.selectCountryFromDropDown(string);
    }
 
    @And("I enter the name {string}")
    public void i_enter_the_name(String string) {
        homePage.updateTheName(string);
    }
 
    @When("I click the Let's go button")
    public void i_click_the_let_s_go_button() {
        homePage.clickToButton();
    }
 
    @Then("the product screen should be visible")
    public void the_product_screen_should_be_visible() throws MalformedURLException {
        new ProductPage(DriverManager.getDriver()).isProductScreenVisible();
 
    }
    @After
    public void closeDriver() {
        DriverManager.quitDriver();
    }
 
 
 
}
