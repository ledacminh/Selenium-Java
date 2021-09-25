package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
    WebDriver  drive;

    @BeforeClass
    public void BeforClass(){
        System.setProperty("webdriver.chrome.driver","C:\\WorkSpace\\Trainning\\browser\\chromedriver.exe");
        drive = new ChromeDriver();
        drive.manage().window().maximize();
    }

    @Test
    public void Test(){
        drive.get("https://www.google.com/");
    }


    @AfterClass
    public void AfterClass(){
        drive.quit();
    }
}
