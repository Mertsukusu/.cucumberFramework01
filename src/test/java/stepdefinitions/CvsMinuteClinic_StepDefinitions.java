package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CvsMinuteClinicPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;


public class CvsMinuteClinic_StepDefinitions extends TestBase{

    CvsMinuteClinicPage cvsMinuteClinicPage = new CvsMinuteClinicPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),7);

    @Given("user is on the cvs page")
    public void user_is_on_the_cvs_page() {
        Driver.getDriver().get(ConfigReader.getProperty("cvs_url"));
    }

    @Given("user click visitMinuteClinic button")
    public void user_click_visitMinuteClinic_button() {
        cvsMinuteClinicPage.visitMinuteClick.click();
    }

    @When("user enter valid {string}")
    public void user_enter_valid(String string) {
        try {
            //TestBase.waitForVisibility(cvsMinuteClinicPage.noThanksButton,5);
            wait.until(ExpectedConditions.elementToBeClickable(cvsMinuteClinicPage.noThanksButton));
            cvsMinuteClinicPage.noThanksButton.click();
        }catch (Exception e){
            e.printStackTrace();
        }
        cvsMinuteClinicPage.cvsZipcode.sendKeys(string + Keys.ENTER);
    }
    @Then(": Verify results if clinics are less than {int} miles.")
    public void verify_results_if_clinics_are_less_than_miles(Integer int1) {
        try {
//            TestBase.waitForVisibility(cvsMinuteClinicPage.noThanksButton,5);
//            wait.until(ExpectedConditions.visibilityOfAllElements(cvsMinuteClinicPage.mileages));
            wait.until(ExpectedConditions.visibilityOfAllElements(cvsMinuteClinicPage.noThanksButton));
            cvsMinuteClinicPage.noThanksButton.click();
        }catch (Exception e){
            e.printStackTrace();
        }

        for (WebElement each : cvsMinuteClinicPage.mileages) {
            if (each.isDisplayed()) {
                String str = each.getText();
                String newStr = str.substring(0, str.indexOf(" "));
                double DistanceInMile = Double.parseDouble(newStr);
                System.out.println("Distance is : " + str + "and is less than 20: " + (DistanceInMile < int1));
                Assert.assertTrue(DistanceInMile < int1);
            }
        }
    }

}
