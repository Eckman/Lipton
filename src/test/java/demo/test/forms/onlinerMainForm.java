package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.elements.Button;
import webdriver.elements.TextBox;
import webdriver.elements.Label;
import webdriver.BaseForm;

public class onlinerMainForm extends BaseForm{

    private static String formlocator="//body";
    private TextBox searchBox = new TextBox(By.id("g-search-input"),"search bar");
    private Button searchButton = new Button(By.className("top-search-button"),"search bar button");
    private Button searchCatalogBtn = new Button(By.linkText("Каталог и цены"),"catalog");
    private Button searchBaraholkaBtn = new Button(By.linkText("Барахолка"),"baraholka");
    private Button searchForumBtn = new Button(By.linkText("Форум"),"forum");
    private Button searchNewsBtn = new Button(By.linkText("Новости и статьи"),"news");

    private Label searchResultCatalog = new Label(By.xpath("//strong[@class='pname']/a"),"searching in catalog result");
    private Label searchResultBaraholka = new Label(By.xpath("//tr[@class='m-imp']"),"searching in baraholka result");
    private Label searchResultForum = new Label(By.xpath("//h1[@class='m-title']/span[contains(.,'найдено')]"),"searching in forum result");
    private Label searchResultNews = new Label(By.xpath("//header[@class='b-search-results-header']/small[contains(.,'найдено')]"),"news search result");

    private Button techButton = new Button(By.xpath("//a[contains(.,'Технологии')]"),"technologies");
    private Button peopleButton = new Button(By.xpath("//a[contains(.,'Люди')]"),"peoples");
    private Label lastPeoplePost = new Label(By.xpath("//h3[@class='b-posts-1-item__title']/a"),"first post in people's module");
    private Button autoButton = new Button(By.xpath("//a[contains(.,'Авто')]"),"das auto");
    private Button realtButton = new Button(By.xpath("//a[contains(.,'Недвижимость')]"),"realt");
    private Button forumButton = new Button(By.xpath("(//a[contains(.,'Форум')])[2]"),"forum");
    private Button catalogButton = new Button(By.xpath("(//a[contains(.,'Каталог и цены')])[2]"),"catalog");
    private Button baraholkaButton = new Button(By.xpath("(//a[contains(.,'Барахолка')])[2]"),"baraholka");

    private Label mainLogo = new Label(By.className("b-top-logo"),"main logo");

    private TextBox loginBox = new TextBox(By.xpath("//input[@name='username']"),"Login box");
    private Label loginHref = new Label(By.linkText("Войти"),"url to login");
    private TextBox passBox = new TextBox(By.xpath("//input[@name='__nothing']"), "password box");
    private Button loginButton = new Button(By.cssSelector("button.submit"),"Sign in");
    private Label userName = new Label(By.xpath("//p[@class='user-name']/a"), "username afterlogin");
    private Button onlinerUserName = new Button(By.xpath("//big[@class='onliner__user__name']/a"),"url to login from user's page");
    private Button unlogin = new Button(By.cssSelector(".exit"), "unlogin");

    private Label profileStatusOnline = new Label(By.xpath("//p[@class='uprofile-connect user-status']/span"),"status inside user's page");
    private Button editProfileButton = new Button(By.linkText("Редактировать личные данные"),"edit");
    private Button submitProfile = new Button(By.xpath("//div[@class='btn']/button[@type='submit']/span/span[contains(.,'Сохранить')]"),"submit button inside profile");

    private TextBox city = new TextBox(By.name("city"));
    private TextBox occupation = new TextBox(By.name("occupation"));
    private TextBox intersts = new TextBox(By.name("interests"));
    private TextBox jabber = new TextBox(By.name("jabber"));
    private TextBox site = new TextBox(By.name("website"));
    private TextBox cityDone = new TextBox(By.xpath("//div[@id='notedit']/div/dl[1]/dd[3]"),"submitted city");
    private TextBox occupationDone = new TextBox(By.xpath("//div[@id='notedit']/div/dl[1]/dd[4]"),"subm occupation");
    private TextBox interstsDone = new TextBox(By.xpath("//div[@id='notedit']/div/dl[1]/dd[5]"),"subm interests");
    private TextBox jabberDone = new TextBox(By.xpath("//div[@id='notedit']/div/dl[2]/dd[1]/a"),"subm jabber");
    private TextBox siteDone = new TextBox(By.xpath("//div[@id='notedit']/div/dl[2]/dd[2]/a"),"subm site");

    private Button bookMark = new Button(By.id("bookmark_link"),"bookmark making");
    private Label bookmarkDelete = new Label(By.xpath("//div[@class='h-bookmark-remove']/a"), "bookmark delete button");

