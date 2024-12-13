package com.tests;

import base.BaseTest;
import com.automate.customannotations.FrameworkAnnotation;
import com.automate.entity.TestData;
import com.automate.enums.CategoryType;
import com.automate.pages.HomePage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automate.driver.manager.DriverManager;

import static org.testng.AssertJUnit.assertEquals;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class appTest extends BaseTest {

  HomePage homePage;

  @FrameworkAnnotation(author = "Tanveer Mujtaba Khan", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(description = "validate the default value in text field is Zero")
  public void validateDefaultValueInHomePage(TestData data) {
    try {
      System.out.println("Starting validate Default Value In HomePage is Zero");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

     // Get and print the text of the element
      String initialValue = homePage.validateInitialValue();
      System.out.println("Counter value: " + initialValue);

      // Validate the counter value
      assertEquals("1", initialValue);

      System.out.println("Test completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Test failed due to exception: " + e.getMessage());
    }
  }

  @FrameworkAnnotation(author = "Tanveer Mujtaba Khan", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(description = "Validate the increment value button on the homepage. On clicking the button, the value should be reflected in the text field. ")
  public void validateIncrementValueButtonActionInHomePage(TestData data) {
    try {
      System.out.println("Starting Validate the increment value (+1) button on the homepage");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateIncrementValue("1");
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("1", setValue);

      System.out.println("Test completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Test failed due to exception: " + e.getMessage());
    }
  }

  @FrameworkAnnotation(author = "Tanveer Mujtaba Khan", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(description = "Validate the Decrement value (-2) button on the homepage. On clicking the button, the value should be reflected in the text field. ")
  public void validateDecrementValueButtonActionInHomePage(TestData data) {
    try {
      System.out.println("Starting Validate the decrement value button on the homepage");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateDecrementValue("-2");
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("-2", setValue);

      System.out.println("Test completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Test failed due to exception: " + e.getMessage());
    }
  }

  @FrameworkAnnotation(author = "Tanveer Mujtaba Khan", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(description = "Validate the Reset button on the homepage. On clicking the button, the value should be reflected in the text field. ")
  public void validateResetButtonActionInHomePage(TestData data) {
    try {
      System.out.println("Starting Validate the Reset button on the homepage");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateResetButtonFunctionality();
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("0", setValue);

      System.out.println("Test completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Test failed due to exception: " + e.getMessage());
    }
  }

  @FrameworkAnnotation(author = "Tanveer Mujtaba Khan", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(description = "Validate Calender button functionality along with ok button")
  public void validateCalenderFunctionalityInHomePageWithCancelButton(TestData data) {
    try {
      System.out.println("Starting Validate the Calender button on the homepage with Cancel button");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateCalenderFunctionalityWithCancelButton();
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("0", setValue);

      System.out.println("Test completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Test failed due to exception: " + e.getMessage());
    }
  }

  @FrameworkAnnotation(author = "Tanveer Mujtaba Khan", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(description = "Validate Calender button functionality along with ok button")
  public void validateCalenderFunctionalityInHomePageWithOKButton(TestData data) {
    try {
      System.out.println("Starting Validate the Reset button on the homepage");
      homePage = new HomePage();
      PageFactory.initElements(DriverManager.getDriver(), homePage);

      // Get and print the text of the element
      String setValue = homePage.validateCalenderFunctionalityWithOKButton();
      System.out.println("Set value: " + setValue);

      // Validate the counter value
      assertEquals("0", setValue);

      System.out.println("Test completed successfully.");
    } catch (Exception e) {
      System.out.println("Error occurred during test execution: " + e.getMessage());
      e.printStackTrace();
      Assert.fail("Test failed due to exception: " + e.getMessage());
    }
  }

  // Tapping is not possible on this element because the response is an instance, not a clickable element.
  @FrameworkAnnotation(author = "Tanveer Mujtaba Khan", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
  @Test(description = "Validate Calender button functionality along with ok button")
  public void tappingFunctionality(TestData data) {
      System.out.println("Tapping is not possible on this element because the response is an instance, not a clickable element.");

      //Sample Code
    /* public void testAppBusyInvalidAction() {
        // Simulate app being busy (e.g., loading screen or busy state)
        // Example: Click on the +1 button while the app is "busy"
        MobileElement incrementButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='+1']"));
        // Assuming we simulate the busy state with a loading spinner or progress bar
        // Ideally, we should have a loading state or progress bar visible here
        MobileElement loadingSpinner = driver.findElement(By.xpath("//android.widget.ProgressBar[@content-desc='loading']"));
        Assert.assertTrue("App should show loading spinner", loadingSpinner.isDisplayed());

        // Try clicking the button while the app is busy
        incrementButton.click();
        MobileElement counter = driver.findElement(By.xpath("//android.view.View[@content-desc='0']")); // Expect no increment
        Assert.assertEquals("Counter should not change when app is busy", "0", counter.getText());
    } */
  }



}
