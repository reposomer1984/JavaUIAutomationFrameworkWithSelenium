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



    public void SetUpDriver(String browser){
        System.out.println("browser: "+browser);
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



    @Parameters("browser")
    @BeforeMethod
    public void OpenBrowser(String browser) throws Exception{
        SetUpDriver(browser);
        OpenSite();
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }


}
