package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPageObjects {

    private WebDriver driver;

    private By input_textbox_email  = By.id("ap_email");

    //Section 3: Paratmerize the constuctor
    public SignInPageObjects(WebDriver driver){
        this.driver = driver;
    }

    public void validateEmailInputTextBoxIsDisplayed(){
        if (driver.findElement(input_textbox_email).isDisplayed()){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Email text box does not appear for login after clicking on Sign in button");
        }
    }

    public void enterTextInEmailTextBox(String text){
        driver.findElement(input_textbox_email).sendKeys(text);
    }

}
