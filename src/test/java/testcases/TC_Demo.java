package testcases;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Just a Samplte Demo Class to demonstrate the Junit Execution Sequence
public class TC_Demo {
    

    @BeforeClass
    public static void setUpClass(){
        System.out.println("I am Before Class");
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
