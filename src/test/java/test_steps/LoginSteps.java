package test_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginSteps {
    private final StepsBase base;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public LoginSteps(StepsBase base) {
        this.base = base;
    }

    @Given("I am in the login page of the SWAGLABS site")
    public void iAmInTheLoginPageOfTheSWAGLABSSite() {
        loginPage = new LoginPage(base.driver());
    }

    @When("I enter a {string} and a {string}")
    public void iEnterAUsernameAndAPassword(String username, String password) {
        inventoryPage = loginPage
                .enterUserCredentials(username, password)
                .login();
    }

    @Then("I should be taken to the Home Page with {string}")
    public void iShouldBeTakenToTheHomePageWithTitleNextPageTitle(String nextPageTitle) {
//        var nextPageTitle = table.asList().get(0);

        inventoryPage.assertOnPageTitle(nextPageTitle);
    }

    @Then("I will get a meaningful {string}")
    public void iWillGetAMeaningfulErrorMessage(String errorMessage) {
        loginPage
                .assertOnErrorMessage(errorMessage);
    }
}
