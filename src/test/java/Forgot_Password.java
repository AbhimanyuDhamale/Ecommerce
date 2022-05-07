import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Forgot_Password {
    public static ChromeDriver driver;
    private Map<String, Object> vars;

    @BeforeTest
    public void Open() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://patriotlisting.sigmasolve.net:4203/auth/login");
        Thread.sleep(2000);
        vars = new HashMap<String, Object>();
    }

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    @AfterTest
    public void closedriver() {
        driver.quit();
    }

    @Test(priority = -2)
    public void Forgotpwd() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Test@123454");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        if (driver.findElement(By.xpath("//span[contains(.,'Your account is not activated or register. Please recheck again or contact to our admin to resolve it.')]")).getText().matches("Username or password incorrect. Try again.")) {
            System.out.println("Invalid Message");
        } else
            driver.findElement(By.xpath("//a[contains(.,'Forgot Password?')]")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//button[contains(.,'Confirm')]")).click();
        {
            System.out.println("Forgot Password");
        }
    }

    @Test(priority = -1)
    public void PwrdReset() throws InterruptedException {
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://yopmail.com/en/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@id,'login')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36'][contains(.,'\uE5C8')]")).click();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//span[@class='lmf'][contains(.,'smehta@sigmasolve.net')]")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("here")).click();
        vars.put("win9956", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9956").toString());
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//button[contains(.,'Change')]")).click();
        {
            System.out.println("Your password has been updated");
        }

    }

    @Test(priority = 0)
    public void Pwrdsucess() throws InterruptedException {
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        driver.manage().deleteAllCookies();
        driver.get("http://patriotlisting.sigmasolve.net:4203/auth/login");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhi12@yopmail.com");
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(8000);
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
}


