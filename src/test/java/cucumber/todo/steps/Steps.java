package cucumber.todo.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.PendingException;
import org.apache.xpath.operations.String;
import org.junit.Before;
import org.junit.Test;

public class Steps {

    @Before
    public void setUp() throws Exception {
    }

    @Given("^I am on the To-Do page$")
    public void I_am_on_the_To_Do_page() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_fill_in_with(String arg1, String arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^I press \"([^\"]*)\"$")
    public void I_press(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void I_should_see(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

}
