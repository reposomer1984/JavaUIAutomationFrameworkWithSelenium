package tests;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.Results;
import pages.Suggestions;

public class searchTests1 extends BaseTest {

    private MainPage mainPage;
    private Suggestions suggestions;
    private Results results;

    @Test
    public void searchIt1() throws InterruptedException {
        mainPage=new MainPage(webDriver);
        mainPage.openGoogleSite();
        suggestions=mainPage.enterSearchTerm("microsoft");
        results=suggestions.chooseSearchTermFromList(0);
        System.out.println(results.getResult(0));
      }

}
