package pages.WebDriverFundamentals;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.TestUtils;

import java.util.Objects;

public class WebFormPage extends BasePage {

    @FindBy(id = "my-text-id")
    private WebElement textInput;

    @FindBy(name = "my-password")
    private WebElement passwordInput;

    @FindBy(name = "my-textarea")
    private WebElement textArea;

    @FindBy(className = "form-select")
    private WebElement dropdownSelect;

    @FindBy(id = "my-check-1")
    private WebElement checkedCheckbox;

    @FindBy(id = "my-check-2")
    private WebElement defaultCheckbox;

    @FindBy(id = "my-radio-1")
    private WebElement checkedRadio;

    @FindBy(id = "my-radio-2")
    private WebElement defaultRadio;

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    public WebFormPage textInput(String input) {
        textInput.sendKeys(input);

        return this;
    }

    public String getTextInputText() {
        return textInput.getDomProperty("value");
    }

    public WebFormPage password(String input) {
        passwordInput.sendKeys(input);

        return this;
    }

    public String getPasswordText() {
        return passwordInput.getDomProperty("value");
    }

    public WebFormPage textArea(String input) {
        textArea.sendKeys(input);

        return this;
    }

    public String getTextAreaText() {
        return textArea.getDomProperty("value");
    }

    public boolean disabledInput() {
        return !getDriver().findElement(By.name("my-disabled"))
                .isEnabled();
    }

    public boolean readonlyInput() {
        return Objects.equals(getDriver().findElement(By.name("my-readonly"))
                .getDomProperty("readOnly"), "true");
    }

    public WebFormSubmitPage clickSubmit() {
        WebElement submit = getWait5().until
                (ExpectedConditions.elementToBeClickable(By.tagName("button")));

        TestUtils.scrollAndClickWithJS(getDriver(), submit);

        return new WebFormSubmitPage(getDriver());
    }

    public WebFormPage dropdownSelect(int index) {
        if (index < 0 || index > 3) {
            throw new IllegalArgumentException("Index must be between 0 and 3");
        }

        new Select(dropdownSelect).selectByIndex(index);

        return this;
    }

    public String getDropdownSelectText() {
        String str = dropdownSelect.getDomProperty("value");

        assert str != null;

        return switch (str) {
            case "Open this select menu" -> "Open this select menu";
            case "1" -> "One";
            case "2" -> "Two";
            case "3" -> "Three";
            default -> throw new IllegalArgumentException();
        };
    }

    public WebFormPage clickCheckedCheckbox() {
        checkedCheckbox.click();

        return this;
    }

    public boolean isCheckedCheckboxSelected() {
        return checkedCheckbox.isSelected();
    }

    public WebFormPage clickDefaultCheckbox() {
        defaultCheckbox.click();

        return this;
    }

    public boolean isDefaultCheckboxSelected() {
        return defaultCheckbox.isSelected();
    }

    public WebFormPage clickCheckedRadio() {
        checkedRadio.click();

        return this;
    }

    public boolean isCheckedRadioSelected() {
        return checkedRadio.isSelected();
    }

    public WebFormPage clickDefaultRadio() {
        TestUtils.scrollAndClickWithJS(getDriver(), defaultRadio);

        return this;
    }

    public boolean isDefaultRadioSelected() {
        return defaultRadio.isSelected();
    }
}
