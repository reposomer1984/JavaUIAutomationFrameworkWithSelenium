package pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Suggestions extends BasePage {

    private  WebDriver driver;
    @FindBy(className = "sbct")
    private List<WebElement> searchSuggestions;

    public Suggestions(WebDriver driver) {
        super(driver);
        this.driver=driver;
        waitForVisibility(searchSuggestions.get(2));
    }


    public Results chooseSearchTermFromList(int index)
    {
        searchSuggestions.get(index).click();
        return new Results(driver);
    }
}
