import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void  loginTest() {
        // create object driver
        WebDriver driver;
        driver = new ChromeDriver();

        // maximize windows browser
        driver.manage().window().maximize();

        // navigate to url
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // insert username (using method 1)
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        // insert password (using method 2 more faster)
        driver.findElement(By.id("password")).sendKeys("Password123");

        // click login button
        driver.findElement(By.id("submit")).click();

        // Verify login success and validate the url expected
        String ExpectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrl, ActualUrl);

        // validate if page contains expected ('congratulations')
        WebElement text = driver.findElement(By.xpath("//*[contains(text(),'Congratulations')]"));
        text.isDisplayed();

        // or  using this method
        // driver.findElement(By.xpath("//*[contains(text(),'Log out')]")).isDisplayed();

        // verify log out button
        driver.findElement(By.linkText("Log out")).isDisplayed();

        // quit driver
        driver.quit();
    }
}
