import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Patriot {
    public static ChromeDriver driver;

    @BeforeTest
    public void Open() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
        @Test(priority = 0)
        public void Login() throws InterruptedException {
        driver.get("http://patriotlisting.sigmasolve.net:4203/");
        WebElement Signin = driver.findElement(By.xpath("//a[@class='underline'][contains(.,'Sign in')]"));
        Signin.click();
        Thread.sleep(2000);
        WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
        Email.sendKeys("abhi12@yopmail.com");
        WebElement Password = driver.findElement(By.xpath("//input[@name='pw']"));
        Password.sendKeys("Test@1234");
        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.click();
        Thread.sleep(5000);
    }
        @Test(priority = 1)
        public void Home() throws InterruptedException {
            WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
            search.sendKeys("Shirt");
            WebElement searchsymbol = driver.findElement(By.xpath("//i[contains(@class,'fa fa-search')]"));
            searchsymbol.click();
            Thread.sleep(4000);
            WebElement product = driver.findElement(By.xpath("(//a[contains(@title,'Shirt')])[1]"));
            product.click();
            Thread.sleep(5000);
            WebElement dropdown = driver.findElement(By.xpath("//select[@ng-reflect-model='0']"));
            dropdown.click();
            Select drop = new Select(dropdown);
            drop.selectByIndex(2);
            WebElement color = driver.findElement(By.xpath("(//a[@ng-reflect-ng-class='[object Object]'])[9]"));
            color.click();
            WebElement addtocart = driver.findElement(By.xpath("//button[contains(.,'add to cart')]"));
            addtocart.click();
            Thread.sleep(4000);
            WebElement cart = driver.findElement(By.xpath("//span[@class='item-number']"));
            cart.click();
            Thread.sleep(8000);
            WebElement qty = driver.findElement(By.xpath("//input[@type='number']"));
            qty.clear();
            qty.sendKeys("5");
            WebElement notes = driver.findElement(By.xpath("//textarea[contains(@name,'userNote')]"));
            notes.sendKeys("For Gift");
            WebElement firstname = driver.findElement(By.xpath("//input[contains(@name,'firstName')]"));
            firstname.sendKeys("Rick");
            WebElement lastname = driver.findElement(By.xpath("//input[contains(@name,'lastName')]"));
            lastname.sendKeys("Rock");
            WebElement phone = driver.findElement(By.xpath("//input[contains(@name,'phoneNumber')]"));
            phone.sendKeys("1234567890");
            WebElement address = driver.findElement(By.xpath("(//input[contains(@name,'streetAddress')])[1]"));
            address.sendKeys("3857 Davis Court");
            WebElement landmark = driver.findElement(By.xpath("//input[contains(@name,'shippingAddress')]"));
            landmark.sendKeys("Mandir");
            WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
            city.sendKeys("Marion");
            WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
            state.sendKeys("Illinois");
            WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
            country.click();
            Select cntry = new Select(country);
            cntry.selectByVisibleText("United States");
            WebElement zipcode = driver.findElement(By.xpath("//input[@name='zipCode']"));
            zipcode.sendKeys("12345");
            WebElement shipaddress = driver.findElement(By.xpath("//label[contains(.,'Same As Shipping Address')]"));
            shipaddress.click();
            WebElement payment = driver.findElement(By.xpath("//input[contains(@id,'paypal')]"));
            payment.click();
            WebElement payment1 = driver.findElement(By.xpath("//input[contains(@id,'cod')]"));
            payment1.click();
            WebElement checkout = driver.findElement(By.xpath("//button[contains(.,'Check Out')]"));
            checkout.click();
            Thread.sleep(2000);
            WebElement code = driver.findElement(By.xpath("//input[contains(@name,'verifyCode')]"));
            code.sendKeys("ABCDE");
            WebElement confirm = driver.findElement(By.xpath("//button[contains(.,'Confirm')]"));
            confirm.click();
            Thread.sleep(8000);
            WebElement Account = driver.findElement(By.xpath("//span[contains(.,'Account & Lists')]"));
            Account.click();
            WebElement Logout = driver.findElement(By.xpath("//a[@class='dropdown-item'][contains(.,'Log out')]"));
            Logout.click();
            Thread.sleep(5000);
        }
        @AfterTest
        public void closedriver(){
            driver.close();
        }

    }
