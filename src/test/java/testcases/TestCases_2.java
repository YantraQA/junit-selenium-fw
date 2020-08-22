package testcases;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCases_2 extends TestBase {

    @Before
    public void set_up(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }

    @Test
    public void t_02_search_for_() throws InterruptedException {
        driver.get(base_url);
        String expected = "Personalized Holiday Packages | Customized Tour Packages from multiple local and trusted travel agents";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);

        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type a Destination']")));

        Thread.sleep(20000);

        //Select destinations
        driver.findElement(By.xpath("//input[@placeholder='Type a Destination']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Type a Destination']")).sendKeys("Kerala");
        driver.findElement(By.xpath("//button[text()='Kerala']")).click();

        driver.findElement(By.xpath("//input[@value='Select duration']")).click();
        driver.findElement(By.xpath("//label[@for='inputDays_1-3']")).click();
        driver.findElement(By.xpath("//input[@value='Select month']")).click();
        driver.findElement(By.xpath("//button[text()='November, 2020']")).click();
        driver.findElement(By.xpath("//button[@class='at_explore_btn btn-filled-pri-large wfull ripple']")).click();


    }

    @After
    public void clean_up(){
        //driver.quit();
    }

}
