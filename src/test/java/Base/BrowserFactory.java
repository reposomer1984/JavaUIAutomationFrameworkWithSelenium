package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    WebDriver webDriver;
    private static BrowserFactory instance=null;
    private BrowserFactory(){}

    public static BrowserFactory getInstance() {
        if (instance == null) {
            instance = new BrowserFactory();
        }
        return instance;
    }

    public final void setDriver(String browser){
        switch (browser)
        {
            case "ch":
                WebDriverManager.chromedriver().setup();
                webDriver=new ChromeDriver();
                break;
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                webDriver=new FirefoxDriver();
                break;
        }

    }

    public WebDriver getDriver(){return webDriver;}
}
