package com.xyzcorp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

<<<<<<< HEAD

public class HelloSeleniumTest {

    private static ChromeDriver chromeDriver;

    /**
     * This is the setup. The issue is that we did not use a DriverManager
     * DriverManager's will download will download and manage the appropriate driver
     * This is not it.
     */

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatou.diouf\\chrome-drivers\\98\\chromedriver_win32\\chromedriver.exe");
=======
public class HelloSeleniumTest {

    private ChromeDriver chromeDriver;

    /**
     * This is the setup. The issue is that we did not use a DriverManager
     * DriverManager's will download and manage the appropriate driver. 
     * This is not it.
     */
    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\danno\\chrome-drivers\\98\\chromedriver_win32\\chromedriver");
>>>>>>> 0ea6d900d70c053d46a235c67f8ef5036259283f
        chromeDriver = new ChromeDriver();
    }

    /**
     * This test will go to Google and perform a search for
<<<<<<< HEAD
     * "Behaviour Driven Development" and hit enter. Just to ensure
     * that Selenium works as expected.
     */


    @Test
    public void testPage() {

        chromeDriver.get("https://www.google.com/");
        chromeDriver.manage().window().setSize(new Dimension(1054, 808));
        chromeDriver.findElement(By.name("q")).sendKeys("behaviour driven development");
        chromeDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        chromeDriver.findElement(By.cssSelector(".g > div > div > .jtfYYd .LC20lb")).click();
        chromeDriver.findElement(By.cssSelector("p:nth-child(2)")).click();

    }


    @AfterAll
    public static void cleanup(){
        chromeDriver.close();
    }


    }
=======
     * "Behavior Driven Development" and hit enter. Just to ensure
     * that Selenium works as expected.
     */
    @Test
    public void testPage() {
        chromeDriver.get("https://www.google.com/");
        chromeDriver.manage().window().setSize(new Dimension(1758, 1070));
        chromeDriver.findElement(By.name("q")).click();
        chromeDriver.findElement(By.name("q")).sendKeys("Behavior Driven Development");
        chromeDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @AfterAll
    public void cleanup() {
        chromeDriver.close();
    }
}
>>>>>>> 0ea6d900d70c053d46a235c67f8ef5036259283f
