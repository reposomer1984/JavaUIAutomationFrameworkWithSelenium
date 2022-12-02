package Base;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.ConfigLoader;

import java.awt.*;


public class BaseTest {

    protected WebDriver webDriver;
    private BrowserFactory browserFactory=BrowserFactory.getInstance();


    @Parameters("browser")
    @BeforeSuite(alwaysRun = true)
    public void SetUpDriver(){
        String browser=System.getProperty("browser","ch");
        if (browser.equalsIgnoreCase("ff")){
             browserFactory.setDriver("ff");
             webDriver=browserFactory.getDriver();
         }
         if (browser.equalsIgnoreCase("ch")){
             browserFactory.setDriver("ch");
             webDriver=browserFactory.getDriver();
         }
        }

        public void  OpenSite(){
            String url= ConfigLoader.getInstance().getPropertyValue("url");
            webDriver.get(url);
            webDriver.manage().window().maximize();
        }



    @BeforeMethod
    public void OpenBrowser() throws Exception{

        OpenSite();
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }


}
