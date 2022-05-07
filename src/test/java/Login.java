import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

public class Login {
    public static ChromeDriver driver;

    @BeforeTest
    public void Open() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://patriotlisting.sigmasolve.net:4203/auth/login");
        Thread.sleep(2000);
    }
    @AfterTest
    public void closedriver(){
        driver.close();
    }
    @Test(priority = -2)
    public void VidVpwd() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        String actualUrl = "http://patriotlisting.sigmasolve.net:4203/";
        String expectedUrl = driver.getCurrentUrl();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Login Succesfull");
            driver.findElement(By.xpath("//span[contains(.,'Account & Lists')]")).click();
            driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(.,'Log out')]")).click();
        } else {
            System.out.println("Login failed");
            driver.navigate().refresh();
        }
    }
    @Test(priority = -1)
    public void VidInVpwd() throws InterruptedException, IOException {
        driver.get("http://patriotlisting.sigmasolve.net:4203/auth/login");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Test@12346");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        String actualUrl = "http://patriotlisting.sigmasolve.net:4203/";
        String expectedUrl = driver.getCurrentUrl();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Login Succesfull");
        } else {
            System.out.println("Login failed");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\HP\\Pictures\\Fail-screenshot\\Invalid pwd.png"));
            driver.navigate().refresh();
        }

    }
    @Test(priority = 0)
    public void InVidVpwd() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi120@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        String actualUrl = "http://patriotlisting.sigmasolve.net:4203/";
        String expectedUrl = driver.getCurrentUrl();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Login Succesfull");
        } else {
            System.out.println("Login failed");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\HP\\Pictures\\Fail-screenshot\\Invalid id.png"));
            driver.navigate().refresh();
        }
    }
    @Test(priority = 1)
    public void PwdChar() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        String actualUrl = "http://patriotlisting.sigmasolve.net:4203/";
        String expectedUrl = driver.getCurrentUrl();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Login Succesfull");
        } else {
            System.out.println("Password must be at least 6 characters");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\HP\\Pictures\\Fail-screenshot\\Six char.png"));
            driver.navigate().refresh();
        }
    }
    @Test(priority = 2)
    public void idpwdrequired() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        String actualUrl = "http://patriotlisting.sigmasolve.net:4203/";
        String expectedUrl = driver.getCurrentUrl();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Login Succesfull");
        } else {
            System.out.println("Password must be at least 6 characters");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\HP\\Pictures\\Fail-screenshot\\idpwdnull .png"));
            driver.navigate().refresh();
        }
    }
}
