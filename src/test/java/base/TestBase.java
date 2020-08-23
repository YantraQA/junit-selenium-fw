package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver; //this should never be static, if made static parallel exec of classes not possible
    protected final static String base_url = "https://amazon.in";
    protected final static int implicit_wait_timeout_in_sec = 20;

    @Before
    public void set_up(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }

    @After
    public void clean_up(){
        driver.quit();
    }

}
