package core;

import core.webdriverfactory.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver; //this should never be static, if made static parallel exec of classes not possible
    protected final static String base_url = "https://amazon.in";

    private String getBrowserName(){
        String browserDefault = "chrome"; //Set by default
        String browserSentFromCmd = System.getProperty("browser");
        //mvn clean install -Dbrowser=safari
        //browserSentFromCmd = safari
        if (browserSentFromCmd==null){
            return browserDefault;
        }else{
            return browserSentFromCmd;
        }
    }

    @Before
    public void set_up(){
        String browser = getBrowserName();
        try{
            driver = WebDriverFactory.getWebDriverForBrowser(browser);
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("Browser Initialization failed. Check the Stack Trace. " + e.getMessage());
        }
    }

    @After
    public void clean_up(){
        driver.quit();
    }
}
