package tests.WebDriverFundamentals;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WebDriverFundamentals.WebFormPage;
import pages.WebDriverFundamentals.WebFormSubmitPage;

public class WebFormTest extends BaseTest {

    private static final String TEXT_INPUT = "Text for Text Input";
    private static final String PASSWORD = "QWERTY1234";
    private static final String TEXTAREA = "Text for Textarea";

    @Test
    public void webFormTextTest() {
        WebFormPage webFormPage = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .textInput(TEXT_INPUT)
                .password(PASSWORD)
                .textArea(TEXTAREA);

        Assert.assertEquals(webFormPage.getTextInputText(), TEXT_INPUT);
        Assert.assertEquals(webFormPage.getPasswordText(), PASSWORD);
        Assert.assertEquals(webFormPage.getTextAreaText(), TEXTAREA);
    }

    @Test
    public void disabledAndReadonlyTest() {
        WebFormPage webFormPage = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class);

        Assert.assertTrue(webFormPage.disabledInput());
        Assert.assertTrue(webFormPage.readonlyInput());
    }

    @Test
    public void dropdownSelectTest() {
        String dropdownSelectText = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .dropdownSelect(0)
                .getDropdownSelectText();

        Assert.assertEquals(dropdownSelectText, "Open this select menu");
    }

    @Test
    public void dropdownSelectTest1() {
        String dropdownSelectText = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .dropdownSelect(1)
                .getDropdownSelectText();

        Assert.assertEquals(dropdownSelectText, "One");
    }

    @Test
    public void dropdownSelectTest2() {
        String dropdownSelectText = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .dropdownSelect(2)
                .getDropdownSelectText();

        Assert.assertEquals(dropdownSelectText, "Two");
    }

    @Test
    public void dropdownSelectTest3() {
        String dropdownSelectText = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .dropdownSelect(3)
                .getDropdownSelectText();

        Assert.assertEquals(dropdownSelectText, "Three");
    }

    @Test
    public void checkedCheckboxTest() {
        WebFormPage webFormPage = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .clickCheckedCheckbox();

        Assert.assertFalse(webFormPage.isCheckedCheckboxSelected());
    }

    @Test
    public void defaultCheckboxTest() {
        WebFormPage webFormPage = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .clickDefaultCheckbox();

        Assert.assertTrue(webFormPage.isDefaultCheckboxSelected());
    }

    @Test
    public void checkedRadioTest() {
        WebFormPage webFormPage = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .clickDefaultRadio()
                .clickCheckedRadio();

        Assert.assertTrue(webFormPage.isCheckedRadioSelected());
    }

    @Test
    public void defaultRadioTest() {
        WebFormPage webFormPage = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .clickDefaultRadio();

        Assert.assertTrue(webFormPage.isDefaultRadioSelected());
    }

    @Test
    public void clickSubmitTest() {
        WebFormSubmitPage webFormSubmitPage = new MainPage(getDriver())
                .chooseCategory(WEB_FORM, WebFormPage.class)
                .clickSubmit();

        Assert.assertEquals(webFormSubmitPage.getHeaderText(), "Form submitted");
        Assert.assertEquals(webFormSubmitPage.getSmallText(), "Received!");
    }
}
