import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class Template {
    public static WebDriver driver;
    public static WebDriverWait wait;


    @Test
    public void getPage() throws InterruptedException {
        driver.findElement(By.id("search")).sendKeys("text");
        Thread.sleep(5000);
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.xpath("/html/body/form/button")).click();
    }

    @Test
     public void getName() {
        driver.findElement(By.id("name")).sendKeys("Daiva");
        driver.findElement(By.xpath("/html/body/form/button")).click();
        WebElement result = driver.findElement(By.id("name-result"));
        if (result.getText().equals("Daiva")) {
            System.out.println("name pass");
        } else {
            System.out.println("name fail");
        }
    }

    @Test
     public void getPassword() {
        driver.findElement(By.id("password")).sendKeys("paswoooord");
        driver.findElement(By.xpath("/html/body/form/button")).click();
        WebElement result = driver.findElement(By.id("password-result"));
        if (result.getText().equals("paswoooord")) {
            System.out.println("password pass");
        } else {
            System.out.println("password fail");
        }
    }

    @Test
    public void getAge() throws InterruptedException {
        driver.findElement(By.id("age")).sendKeys("vienas");
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("age-result")).getText(), "");
        Thread.sleep(2000);
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys("18");
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("age-result")).getText(), "18");
    }

    @Test
    public void getEmail() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("aaa");
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("email-result")).getText(), "");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("d@d.lt");
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("email-result")).getText(), "d@d.lt");
    }

    @Test
    public void getCheckBox() {
        driver.findElement(By.id("sleepInBed")).click();
        driver.findElement(By.id("HaveMeal")).click();
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("sleepInBed-result")).getText(), "Yes");
        Assert.assertEquals(driver.findElement(By.id("HaveMeal-result")).getText(), "Yes");
    }

    @Test
    public void getParkingRadio() throws InterruptedException {
        driver.findElement(By.id("start")).click();
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("parking-result-start")).getText(), "Yes");
        Thread.sleep(5000);
        driver.findElement(By.id("mid")).click();
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("parking-result-start")).isSelected(), false);
        Assert.assertEquals(driver.findElement(By.id("parking-result-mid")).isSelected(), true);
        Assert.assertEquals(driver.findElement(By.id("parking-result-end")).isSelected(), false);
        Thread.sleep(5000);
        driver.findElement(By.id("start")).click();
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("parking-result-start")).isSelected(), true);
        Assert.assertEquals(driver.findElement(By.id("parking-result-mid")).isSelected(), false);
        Assert.assertEquals(driver.findElement(By.id("parking-result-end")).isSelected(), false);
        Thread.sleep(5000);
        driver.findElement(By.id("end")).click();
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("parking-result-start")).isSelected(), false);
        Assert.assertEquals(driver.findElement(By.id("parking-result-mid")).isSelected(), false);
        Assert.assertEquals(driver.findElement(By.id("parking-result-end")).isSelected(), true);

        driver.findElement(By.xpath("/html/body/form/button")).click();
    }

    @Test
    public void getSeats() {
        driver.findElement(By.xpath("/html/body/form/select/option[2]")).click();
        driver.findElement(By.xpath("/html/body/form/button")).click();
        Assert.assertEquals(driver.findElement(By.id("seats-result")).getText(), "2");
    }

    @Test
    public void getTime() {
        driver.findElement(By.id("time")).sendKeys("07:40PM");
        driver.findElement(By.xpath("/html/body/form/button")).click();
    }

    @Test
    public void getDate() {
        driver.findElement(By.id("date")).sendKeys("06/30/2023");
        driver.findElement(By.xpath("/html/body/form/button")).click();
    }

//    @Test
//    public void getDatetime() {
//        driver.findElement(By.id("datetime-local")).sendKeys("06/30/2023T07:40PM");
//        driver.findElement(By.xpath("/html/body/form/button")).click();
//    }

//    @Test
//    public void getMonth() {
//        //  driver.findElement(By.id("month")).sendKeys("June2023");
//        driver.findElement(By.xpath("/html/body/form/button")).click();
//    }

    @Test
    public void getWeek(){
        driver.findElement(By.id("week")).sendKeys("W26,2023");
        driver.findElement(By.xpath("/html/body/form/button")).click();
    }

    @Ignore
    @Test
    public void reset(){
        driver.findElement(By.id("reset")).click();
    }


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");
        driver.manage().window().maximize();
    }


    @AfterClass
    public void afterClass() {
        //    driver.quit();

    }
    //   String result = driver.findElement(By.id("search")).getAttribute("tekstas");

}
