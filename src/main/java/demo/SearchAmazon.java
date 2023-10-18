package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchAmazon {
    WebDriver driver;
    public void lanuchBrowser()
    {
        System.out.println("TestCases  Started.....!!");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

    }

    public void searchAmazon(){

        driver.findElement(By.xpath("//textarea[@name='q']"));
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("amazon");

        driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[1]")).click();
        WebElement Website_name = driver.findElement(By.xpath("//h3[text()='Amazon.in']"));
        String name = Website_name.getText();
        if(name.equalsIgnoreCase("amazon.in")){
            System.out.println("TestCases passed successfully :"+ name);
        }

    }

    public void endTest()
    {
        System.out.println("TestCases  Ended.....!!");
        driver.close();
        driver.quit();

    }
}
