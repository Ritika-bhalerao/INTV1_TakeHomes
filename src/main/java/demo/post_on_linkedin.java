package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class post_on_linkedin {
    WebDriver driver;
    public void lanuchBrowser()
    {
        System.out.println("TestCases  Started.....!!");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.linkedin.com/home");

    }

    public void Post_on_linkedin() throws InterruptedException {
        //Sign-in for LinkedIN
        driver.findElement(By.xpath("(//div[@class='text-input flex'])[1]/input")).sendKeys("bhaleraoritika30@gmail.com");
        driver.findElement(By.xpath("(//div[@class='text-input flex'])[2]/input")).sendKeys("butterfly12@");
        driver.findElement(By.xpath("//button[contains(@class,'w-[400px] mx-auto')]")).click();

        //Navigate to view profile Page

        driver.findElement(By.xpath("(//div[contains(@class,'t-bold')])[1]")).click();
        Thread.sleep(3000);

        // Print the count of `Who's viewed your profile

        WebElement views = driver.findElement(By.xpath("(//div[contains(@class,'display-flex ')]/div/div/span)[7]"));
        System.out.println("Count of `Who's viewed your profile is : "+ views.getText());

        // Create a post

        WebElement clickon_cp =  driver.findElement(By.xpath("(//div[contains(@class,'button-spacing')]/div/div/a)[1]"));
        clickon_cp.click();
       Thread.sleep(3000);


        driver.findElement(By.xpath("(//div[contains(@class,'subtitle ember-view')])[1]")).click();

        WebElement radiobutton =driver.findElement(By.xpath("//*[@id=\"CONNECTIONS_ONLY\"]/span[2]/span/span/strong"));
        //Thread.sleep(3000);
        radiobutton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'primary ember-view')]/span)[1]")).click();


        WebElement enter_text = driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']"));
        enter_text.sendKeys("That's one small step for a man, a giant leap for mankind.");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Post']/..")).click();

        Thread.sleep(3000);
//        Thread.sleep(3000);
        System.out.println("posted sucessfully" );
    }

    public void endTest()
    {
        System.out.println("TestCases  Ended.....!!");
        driver.close();
        driver.quit();

    }


}
