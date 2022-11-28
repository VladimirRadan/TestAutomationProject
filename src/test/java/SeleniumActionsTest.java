import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SeleniumActionsTest {


    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void iFrameTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        WebElement element = driver.findElement(By.id("sampleHeading"));
        System.out.println(element.getText());
    }

    @Test
    public void sliderTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://demoqa.com/slider");
        WebElement slider = driver.findElement(By.cssSelector(".range-slider"));
        for (int i = 0; i < 50; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Thread.sleep(2000);
    }

    @Test
    public void tabsTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://demoqa.com/browser-windows");
        String currentTab = driver.getWindowHandle();
        System.out.println(currentTab);
        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);
    }






}
