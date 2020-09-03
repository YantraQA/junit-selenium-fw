package testcases;

import core.TestBase;
import core.webdriverfactory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CmnPageObjects;

public class TestCases_2 extends TestBase {

    private static final Logger logger = LogManager.getLogger(TestCases_2.class);

    @Test
    public void t_01_search_for_product() {

        logger.info("Test case started: t_02_search_for_product");

        //Navigating to the Url
        WebDriverFactory.navigateToTheUrl(base_url);

        //Init Page Object model class file
        CmnPageObjects cmnPageObjects = new CmnPageObjects(driver);
        cmnPageObjects.validatePageTitleMatch(defaultPageTitleText);

        //Search Text Box
        cmnPageObjects.SetSearchTextBox("Laptop");
        cmnPageObjects.ClickOnSearchButton();
        cmnPageObjects.validatePageTitleMatch("Amazon.in : Laptop");

        logger.info("Test case Ended: t_02_search_for_product");
    }
}
