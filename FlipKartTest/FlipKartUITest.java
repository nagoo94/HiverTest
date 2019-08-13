package FlipKartTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FlipKartUITest {
    WebDriver driver;

    @BeforeMethod
    public void BrowserSetUp() {

        System.setProperty("webdriver.chrome.driver", "E:\\Personal\\Chromewebdriver\\2.46\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @Test

    public void FlipKartUi() {
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > button")).click();
        driver.findElement(By.cssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > div > input")).clear();
        driver.findElement(By.cssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > div > input")).sendKeys("Pixel 3a");
        driver.findElement(By.cssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > button")).click();

        String parentWinHandle = driver.getWindowHandle();
        System.out.println("Parent window handle: " + parentWinHandle);

        driver.findElement(By.cssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(2) > div:nth-child(2) > div > div > div > a > div._1-2Iqu.row > div.col.col-7-12 > div._3wU53n")).click();

        Set<String> winHandles = driver.getWindowHandles();

        for (String handle : winHandles) {
            if (!handle.equals(parentWinHandle)) {
                driver.switchTo().window(handle);
            }
        }

        driver.findElement(By.cssSelector("#container > div > div.t-0M7P._3GgMx1._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div._1HmYoV._35HD7C.col-5-12._3KsTU0 > div:nth-child(2) > div > ul > li:nth-child(1) > button")).click();
        driver.findElement(By.cssSelector("#container > div > div.t-0M7P._27IFdQ > div._3e7xtJ > div > div:nth-child(1) > div > div:nth-child(2) > div > div._3cto0P._2Mq1yq > div._3RkJty > div > button:nth-child(3)")).click();
        String a = driver.findElement(By.cssSelector("#container > div > div.t-0M7P._27IFdQ > div._3e7xtJ > div > div._1HmYoV._35HD7C.col-4-12._3KsTU0 > div.bhgxx2.col-12-12 > div > div > div._2twTWD > div._3xFQAD > div > span")).getText();

        System.out.println(a);
    }

    @AfterMethod
    public void ClosingWindow()
    {
        driver.quit();
    }


}
