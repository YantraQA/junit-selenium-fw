package testcases;

import core.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HomePageObjects;
import pageobjects.SignInPageObjects;

public class TestCases_1 extends TestBase {
// Page Object Model
    //Divide into pages
//home page (all the objects should go to the home page file(text, excel file, properties, configuration, java)
//Search page( all the object should go in the search page file
//Add to Cart (all the object should go in add to cart page file
//Check out page
//Payment Page

    @Test
    public void t_01_check_website_is_working(){
        driver.get(base_url);
        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
    }

    //If not using Page Object model
    @Test
    public void t_02_check_sign_in_button_on_home_page_not_using_page_object_model(){
        driver.get(base_url);
        WebElement element  = driver.findElement(By.linkText("Sign in securely"));
        element.click();

        if (driver.findElement(By.id("ap_email")).isDisplayed()){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Email text box does not appear for login after clicking on Sign in button");
        }
    }

    @Test
    public void t_02_check_sign_in_button_on_home_page_using_page_object_model(){
        driver.get(base_url);

        //Init Page Objects
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        SignInPageObjects signInPageObjects = new SignInPageObjects(driver);

        //Test Steps
        homePageObjects.clickLinkSignInSecurely();
        signInPageObjects.validateEmailInputTextBoxIsDisplayed();

    }

    @Test
    public void t_03_sign_in_the_app_using_sign_in_securly_link_in_home_page(){
        driver.get(base_url);

        //Init Page Objects
        HomePageObjects homePageObjects = new HomePageObjects(driver);
        SignInPageObjects signInPageObjects = new SignInPageObjects(driver);

        //Steps
        signInPageObjects.validateEmailInputTextBoxIsDisplayed();
        signInPageObjects.enterTextInEmailTextBox("akashdktyagi@gmail.com");

    }


}
