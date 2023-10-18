package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Automate_nested_frames_text {

    WebDriver driver;
    public void lanuchBrowser()
    {
        System.out.println("TestCases Started.....!!");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    public void getFrameName(){

        driver.switchTo().frame(0);
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT' ) ]"));
        //left.getText();
        System.out.println("Text of Left Frame : "+left.getText());

        // Switch to middle frame

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println("Text of Middle Frame: " + middle.getText());

        //Switch to Right frame

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement Right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println("Text of Right Frame: " + Right.getText());

        //Switch to bottom frame

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        // bottom.getText();
        System.out.println("This is botton text : "+bottom.getText() );

    }

    public void endTest()
    {
        System.out.println("TestCases  Ended.....!!");
        driver.close();
        driver.quit();
    }

}
