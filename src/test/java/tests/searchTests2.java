package tests;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.Results;
import pages.Suggestions;

public class searchTests2 extends BaseTest {

    private MainPage mainPage;
    private Suggestions suggestions;
    private Results results;

    @Test
    public void searchIt2() throws InterruptedException {
        mainPage=new MainPage(webDriver);
        mainPage.openGoogleSite();
        suggestions=mainPage.enterSearchTerm("apple");
        results=suggestions.chooseSearchTermFromList(0);
        System.out.println(results.getResult(0));
    }
}
