package pagehelper;

import data.Vars;
import locator.HomeLoc;
import superclass.SuperPage;
import org.openqa.selenium.WebDriver;

public class SearchHelper extends SuperPage{

    public SearchHelper(WebDriver driver) {super(driver);}

    // This will set the searchResultsList in Vars with the list of search results element list.
    public void setTheResultsList() {
        waitForVisibilityOf(HomeLoc.allSearchResultsSelector);
        Vars.searchResultElementList = driver.findElements(HomeLoc.allSearchResultsSelector); // contains all results
    }

    // This will set the searchResultsCount in Vars with the number od search results found.
    public void setTheResultsCount() {Vars.searchResultsCount = Vars.searchResultElementList.size();}
}
