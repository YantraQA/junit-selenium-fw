package testcases;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCases_2 extends TestBase {

    @Before
    public void set_up(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }

    @Test
    public void t_02_check_website_is_working(){
        driver.get(base_url);
        String expected = "Personalized Holiday Packages | Customized Tour Packages from multiple local and trusted travel agents";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
    }

    @After
    public void clean_up(){
        driver.quit();
    }

}
