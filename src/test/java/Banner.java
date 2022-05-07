import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Banner {
    public static ChromeDriver driver;

    @BeforeTest
    public void Open() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://patriotlisting.sigmasolve.net:4203/auth/login");
        Thread.sleep(2000);
    }
    /*@AfterTest
    public void closedriver() {
        driver.close();
    }*/

    @Test(priority = -2)
    public void VidVpwd() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(10000);
    }

    /*@Test(priority = -1)
    public void Forward() throws InterruptedException {
        driver.findElement(By.xpath("(//button[contains(.,'Next')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[contains(.,'Next')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[contains(.,'Next')])[1]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void Backward() throws InterruptedException {
        driver.findElement(By.xpath("(//button[contains(.,'Previous')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[contains(.,'Previous')])[1]")).click();
        Thread.sleep(5000);
    }*/

    @Test(priority = 1)
    public void SeeMore() throws InterruptedException {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        String URL = "http://patriotlisting.sigmasolve.net:4203/products/search";
        driver.findElement(By.xpath("(//a[contains(.,'See more')])[1]")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.get(URL);


    }
}
