package base;

import org.junit.After;
import org.openqa.selenium.WebDriver;

public class TestBase {
    protected WebDriver driver; //this should never be static, if made static parallel exec of classes not possible
    protected final static String base_url = "https://amazon.in";
    protected final static int implicit_wait_timeout_in_sec = 20;


}
