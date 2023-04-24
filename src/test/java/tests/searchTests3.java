package tests;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.MainBasePage;
import pages.Results;
import pages.Suggestions;

public class searchTests3 extends BaseTest {

    private MainBasePage mainPage;
    private Suggestions suggestions;
    private Results results;

    @Test
    public void searchIt1() throws InterruptedException {
        mainPage=new MainBasePage(webDriver);
        suggestions=mainPage.enterSearchTerm("OpenText");
        results=suggestions.chooseSearchTermFromList(0);
        System.out.println(results.getResult(0));
      }

}
