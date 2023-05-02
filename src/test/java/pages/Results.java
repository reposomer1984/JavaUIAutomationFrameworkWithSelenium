package pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Results extends BasePage {

    private  WebDriver driver;

    @FindBy(css = ".yuRUbf")
    private List<WebElement> Links;

    public Results(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        this.waitForVisibility(Links.get(0));
    }

    public boolean isResultExistInLinksList(String text){
      return   Links.stream().anyMatch(f->f.getText().toLowerCase().contains(text));
    }

    public String getResult(int index){return Links.get(index).getText();}

}
