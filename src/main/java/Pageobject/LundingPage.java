package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LundingPage {
    WebDriver driver;
    public LundingPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   @FindBy(xpath = "//a[@title='My Account']")
    WebElement MyaccountDropdown;
    @FindBy(linkText = "Login")
    WebElement LoginOption;








    public WebElement  MyaccountDropdown(){
        return  MyaccountDropdown;
    }
    public WebElement LoginOption(){
        return LoginOption;
    }


}
