package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Automate_window_handle {
   ChromeDriver driver;
    public void lanuchBrowser()
    {
        System.out.println("TestCases  Started.....!!");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
    }

    public void handleButtonClick() throws InterruptedException, IOException {

        // Click on the "Try it" button at the top of the page. -failing
        driver.switchTo().frame(1);
        WebElement tryButton = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        tryButton.click();
        Thread.sleep(4000);

        // Get the window handles and switch to the new window.
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);

        // the new window is at index 1, and get its title
        String title = driver.switchTo().window(windowHandlesList.get(1)).getTitle();
        System.out.println("The title of new window is : "+ title);

        //Take screenshot

        TakesScreenshot ts = driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File location = new File("E:\\selenium_starter\\build\\ScreenShot\\W3_1.png");
        FileUtils.copyFile(src,location);

        // Close the new window.
        //driver.close();

        // Switch back to the original window by using the window handle.
        driver.switchTo().window(windowHandlesList.get(0));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases Ended.....!!");
        driver.close();
        driver.quit();

    }
}
