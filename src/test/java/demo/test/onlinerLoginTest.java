package demo.test;

import webdriver.BaseTest;
import demo.test.forms.onlinerMainForm;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class onlinerLoginTest extends BaseTest{

    private String login;
    private String password;
    @BeforeTest
    @Parameters({"login","password"})
    public void readParams(String login, String password) throws Throwable {
        this.login = login;
        this.password = password;
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
        logger.step(4);
        omf.assertLogin(login);
        logger.step(5);
        omf.unlogin();
        browser.waitForPageToLoad();
        logger.step(6);
        omf.assertUnlogin();
    }
}
