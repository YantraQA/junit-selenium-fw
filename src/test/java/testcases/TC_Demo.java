package testcases;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_Demo {

    public void t_1(){
        WebDriver driver = new FirefoxDriver();
        driver.get("url");
        driver.findElement(By.linkText("sdfdsf")).click();
        Assert.assertEquals("sdfdsf",true,true);
        driver.quit();
    }

    public void t_2(){
        WebDriver driver = new FirefoxDriver();
        driver.get("url");
        driver.findElement(By.linkText("sdfdsf")).click();
        Assert.assertEquals("sdfdsf",true,true);
        driver.quit();
    }


    @BeforeClass
    public void setUpClass(){

    }

    @Before
    public void setUp(){
        System.out.println("I am Set Up");
    }

    @After
    public void cleanUp(){
        System.out.println("I am Clean Up");
    }

    @Test
    public void t1(){
        System.out.println("t1");
    }

    @Test
    public void t2(){
        System.out.println("t2");
    }

    @Test
    public void t3(){
        System.out.println("t3");
    }

    @Test
    public void t4(){
        System.out.println("t4");
    }

}