package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate_image_urls {

    WebDriver driver;

    public void lanuchBrowser() {
        System.out.println("TestCases  Started.....!!");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.bookmyshow.com/explore/home/chennai");

    }

    public void img_url() {

        List<WebElement> list = driver.findElements(By.xpath("//h2[contains(text(),'Recommended Movies')]/../../../..//img"));
        System.out.println("Size of List : + " +list.size());

        for (WebElement ele : list) {
            System.out.println("links" + ele.getAttribute("src"));
            System.out.println();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement ele = driver.findElement(By.xpath("//h2[contains(text(),'Premieres')]"));

        wait.until(ExpectedConditions.visibilityOfAllElements(ele));

        List<WebElement> abc = driver.findElements(By.xpath(
                " //h2[contains(text(),'Premieres')]//ancestor::div[contains(@class,'dOuCBq')]//div[contains(@class,'cZuToi')]"));
        System.out.println(abc.size());
        WebElement movieEle = abc.get(2);

        WebElement moviename = movieEle.findElement(By.xpath("/div/div[1]"));
        WebElement movienLanguage = movieEle.findElement(By.xpath("/div/div[2]"));

        System.out.println(moviename.getText());

        System.out.println(movienLanguage.getText());


    }

    public void endTest()
    {
        System.out.println("End Test: TestCases Ended.....!!");
        driver.close();
        driver.quit();

    }
}