    private TextBox commentTB = new TextBox(By.xpath("//textarea[@class='text-editor postmessage markItUpEditor']"),"coment text box");
    private Button commentButton = new Button(By.xpath("//div[@class='b-comments-form-button']/button"),"comment button");
    private Label postedComment = new Label(By.xpath("//a[contains(.,'Редактировать')]"),"my comment");

    public void assertProfile(String cityParam,
                              String occupationParam,
                              String interestsParam,
                              String jabberParam,
                              String siteParam
                             ) {
        onlinerUserName.click();
        assertEquals(cityParam,cityDone.getText());
        assertEquals(occupationParam,occupationDone.getText());
        assertEquals(interestsParam,interstsDone.getText());
        assertEquals(jabberParam,jabberDone.getText());
        assertEquals(siteParam,siteDone.getText());
    }

    public void editProfile(String cityParam,
                            String occupationParam,
                            String interestsParam,
                            String jabberParam,
                            String siteParam
                            )   {
        editProfileButton.click();
        city.type(cityParam);
        occupation.type(occupationParam);
        intersts.type(interestsParam);
        jabber.type(jabberParam);
        site.type(siteParam);
        submitProfile.click();
    }

    public void assertProfileStatus()  {
        assertEquals(profileStatusOnline.getText(),"Онлайн");
    }

    public void profileOpen()   {
        userName.click();
        browser.waitForPageToLoad();
    }

    public void assertComment()  {
        assert(postedComment.isPresent(3));
    }

    public void comment(String text)    {
        commentTB.type(text);
        commentButton.click();
        browser.waitForPageToLoad();
    }

    public void openNewsPost()  {
        lastPeoplePost.click();
        browser.waitForPageToLoad();
    }

    public void assertBookmark()    {
        assert(bookmarkDelete.isPresent());
    }

    public void makeBookmark()  {
        bookMark.click();
    }

    public void deleteBookmark()   {
        bookmarkDelete.click();
    }
    public void openSearch()    {
        searchResultCatalog.click();
    }

    public void openCatalog() {
        catalogButton.click();
        browser.waitForPageToLoad();
        assertEquals("http://catalog.onliner.by/",browser.getLocation());
    }
    public void openTech() {
        techButton.click();
        browser.waitForPageToLoad();
        assertEquals("http://tech.onliner.by/",browser.getLocation());
    }
    public void openAuto() {
        autoButton.click();
        browser.waitForPageToLoad();
        assertEquals("http://auto.onliner.by/",browser.getLocation());
    }
    public void openPeople() {
        peopleButton.click();
        browser.waitForPageToLoad();
        assertEquals("http://people.onliner.by/",browser.getLocation());
    }
    public void openRealt() {
        realtButton.click();
        browser.waitForPageToLoad();
        assertEquals("http://realt.onliner.by/",browser.getLocation());
    }
    public void openBarah() {
        baraholkaButton.click();
        browser.waitForPageToLoad();
        assertEquals("http://baraholka.onliner.by/",browser.getLocation());
    }
    public void openForum() {
        forumButton.click();
        browser.waitForPageToLoad();
        assertEquals("http://forum.onliner.by/",browser.getLocation());
    }

    public void assertLogo(){
        assert(mainLogo.isPresent());
    }

    public void assertUnlogin() {
        assert(loginHref.isPresent());
    }

    public void unlogin() {
        unlogin.click();
    }

    public void assertLogin(String login)   {
        assertEquals(login,userName.getText());
    }

    public void login(String login, String password) {
        loginBox.type(login);
        passBox.click();
        passBox = new TextBox(By.xpath("//input[@name='password']"),"Password box");
        passBox.type(password);
        loginButton.click();
    }

    public void searchInCatalog(String text) {
        searchCatalogBtn.click();
        searchBox.type(text);
        searchButton.click();
    }

    public void searchInBarahoka(String text) {
        searchBaraholkaBtn.click();
        searchBox.type(text);
        searchButton.click();
    }

    public void searchInForum(String text) {
        searchForumBtn.click();
        searchBox.type(text);
        searchButton.click();
    }

    public void searchInNews(String text) {
        searchNewsBtn.click();
        searchBox.type(text);
        searchButton.click();
    }

    public void searchAssertCatalog(String searchText) {
        assert(searchResultCatalog.getText().contains(searchText));
    }

    public void searchAssertBaraholka() {
        assert(searchResultBaraholka.isPresent());
    }

    public void searchAssertForum() {
        assert(searchResultForum.isPresent());
    }

    public void searchAssertNews() {
        assert(searchResultNews.isPresent());
    }

    public onlinerMainForm() {
        super(By.xpath(formlocator), "My onlIner form");
    }
}