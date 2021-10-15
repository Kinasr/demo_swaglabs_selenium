package test_steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;
import pages.LoginPage;

public class AddItemToCartSteps {
    private final StepsBase base;
    private InventoryPage inventoryPage;

    public AddItemToCartSteps(StepsBase base) {
        this.base = base;
    }

    @Given("I logged in with")
    @And("Logging in with")
    public void iLoggedInWith(DataTable data) {
        var dataList = data.row(0);
        var username = dataList.get(0);
        var password = dataList.get(1);

        inventoryPage = new LoginPage(base.driver())
                .enterUserCredentials(username, password)
                .login();
    }

    @When("Adding an item to the cart")
    @And("Adding another item to the cart")
    public void addingAnItemToTheCart(DataTable data) {
        var item = data.row(0).get(0);

        inventoryPage.addItemToCart(item);
    }

    @And("Removing it from the cart")
    public void removingItFromTheCart(DataTable data) {
        var item = data.row(0).get(0);

        inventoryPage.removeItemFormCart(item);
    }

    @And("Logging out")
    public void loggingOut() {
        inventoryPage
                .openBurgerMenu()
                .logout();
    }

    @Then("I should see the number of items on the cart icon become")
    public void iShouldSeeTheNumberOfItemsOnTheCartIconBecome(DataTable data) {
        var numOfItems = Integer.parseInt(data.row(0).get(0));

        inventoryPage.assertOnNumOfItemsOnCart(numOfItems);
    }

    @Then("I should see the cart empty")
    public void iShouldSeeTheCartEmpty() {
        inventoryPage.assertThatCartIsEmpty();
    }
}
