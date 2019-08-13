package AmazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AmazonUITest {

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

    public void AmazonUI()
    {

        driver.get("https://www.amazon.in/");

        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 7 32 gb(black)");
        driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input")).click();

        String parentWinHandle = driver.getWindowHandle();
        System.out.println("Parent window handle: " + parentWinHandle);

        driver.findElement(By.cssSelector("#search > div.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.s-right-column.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(4) > div.s-result-list.s-search-results.sg-row > div:nth-child(1) > div > div > div > div:nth-child(2) > div.sg-col-4-of-12.sg-col-8-of-16.sg-col-16-of-24.sg-col-12-of-20.sg-col-24-of-32.sg-col.sg-col-28-of-36.sg-col-20-of-28 > div > div:nth-child(1) > div > div > div:nth-child(1) > h2 > a > span")).click();

        Set<String> winHandles = driver.getWindowHandles();

        for (String handle : winHandles) {
            if (!handle.equals(parentWinHandle)) {
                driver.switchTo().window(handle);
            }
        }

        String i =  driver.findElement(By.cssSelector("#search > div.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.s-right-column.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(4) > div.s-result-list.s-search-results.sg-row > div:nth-child(1) > div > div > div > div:nth-child(2) > div.sg-col-4-of-12.sg-col-8-of-16.sg-col-16-of-24.sg-col-12-of-20.sg-col-24-of-32.sg-col.sg-col-28-of-36.sg-col-20-of-28 > div > div:nth-child(2) > div:nth-child(1) > div > div.a-section.a-spacing-none.a-spacing-top-small > div > div > a > span:nth-child(1) > span:nth-child(2) > span.a-price-whole")).getText();

        driver.get("https://www.flipkart.com/");

        driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > button")).click();
        driver.findElement(By.cssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > div > input")).clear();
        driver.findElement(By.cssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > div > input")).sendKeys("iPhone 7 32 gb(black)");
        driver.findElement(By.cssSelector("#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > button")).click();

        String parentWinHandle1 = driver.getWindowHandle();
        System.out.println("Parent window handle: " + parentWinHandle);

        driver.findElement(By.cssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(2) > div:nth-child(2) > div > div > div > a > div._1-2Iqu.row > div.col.col-7-12 > div._3wU53n")).click();

        Set<String> winHandles1 = driver.getWindowHandles();

        for (String handle : winHandles1) {
            if (!handle.equals(parentWinHandle)) {
                driver.switchTo().window(handle);
            }
        }


        String k = driver.findElement(By.cssSelector("#container > div > div.t-0M7P._3GgMx1._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div._1HmYoV._35HD7C.col-8-12 > div:nth-child(2) > div > div._3iZgFn > div._2i1QSc > div > div._1vC4OE._3qQ9m1")).getText();

        int m = Integer.parseInt(k);
        int n = Integer.parseInt(i);

        if (m>n)
        {
            System.out.println("Price of Iphone is greater in Amazon");
        }

        else
        {
            System.out.println("Price of Iphone is greater in Amazon");

        }

    }

    @AfterMethod
    public void ClosingWindow()
    {
        driver.quit();
    }


}
