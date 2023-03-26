package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    WebElement emailAddressField;
    @FindBy(css = "#input-password")
    WebElement passwordAddressField;
    @FindBy(css = "input[value='Login']")
    WebElement loginBotton;

    public WebElement emailAddressField() {
        return emailAddressField;
    }

    public WebElement passwordAddressField() {
        return passwordAddressField;
    }

    public WebElement tloginBotton() {
        return loginBotton;
    }
}


