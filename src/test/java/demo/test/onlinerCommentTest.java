package demo.test;

import webdriver.BaseTest;
import demo.test.forms.onlinerMainForm;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class onlinerCommentTest extends BaseTest{
    private String login;
    private String password;
    private String testTextComment;
    @BeforeTest
    @Parameters({"login","password","testTextComment"})
    public void readParams(String login, String password, String testTextComment) throws Throwable {
        this.login = login;
        this.password = password;
        this.testTextComment = testTextComment;
    }

    @Override
    public void runTest() {
        logger.step(1);
        browser.navigate("http://www.onliner.by");
        logger.step(2);
        onlinerMainForm omf = new onlinerMainForm();
        omf.login(login,password);
        logger.step(3);
        browser.waitForPageToLoad();
        omf.openPeople();
        logger.step(4);
        omf.openNewsPost();
        logger.step(5);
        omf.comment(testTextComment);
        browser.waitForPageToLoad();
        logger.step(6);
        omf.assertComment();
    }
}
