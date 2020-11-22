# junit-selenium-fw
Junit Based Automation Framework for Beginners

#### 1. Branch: ```first-test-case-without-pom```
> Learning Objective:
>> Basic Maven Project <br>
>> POM File <br>
>> Basic Selenium Test

* Create a Maven Project
* Add below dependency in the POM file:
```xml
 <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
    </dependencies>
```
* Create package under ```test.java``` with name as ```testcases```
* Create a Test Class: ```test.java.testcases.RunTest```
* Add test case to invoke the browser and navigate to the amazon.in web site
* Note that ```@Test``` annotation is used to invoke the test cases. This annotation is provided to us by Junit library which we have added.
* Also Note annotation ```@Before``` ```@After```. 
* All the annotation which has ```@Before``` annotated method will execute before every test.
* All the annotation which has ```@After``` annotated method will execute after every test.

```java
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TC_ClassFile1 {

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
        String expected = "amazon";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);
    }
    
    //This method will execute after the end of each @Test annotated method.
    @After
    public void clean_up(){
        driver.quit();
    }
}
```

#### 2. Branch: ```2-test-base-second-test-case```
> Learning Objective:
>> Inheritance: Test Base Class <br>
>> Explicit Wait

* In this next enhancement we are making using of inheritance concept i.e. use of ```TestBase``` Class
* All the reusable component can be shifted to this class and all the TestCase Class will inherit this ```TestBase``` class.
* So you can make use of ```TestBase``` Class whenever you wish to create a new Test Class.
* In this case we have two test class and both inheriting the ```TestBase``` class.

```java
//Test Base class
package base;

import org.junit.After;
import org.openqa.selenium.WebDriver;

public class TestBase {
    protected WebDriver driver; //this should never be static, if made static parallel exec of classes not possible
    protected final static String base_url = "https://amazon.in";
    protected final static int implicit_wait_timeout_in_sec = 20;
}
```

* Please notice ```extends``` keyword in Test Classes
* This is how we can make use of methods and variables in the Parent Class which in this case is ```TestBase``` class.
* Driver is declared in the Base Class and can be used in Child Classes. 
* This brings reusability and maintainability of code.
```java
public class TestCases_1 extends TestBase {

    @Before
    public void set_up(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }
```

```java
public class TestCases_2 extends TestBase {

    @Before
    public void set_up(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }
```
* Add another test case for search.
* Notice the Sync i.e. web driver wait ```WebDriverWait webDriverWait = new WebDriverWait(driver,20);```
* After a product is searched, we need to instruct the Selenium to wait for specific condition before proceeding to the next step.
* This is called as "Explicit Wait" i.e. we are explicitly instructing the java script to wait for Element to be clickable.

```java
    @Test
    public void t_02_search_for_product() {
        driver.get(base_url);
        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);

        //Wait and Search for product
        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));

        elementSearchBox.sendKeys("Laptop");
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        //Wait for title
        WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
        webDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));

        //Assertion for Page Title
        Assert.assertEquals("Page Title validation","Amazon.in : Laptop", driver.getTitle());
    }
```