package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriveWait_P2 {
    WebDriver drive;
    WebDriverWait explicitWait;

    @BeforeClass
    public void BeforClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\WorkSpace\\SeleniumJavaFramework\\browser\\chromedriver.exe");
        drive = new ChromeDriver();
        explicitWait = new WebDriverWait(drive, 30);
        drive.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        drive.manage().window().maximize();
        // drive.get("https://www.google.com/");
    }

    @Test
    public void TC_01_findElement() {
        //Tìm được 1 element
        //Không tìm thấy Element nào
        //Tìm thấy nhiều hơn 1 Element
        drive.get("http://juliemr.github.io/protractor-demo/");
        drive.findElement(By.xpath("//input[@ng-model='first']")).sendKeys("5");
        drive.findElement(By.xpath("//input[@ng-model='second']")).sendKeys("6");
        drive.findElement(By.xpath("//button[@ng-click='doAddition()']")).click();
        Assert.assertTrue(drive.findElement(By.xpath("//h2[@class='ng-binding' and text()='11']")).isDisplayed());
        Assert.assertEquals(drive.findElement(By.xpath("//h2[@class='ng-binding']")).getText(),"11");

    }

    //@Test
    public void TC_02_findElemnts() {
        //Tìm được 1 element
        //Không tìm thấy Element nào
        //Tìm thấy nhiều hơn 1 Element
        drive.get("https://www.facebook.com/");
        drive.findElement(By.xpath("//a[text()='Quên mật khẩu?']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()='Tạo tài khoản mới']")));
    }


    @AfterClass
    public void AfterClass() {
        drive.quit();
    }
}
