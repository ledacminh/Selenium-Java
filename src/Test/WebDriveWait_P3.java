package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
=======
>>>>>>> origin/master
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> origin/master

import java.util.concurrent.TimeUnit;

public class WebDriveWait_P3 {
    WebDriver drive;
    WebDriverWait explicitWait;
<<<<<<< HEAD
    String projectPath = System.getProperty("user.dir");
    String   fileName = "upload.jar";
    String fileNamePath = "C:\\WorkSpace\\SeleniumJavaFramework\\UploadFile\\upload.jar";



=======
>>>>>>> origin/master

    @BeforeClass
    public void BeforClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\WorkSpace\\SeleniumJavaFramework\\browser\\chromedriver.exe");
        drive = new ChromeDriver();
        explicitWait = new WebDriverWait(drive, 30);
        drive.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        drive.manage().window().maximize();
        // drive.get("https://www.google.com/");
    }

<<<<<<< HEAD
    //@Test
=======
    @Test
>>>>>>> origin/master
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

<<<<<<< HEAD
    @Test(groups =  "check")
    public void TC_02_findElemnts() {
         BeforClass();
        //T??m ???????c 1 element
        //Kh??ng t??m th???y Element n??o
        //T??m th???y nhi???u h??n 1 Element
        drive.get("https://filebin.net/");
        WebElement upload = drive.findElement(By.xpath("//input[@id='fileField']"));
        upload.sendKeys(fileNamePath);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='progress-bar progress-bar-striped progress-bar-animated']")));
=======
    //@Test
    public void TC_02_findElemnts() {
        //T??m ???????c 1 element
        //Kh??ng t??m th???y Element n??o
        //T??m th???y nhi???u h??n 1 Element
        drive.get("https://www.facebook.com/");
        drive.findElement(By.xpath("//a[text()='Qu??n m???t kh???u?']")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[text()='T???o t??i kho???n m???i']")));
>>>>>>> origin/master
    }


    @AfterClass
    public void AfterClass() {
        drive.quit();
    }
}
