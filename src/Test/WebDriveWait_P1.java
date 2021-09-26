package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriveWait_P1 {
    WebDriver  drive;
    WebDriverWait explicitWait;

    @BeforeClass
    public void BeforClass(){
        System.setProperty("webdriver.chrome.driver","C:\\WorkSpace\\SeleniumJavaFramework\\browser\\chromedriver.exe");
        drive = new ChromeDriver();
        explicitWait = new WebDriverWait(drive, 30);
        drive.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        drive.manage().window().maximize();
       // drive.get("https://www.google.com/");
    }

    //@Test
    public void TC_01_Visiable() {
        drive.get("https://www.facebook.com/");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Tạo tài khoản mới']")));

    }
    //@Test
    public void TC_02_InVisiable() {
        drive.get("https://www.facebook.com/");
        drive.findElement(By.xpath("//a[text()='Quên mật khẩu?']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()='Tạo tài khoản mới']")));
    }

    @Test
    public void TC_03_Presence() {
        drive.get("https://www.facebook.com/");
        drive.findElement(By.xpath("//a[text()='Quên mật khẩu?']")).click();
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='did_submit']")));
    }

   // @Test
    public void TC_04_Staleness() {
    }


    @AfterClass
    public void AfterClass(){
        drive.quit();
    }
}
