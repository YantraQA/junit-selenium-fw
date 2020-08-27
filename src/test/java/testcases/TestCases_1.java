package testcases;

import core.TestBase;
import core.webdriverfactory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.CmnPageObjects;

public class TestCases_1 extends TestBase {

    private static final Logger logger = LogManager.getLogger(TestCases_1.class);

    @Test
    public void t_01_check_website_is_working(){
        logger.info("Test case started: t_01_check_website_is_working");

        //Navigating to the Url
        WebDriverFactory.navigateToTheUrl(base_url);

        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
        logger.info("Page Title validation successfull. Expected and actual text matched. Text: " + actual );
        logger.info("Test case Ended: t_01_check_website_is_working");
    }
}
