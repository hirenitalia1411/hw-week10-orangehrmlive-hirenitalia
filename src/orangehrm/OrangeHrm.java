package orangehrm;
/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrangeHrm {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {

        // Step 1: Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefix")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else{
            System.out.println("Wrong Browser Name");
        }

        // Step 2: Open URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        // Step 3: Print title of the page
        System.out.println("Title of the page: " + driver.getTitle());

        // Step 4: Print the current URL
        System.out.println("Current Url: " + driver.getCurrentUrl());

        // Step 5: Print the page resource
        System.out.println(driver.getPageSource());

        // Step 6: Click on ‘Forgot your password?’ link
        driver.findElement(By.cssSelector("p[class^='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        // Step7: Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Step 8: Navigate back (using back button on the browser)
        driver.navigate().back();

        // Step 9: Refresh the page (using refresh button on the browser)
        driver.navigate().refresh();

        // Step 10: Enter email to the email field
        driver.findElement(By.name("username")).sendKeys("Admin");

        // Step 11: Enter password to the password field
        driver.findElement(By.name("password")).sendKeys("admin123");"

        // Step 12: Click on login button
        driver.findElement(By.cssSelector("button[type^='submit']")).click();

        // Step 13: Close the browser
        driver.quit();
    }
}
