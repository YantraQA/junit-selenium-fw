package testcases;

import core.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CmnPageObjects;

public class TestCases_2 extends TestBase {

    @Test
    public void t_02_search_for_product() {

        //Navigate to the Page
        driver.get(base_url);

        //Init Page Object model class file
        CmnPageObjects cmnPageObjects = new CmnPageObjects(driver);
        cmnPageObjects.validatePageTitleMatch(defaultPageTitleText);

        //Search Text Box
        cmnPageObjects.SetSearchTextBox("Laptop");
        cmnPageObjects.ClickOnSearchButton();
        cmnPageObjects.validatePageTitleMatch("Amazon.in : Laptop");
        
    }
}
