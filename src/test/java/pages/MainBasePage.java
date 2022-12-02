package pages;

import Base.BasePage;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainBasePage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchTextBox;

    public MainBasePage(WebDriver driver) {
        super(driver);
    }


    public Suggestions enterSearchTerm(String term) throws InterruptedException {
        for (char ch:term.toCharArray()) {
            searchTextBox.sendKeys(String.valueOf(ch));
            Uninterruptibles.sleepUninterruptibly(1,TimeUnit.MILLISECONDS);
        }
        return new Suggestions(webDriver);
    }
}
