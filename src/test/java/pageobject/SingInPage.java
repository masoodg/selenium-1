package pageobject;

import common.Base;
import common.PropertyLoader;
import common.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SingInPage extends Base {

    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(SingInPage.class);

    private PropertyLoader properties = new PropertyLoader("test.properties");
    private String expectedHeading = properties.load().getProperty("signin.expected.heading");
    private String expectedAccInfo = properties.load().getProperty("signin.expected.account.info");

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(id = "email")
    WebElement emailLogin;

    @FindBy(id = "SubmitCreate")
    WebElement submitEmail;

    @FindBy(id = "id_gender2")
    WebElement gender;

    @FindBy(id = "customer_firstname")
    WebElement name;

    @FindBy(id = "customer_lastname")
    WebElement surName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement postCode;

    @FindBy(id = "other")
    WebElement other;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "phone_mobile")
    WebElement mobile;

    @FindBy(id = "alias")
    WebElement alias;

    @FindBy(id = "submitAccount")
    WebElement submit;

    @FindBy(css = "h1")
    WebElement heading;

    @FindBy(className = "account")
    WebElement account;

    @FindBy(className = "info-account")
    WebElement accountInfo;

    @FindBy(className = "logout")
    WebElement logout;

    @FindBy(id = "passwd")
    WebElement loginPassword;

    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;


    public SingInPage(WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    private void validateURL() {
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }

    public void createAnAccount(User user) {

        // Create a new account via email
        logger.info("A new account will be create with the following email: " + user.getEmail());
        emailCreate.sendKeys(user.getEmail());
        submitEmail.click();
        gender.click();

        // Fill the user data and submit
        name.sendKeys(user.getName());
        surName.sendKeys(user.getSurname());
        password.sendKeys(user.getPassword());
        Select select = new Select(day);
        select.selectByValue(user.getBDday());
        select = new Select(month);
        select.selectByValue(user.getBDmonth());
        select = new Select(year);
        select.selectByValue(user.getBDyear());
        company.sendKeys(user.getCompany());
        address1.sendKeys(user.getAddress1());
        address2.sendKeys(user.getAddress2());
        city.sendKeys(user.getCity());
        select = new Select(state);
        select.selectByVisibleText(user.getState());
        postCode.sendKeys(user.getPostCode());
        other.sendKeys(user.getOther());
        phone.sendKeys(user.getPhone());
        mobile.sendKeys(user.getMobile());
        alias.sendKeys(user.getAlias());
        submit.click();

    }

    public void login(String userEmail, String password) {
        logger.info("Trying to login with the following user pass: " + userEmail + "&" + password);
        emailLogin.sendKeys(userEmail);
        loginPassword.sendKeys(password);
        submitLogin.click();
    }

    public void validateSuccessfulLogin(String fullName) {
        assertEquals(expectedHeading, heading.getText());
        assertEquals(fullName, account.getText());
        assertTrue(accountInfo.getText().contains(expectedAccInfo));
        assertTrue(logout.isDisplayed());
        validateURL();
    }

    public void validateUserCreation(User user) {
        assertEquals(expectedHeading, heading.getText());
        assertEquals(account.getText(), user.getName() + " " + user.getSurname());
        assertTrue(accountInfo.getText().contains(expectedAccInfo));
        assertTrue(logout.isDisplayed());
        validateURL();
    }
}
