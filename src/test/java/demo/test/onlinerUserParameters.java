package demo.test;

import webdriver.BaseTest;
import demo.test.forms.onlinerMainForm;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class onlinerUserParameters extends BaseTest{

    private String login;
    private String password;
    private String city;
    private String occupation;
    private String interests;
    private String jabber;
    private String site;

    @BeforeTest
    @Parameters({"login","password","city","occupation","interests","jabber","site"})
    public void readParams(String login, String password, String city, String occupation, String interests, String jabber, String site) throws Throwable {
        this.login = login;
        this.password = password;
        this.city = city;
        this.interests = interests;
        this.occupation = occupation;
        this.jabber = jabber;
        this.site = site;
    }

    @Override
    public void runTest() {
        logger.step(1);
        browser.navigate("http://www.onliner.by");
        logger.step(2);
        onlinerMainForm omf = new onlinerMainForm();
        omf.login(login,password);
        logger.step(3);
        omf.profileOpen();
        logger.step(4);
        omf.editProfile(city,occupation,interests,jabber,site);
        logger.step(5);
        omf.assertProfile(city,occupation,interests,jabber,site);
    }
}
