package cucumber.todo.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static cucumber.todo.RunCukesIT.getBaseUrl;
import static cucumber.todo.RunCukesIT.getWebDriver;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Steps {
    private WebElement textField;

    @Given("^I am on the To-Do page$")
    public void I_am_on_the_To_Do_page() throws Throwable {
        getWebDriver().get(getBaseUrl());
    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_fill_in_with(String locator, String text) throws Throwable {
        textField = getWebDriver().findElement(By.id(locator));

        assertTrue(textField.isDisplayed());

        textField.sendKeys(text);
    }

    @When("^I press \"([^\"]*)\"$")
    public void I_press(String key) throws Throwable {
        textField.sendKeys(Keys.valueOf(key.toUpperCase()));
    }

    @Then("^I should see \"([^\"]*)\" item$")
    public void I_should_see(String text) throws Throwable {
        WebElement todoList = getWebDriver().findElement(By.id("todo-list"));
        WebElement item = todoList.findElement(By.cssSelector(".view label"));

        assertTrue(item.isDisplayed());
        assertThat(item.getText(), is(text));
    }

}
