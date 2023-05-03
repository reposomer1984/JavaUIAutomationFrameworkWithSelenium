package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private static BrowserFactory instance = null;

    private BrowserFactory() {
    }

    public static BrowserFactory getInstance() {
        if (instance == null) {
            instance = new BrowserFactory();
        }
        return instance;
    }

    public final void setDriver(String browser) throws MalformedURLException {
        String host =System.getProperty("hub_host");
        if (host == null) {
            host = "localhost";
        }
        String url = "http://" + host + ":4444/wd/hub";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (browser) {
            case "ch":
                desiredCapabilities = DesiredCapabilities.chrome();
                try {
                    webDriver.set(new RemoteWebDriver(new URL(url), desiredCapabilities));
                } catch (MalformedURLException e) {
                    throw new MalformedURLException(e.getLocalizedMessage());
                }
                break;
            case "ff":
                desiredCapabilities = DesiredCapabilities.firefox();
                try {
                    webDriver.set( new RemoteWebDriver(new URL(url), desiredCapabilities));
                } catch (MalformedURLException e) {
                    throw new MalformedURLException(e.getLocalizedMessage());
                }
                break;
        }


    }

    public WebDriver getDriver() {
        return webDriver.get();
    }
}
