package com.xyzcorp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloSeleniumTest {

    private static ChromeDriver chromeDriver;
    
    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatou.diouf\\chrome-drivers\\98\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }


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
