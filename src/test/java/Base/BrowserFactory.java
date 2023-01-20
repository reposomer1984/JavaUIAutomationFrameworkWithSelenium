package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
        String os = System.getProperty("os.name");
        switch (browser)
        {
            case "ch":
                ChromeOptions ChOptions=new ChromeOptions();
                if (!os.toLowerCase().contains("windows")){
                    ChOptions.addArguments("--headless");
                    ChOptions.addArguments("--disable-gpu");
                }
                WebDriverManager.chromedriver().setup();
                webDriver=new ChromeDriver(ChOptions);
                break;
            case "ff":
                FirefoxOptions FfOptions=new FirefoxOptions();
                if (!os.toLowerCase().contains("windows")){
                    FfOptions.addArguments("--headless");
                    FfOptions.addArguments("--disable-gpu");
                }
                WebDriverManager.firefoxdriver().setup();
                webDriver=new FirefoxDriver(FfOptions);
                break;
        }


    }

    public WebDriver getDriver(){return webDriver;}
}
