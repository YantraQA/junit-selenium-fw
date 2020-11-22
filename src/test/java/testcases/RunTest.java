package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class RunTest {

    WebDriver driver;
    String base_url = "https://amazon.in/";
    int implicit_wait_timeout_in_sec = 20;

    //This method will execute before every Test method
    //Since, we need to invoke Browser for every test case, we will use this annotation to have driver init steps
    @Before
    public void set_up(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }

    @Test
    public void t_01_check_website_is_working(){
        driver.get(base_url);
        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
    }


    //This method will execute after the end of each @Test annotated method.
    @After
    public void clean_up(){
        driver.quit();
    }

}
