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

public class Filter_By {
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
        WebElement dropdown0 = driver.findElement(By.cssSelector(".input-select"));
        dropdown0.click();
        Select drop = new Select(dropdown0);
        drop.selectByVisibleText("Price : Highest to Lowest");
        Thread.sleep(5000);
        WebElement dropdown1 = driver.findElement(By.cssSelector(".input-select"));
        dropdown1.click();
        Select drop1 = new Select(dropdown1);
        drop1.selectByVisibleText("Latest : Oldest to Newest");
        Thread.sleep(5000);
        WebElement dropdown2 = driver.findElement(By.cssSelector(".input-select"));
        dropdown2.click();
        Select drop2 = new Select(dropdown2);
        drop2.selectByVisibleText("Latest : Newest to Oldest");
        Thread.sleep(5000);
        WebElement dropdown3 = driver.findElement(By.cssSelector(".input-select"));
        dropdown3.click();
        Select drop3 = new Select(dropdown3);
        drop3.selectByVisibleText("Price : Lowest to Highest");
        Thread.sleep(5000);
    }

        @Test(priority = 0)
        public void Grid() throws InterruptedException {
            driver.findElement(By.cssSelector(".list > a")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".grid > a")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Clothes & Dresses")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Home & Kitchen")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Computers & Games")).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(2000);
            driver.findElement(By.linkText("Health Care Products")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Auto Accessories")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Patriot")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Car & Motorcycle")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Arts & Crafts")).click();
            Thread.sleep(5000);

    }
}

