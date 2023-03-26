package Test;

import Pageobject.AccountPage;
import Pageobject.LoginPage;
import Pageobject.LundingPage;
import base.CommonAPI;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends CommonAPI {
    WebDriver driver;

  public static Logger log =  LogManager.getLogger(LoginTest.class.getName());

// public static Logger log =  LogManager.getLogger(LoginTest.class.getName());

    @Test(dataProvider  = "getLoginData")

    public void Login( String email,String password,String expectedResults) throws IOException, InterruptedException {

        LundingPage lundingPage = new LundingPage(driver);
        lundingPage.MyaccountDropdown().click();
        log.debug("Clicked on My Account dropdown");
        lundingPage.LoginOption().click();
       log.debug("Clicked on login option");
        Thread.sleep(2000);
        LoginPage loginPage = new LoginPage(driver);
//        loginPage.emailAddressField().sendKeys(prop.getProperty("eamil"));
//        loginPage.passwordAddressField().sendKeys(prop.getProperty("password"));
        loginPage.emailAddressField().sendKeys(email);
        log.debug("Email addressed got entered");
        loginPage.passwordAddressField().sendKeys(password);
       log.debug("Password got entered");
        loginPage.tloginBotton().click();
        log.debug("Clicked on Login Button");

        AccountPage accountPage = new AccountPage(driver);
//        Assert.assertTrue(accountPage.Edityouraccountinformation().isDisplayed());
        String actualResult = null;
        try {
            if (accountPage.Edityouraccountinformation().isDisplayed()) {
               log.debug("User got logged in");

                actualResult = "Successfull";

            }
        } catch (Exception e) {
            actualResult = "Failure";
           log.error("Login Test got failed");


        }
        Assert.assertEquals(actualResult, expectedResults);


    }
    @BeforeMethod
    public void openApplication() throws IOException {
      log.debug( System.getProperty("/Users/yaakoubmazit/qafox/src/main/Log4j.properties"));
        log.debug("debug opened");
        log.debug("Browser got launched");
        driver = intializeDriver();
        driver.get(prop.getProperty("url"));
        log.debug("Navigated to application URL");

    }


    @AfterMethod
    public void close() {
        driver.close();
        log.debug("Browser got closed");


    }






    @DataProvider
    public Object[][] getLoginData() {
        Object[][] data = {{"walidjacob@yahoo.com", "Walid123", "Successfull"}, {"dummy@test.com", "dummy", "Failure"}};
        return data;
    }
}







