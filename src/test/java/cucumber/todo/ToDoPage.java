package cucumber.todo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDoPage {
    private WebDriver driver;

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }

    public void fillInNewItem(String label) {
        findNewItemField().sendKeys(label);
    }

    public void pressReturnOnNewItem() {
        findNewItemField().sendKeys(Keys.RETURN);
    }

    private WebElement findNewItemField() {
        return driver.findElement(By.id("new-todo"));
    }

    public WebElement findItem(String label) {
        String xpath = String
                .format("//label[contains(., '%s')]/ancestor::li[1]", label);

        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findByText(String text) {
        String xpath = String.format("//*[contains(., '%s')]", text);

        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findAndClickCheckbox(String label) {
        return findItem(label).findElement(By.id(""));
    }

    public void findAndEditItemField(String oldLabel, String newLabel) {
        WebElement editItemField = findEditItemField(oldLabel);
        editItemField.clear();
        editItemField.sendKeys(newLabel);
    }

    private WebElement findEditItemField(String oldLabel) {
        By by = By.cssSelector("input.edit[type='text']");

        return findItem(oldLabel).findElement(by);
    }

}
