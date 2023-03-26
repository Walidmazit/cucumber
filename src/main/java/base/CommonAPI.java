package base;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonAPI {
    WebDriver driver;
    public Properties prop;

//  public static Logger log = Logger.("devpinoyLogger");
//    private final org.slf4j.Logger LOG = LoggerFactory.getLogger(LoginTest.class);
  public static Logger log =  LogManager.getLogger(CommonAPI.class.getName());


    public WebDriver intializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/yaakoubmazit/qafox/src/main/java/resources/config.Properties");
        prop.load(fis);
               log.debug("Clicked on My Account dropdown");



        String browersname = prop.getProperty("browes");
        if (browersname.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browersname.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browersname.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        }
        return driver;

    }
}









