package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CvsMinuteClinicPage {
    public CvsMinuteClinicPage( ){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Visit MinuteClinic")
    public WebElement visitMinuteClick;

    @FindBy(xpath = "//a[contains(text(),'No, thanks')]")
    public WebElement noThanksButton;

    @FindBy(xpath = "//input[@id='zip']")
    public WebElement cvsZipcode;

    @FindBy(xpath = "(//*[@class='distance'])[5]")
    public WebElement lastMile;

    @FindBy(xpath = "//div[@class='distance']")
    public List<WebElement> mileages;
}
