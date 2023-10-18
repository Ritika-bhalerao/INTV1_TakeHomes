package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate_imdb_ratings {

    WebDriver driver;
    public void lanuchBrowser()
    {
        System.out.println("TestCases Started.....!!");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.imdb.com/chart/top");
    }

    public void getRating() throws InterruptedException {

        WebElement sort= driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
        sort.click();
        Select s = new Select(sort);
        s.selectByIndex(1+1);

        //What is the highest rated movie on IMDb?

        WebElement rate = driver.findElement(By.xpath("//div[contains(@class,'ratings-container')]/span[1]"));
        System.out.println("The higest rate movie is : "+ rate.getText());

        //How many movies are included in the table?
        Thread.sleep(3000);
        List<WebElement> NoOfMovie = driver.findElements(By.xpath("//div[contains(@class,'irGIRq cli-title')]/a/h3"));
        System.out.println("There are total  : "+ NoOfMovie.size() + " movives included in list");

        //What is the oldest movie on the list?

        WebElement sortByReleasedate = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
        sortByReleasedate.click();
        Select s1 = new Select(sortByReleasedate);
        s1.selectByValue("RELEASE_DATE");

        WebElement oldest_movie = driver.findElement(By.xpath("(//div[contains(@class,'irGIRq cli-title')]/a/h3)[250]"));
        System.out.println("The oldest movie in the List is : "+oldest_movie.getText());

        //What is the most recent movie on the list?

        WebElement Latest_movie = driver.findElement(By.xpath("(//div[contains(@class,'irGIRq cli-title')]/a/h3)[1]"));
        System.out.println("The Latest movie in the List is : "+Latest_movie.getText());

        // Which movie has the most user ratings?

        s.selectByValue("USER_RATING");
        WebElement Higest_user_Rate = driver.findElement(By.xpath("(//span[contains(@class,'--voteCount')])[1]"));
        WebElement Higest_user_Rate_movie  = driver.findElement(By.xpath("(//div[contains(@class,'irGIRq cli-title')]/a/h3)[1]"));
        System.out.println("The higest user rated movie is  : "+ Higest_user_Rate_movie.getText() + "  And the views are : "+ Higest_user_Rate.getText());
    }

    public void endTest()
    {
        System.out.println("TestCases  Ended.....!!");
        driver.close();
        driver.quit();
    }
}
