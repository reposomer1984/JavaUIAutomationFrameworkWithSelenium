package Base;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseTest {

    protected WebDriver webDriver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUpDriver(String browser){
         BrowserFactory browserFactory=BrowserFactory.getInstance();
         if (browser.equalsIgnoreCase("ff")){
             browserFactory.setDriver("ff");
             webDriver=browserFactory.getDriver();
         }
         if (browser.equalsIgnoreCase("ch")){
             browserFactory.setDriver("ch");
             webDriver=browserFactory.getDriver();
         }
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }


}
