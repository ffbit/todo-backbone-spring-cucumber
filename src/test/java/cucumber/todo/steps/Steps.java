package cucumber.todo.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static cucumber.todo.RunCukesIT.getBaseUrl;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Steps {
    private WebDriver webDriver;

    private WebElement textField;
    private WebElement item;

    @Before
    public void setUpScenario() throws Exception {
        webDriver = new FirefoxDriver();
    }

    @After
    public void tearDownScenario() {
        webDriver.close();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }


    @Given("^I am on the To-Do page$")
    public void I_am_on_the_To_Do_page() throws Throwable {
        getWebDriver().get(getBaseUrl());
    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_fill_in_with(String locator, String text) throws Throwable {
        // Ugly code section
        try {
            textField = getWebDriver().findElement(By.id(locator));
        } catch (RuntimeException e) {
            textField = getWebDriver().findElement(By.className(locator));
        }

        assertTrue(textField.isDisplayed());

        textField.clear();
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

    @Then("^I should see \"([^\"]*)\" in the \"([^\"]*)\" block$")
    public void I_should_see_in_the_block(String text, String locator) throws Throwable {
        WebElement element = getWebDriver().findElement(By.className(locator));

        assertTrue(element.isDisplayed());
        assertThat(element.getText(), is(text));
    }

    @Given("^I have created \"([^\"]*)\" item$")
    public void I_have_created_item(String text) throws Throwable {
        I_am_on_the_To_Do_page();
        I_fill_in_with("new-todo", text);
        I_press("Return");
    }

    @When("^I mark \"([^\"]*)\" item as done$")
    public void I_mark_item_as_done(String text) throws Throwable {
        WebElement todoList = getWebDriver().findElement(By.id("todo-list"));
        item = todoList.findElement(By.cssSelector("li"));
        WebElement checkbox = item.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();
        checkbox = item.findElement(By.cssSelector("input[type='checkbox']"));

        assertThat(checkbox.getAttribute("checked"), is("true"));
        assertThat(item.getAttribute("className"), is("done"));
    }

    @Then("^I should see done \"([^\"]*)\" item$")
    public void I_should_see_done_item(String arg1) throws Throwable {
        assertThat(item.getAttribute("className"), is("done"));
    }

    @When("^I double click on \"([^\"]*)\" item$")
    public void I_double_click_on_item(String text) throws Throwable {
        String xpath = String.format("//label[text()[contains(.,'%s')]]", text);
        WebElement label = getWebDriver().findElement(By.xpath(xpath));

        Actions actions = new Actions(getWebDriver());
        actions.doubleClick(label).build().perform();
    }

    @Then("^I should not see \"([^\"]*)\" item$")
    public void I_should_not_see_item(String text) throws Throwable {
        String xpath = String.format("//label[text()[contains(.,'%s')]]", text);

        // Ugly code section
        // Think about expected property of JUnit @Test
        WebElement label = null;

        try {
            label = getWebDriver().findElement(By.xpath(xpath));
        } catch (RuntimeException e) {
            // Nothing
        }

        assertThat(label, is(nullValue()));
    }
}
