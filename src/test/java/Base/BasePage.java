package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.webDriver=driver;
        wait=new WebDriverWait(driver,60);
        PageFactory.initElements(driver,this);
      }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitForInVisibility(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
