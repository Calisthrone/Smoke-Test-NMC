package TestUtils;

import DataRepo.Vars;
import Locators.HomeLoc;
import Super.SuperPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchUtil extends SuperPage{

    public SearchUtil(WebDriver driver) {super(driver);}

    // This will set the searchResultsList in Vars with the list of search results element list.
    public void setResultsList() {
        waitForVisibilityOf(HomeLoc.allSearchResultsSelector);
        Vars.searchResultElementList = driver.findElements(HomeLoc.allSearchResultsSelector); // contains all results
    }

    // This will set the searchResultsCount in Vars with the number od search results found.
    public void setResultsCount() {Vars.searchResultsCount = Vars.searchResultElementList.size();}
}
