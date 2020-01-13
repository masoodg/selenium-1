package pageobject;

import common.Base;
import common.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;


public class HomePage extends Base {

    private PropertyLoader properties = new PropertyLoader("test.properties");

    @FindBy(className = "login")
    private WebElement loginMenu;

    private final WebDriver driver;

    public HomePage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loadHomePage() {
        String homeURL = properties.load().getProperty("home.url");
        driver.get(homeURL);
    }

    public void goToSignInPage() {
        loginMenu.click();
    }


}
