package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookMyShow_Hyperlinks {
     WebDriver driver;
    public void lanuchBrowser()
    {
        System.out.println("TestCases  Started.....!!");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
    }

    public void getLinks_count(){

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int count =0;

        for(WebElement link : links) {
            String url = link.getAttribute("href");
            // System.out.println(url);
            count++;
        }

        System.out.println("Total no of url are :" +count);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases Ended.....!!");
        driver.close();
        driver.quit();

    }
}
