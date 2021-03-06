package demo.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;
import demo.test.forms.onlinerMainForm;

public class onlinerForumSearchTest extends BaseTest {

    private String searchText1;
    @BeforeTest
    @Parameters({"searchText1"})
    public void readParams(String searchText1) throws Throwable {
        this.searchText1 = searchText1;
    }

    public void runTest() {
        logger.step(1);
        browser.navigate("http://www.onliner.by");
        logger.step(2);
        onlinerMainForm omf = new onlinerMainForm();
        omf.assertLogo();
        logger.step(3);
        omf.searchInForum(searchText1);
        logger.step(4);
        omf.searchAssertForum();
    }
}