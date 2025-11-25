package tests.WebDriverFundamentals;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WebDriverFundamentals.NavigationPages.NavigationPageOne;

public class NavigationTest extends BaseTest {

    private static final String NAVIGATION_PAGE_ONE_TEXT = "Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua.";
    private static final String NAVIGATION_PAGE_TWO_TEXT = "Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco " +
            "laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit " +
            "in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
    private static final String NAVIGATION_PAGE_THREE_TEXT = "Excepteur sint occaecat cupidatat " +
            "non proident, sunt in culpa qui officia " +
            "deserunt mollit anim id est laborum.";

    @Test
    public void navigationPageOneTest() {
        String navigationPageOneText = new MainPage(getDriver())
                .chooseCategory(NAVIGATION, NavigationPageOne.class)
                .getNavigationTextOneText();

        Assert.assertEquals(navigationPageOneText, NAVIGATION_PAGE_ONE_TEXT);
    }

    @Test
    public void navigationPageTwoTest() {
        String navigationPageTwoText = new MainPage(getDriver())
                .chooseCategory(NAVIGATION, NavigationPageOne.class)
                .clickNavigationPageTwo()
                .getNavigationTextTwoText();

        Assert.assertEquals(navigationPageTwoText, NAVIGATION_PAGE_TWO_TEXT);
    }

    @Test
    public void navigationPageThreeTest() {
        String navigationPageThreeText = new MainPage(getDriver())
                .chooseCategory(NAVIGATION, NavigationPageOne.class)
                .clickNavigationPageThree()
                .getNavigationTextThreeText();

        Assert.assertEquals(navigationPageThreeText, NAVIGATION_PAGE_THREE_TEXT);
    }
}
