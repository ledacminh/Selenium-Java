package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;

import java.util.concurrent.TimeUnit;

public class WebDriveWait_P3 {
    WebDriver drive;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    String   fileName = "upload.jar";
    String fileNamePath = "C:\\WorkSpace\\SeleniumJavaFramework\\UploadFile\\upload.jar";




    @BeforeClass
    public void BeforClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\WorkSpace\\SeleniumJavaFramework\\browser\\chromedriver.exe");
        drive = new ChromeDriver();
        explicitWait = new WebDriverWait(drive, 30);
        drive.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        drive.manage().window().maximize();
        // drive.get("https://www.google.com/");
    }

    //@Test
    public void TC_01_findElement() {
        drive.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='ctl00_ContentPlaceholder1_RadCalendar1_Top']")));
        Assert.assertEquals(drive.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText(),"No Selected Dates to display.");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@title='Thursday, September 16, 2021']")));
        drive.findElement(By.xpath("//td[@title='Thursday, September 16, 2021']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']")));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1' and @class='label']")));
        Assert.assertTrue(drive.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1' and @class='label']")).isDisplayed());
        Assert.assertEquals(drive.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1' and @class='label']")).getText(), "Thursday, September 16, 2021");

    }

    @Test(groups =  "check")
    public void TC_02_findElemnts() {
         BeforClass();
        //Tìm được 1 element
        //Không tìm thấy Element nào
        //Tìm thấy nhiều hơn 1 Element
        drive.get("https://filebin.net/");
        WebElement upload = drive.findElement(By.xpath("//input[@id='fileField']"));
        upload.sendKeys(fileNamePath);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='progress-bar progress-bar-striped progress-bar-animated']")));
    }


    @AfterClass
    public void AfterClass() {
        drive.quit();
    }
}
