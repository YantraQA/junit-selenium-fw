package testcases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC_ClassFile1 {

    WebDriver driver;
    String base_url = "https://traveltriangle.com/";
    int implicit_wait_timeout_in_sec = 20;

    @Before
    public void set_up(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }

    @Test
    public void t_01_check_website_is_working(){
        driver.get(base_url);
        String expected = "Personalized Holiday Packages | Customized Tour Packages from multiple local and trusted travel agents";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
    }

    public void clean_up(){
        driver.quit();
    }

}
