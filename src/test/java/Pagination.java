import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;

public class Pagination {
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
    public void closedriver() {
        driver.close();
    }

    @Test(priority = -2)
    public void VidVpwd() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
    }

    @Test(priority = -1)
    public void Product() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(.,'Products')])[4]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void Forward() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".page-item:nth-child(9) span")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".page-item:nth-child(9) span")).click();
    }

    @Test(priority = 1)
    public void Backward() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".page-item:nth-child(1) span")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".page-item:nth-child(1) span")).click();
        Thread.sleep(3000);

    }
}