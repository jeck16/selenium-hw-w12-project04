package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "https://www.saucedemo.com/";

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        // Verify the text “PRODUCTS”
        String expected = "Products";
        String actual = driver.findElement(By.xpath("//span[text() = 'Products']")).getText();
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int expected = 6;
        int actual = products.size();
        Assert.assertEquals(expected, actual);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Before
    public void setup() {
        openBrowser(baseUrl);

    }

}
