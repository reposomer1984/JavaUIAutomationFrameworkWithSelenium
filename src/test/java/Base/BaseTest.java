package Base;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.ConfigLoader;


public class BaseTest {

    protected WebDriver webDriver;

    @BeforeSuite(alwaysRun = true)
    private void setUpDriver(){
         String browser=System.getProperty("browser","ch");
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


    private void GoToSite(){
        String url= ConfigLoader.getInstance().getPropertyValue("url");
        webDriver.get(url);
    }

    @BeforeTest
    public void OpenBrowser() throws Exception{
        GoToSite();
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.close();
    }


}
