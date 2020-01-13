package com.hellofresh.test;

import common.Base;
import common.PropertyLoader;
import common.User;
import org.junit.Test;
import pageobject.HomePage;
import pageobject.SingInPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Properties;

public class WebTest extends Base {

    private static final Logger logger = LogManager.getLogger(WebTest.class);

    private Properties properties = new PropertyLoader("test.properties").load();
    private String existingUserEmail = properties.getProperty("existing.user");
    private String existingUserPassword = properties.getProperty("existing.password");


    @Test
    public void signInTest() {

        logger.info("signInTest is started");
        HomePage homePage = new HomePage(driver);
        SingInPage signInPage = new SingInPage(driver);
        User user = new User();

        logger.info("Loading the Home Page");
        homePage.loadHomePage();
        logger.info("Opening the SignIn page");
        homePage.goToSignInPage();
        logger.info("Creating a new account");
        signInPage.createAnAccount(user);
        logger.info("Validating the user creation");
        signInPage.validateUserCreation(user);

    }

    @Test
    public void logInTest() {

        logger.info("logInTest is started");
        HomePage homePage = new HomePage(driver);
        SingInPage signInPage = new SingInPage(driver);
        String fullName = "Joe Black";

        logger.info("Loading the Home Page");
        homePage.loadHomePage();
        logger.info("Opening the SignIn page");
        homePage.goToSignInPage();
        signInPage.login(existingUserEmail, existingUserPassword);
        signInPage.validateSuccessfulLogin(fullName);
    }

    @Test
    public void checkoutTest() {

//        TODO: Due to the time limitation, I did not refactor this test though my approach would be the same as
//        previous tests i.e define a page object for checkout and read all of the input and desired data via PropertyLoader class.
//        Please have a look at SignInPage.java

    }
}
