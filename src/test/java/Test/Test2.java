package Test;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test2 extends CommonAPI {
    WebDriver driver;
    @Test
    public void testtwo() throws IOException, InterruptedException {
        System.out.println("test2");
         driver =intializeDriver();
        driver.get("https://www.amazon.com/");
        driver.wait(3);


    }
}
