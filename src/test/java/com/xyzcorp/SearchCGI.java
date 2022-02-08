package com.xyzcorp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;


public class SearchCGI{

    
private static ChromeDriver chromeDriver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatou.diouf\\chrome-drivers\\98\\chromedriver_win32\\chromedriver.exe");

                chromeDriver = new ChromeDriver();
       }


       @AfterAll
       public static void cleanup(){
           chromeDriver.close();
       }

       @Test
       public void searchingInCGI() {
         chromeDriver.get("https://www.cgi.com/en");
         chromeDriver.manage().window().setSize(new Dimension(1936, 1056));
         chromeDriver.findElement(By.linkText("EN")).click();
         chromeDriver.findElement(By.linkText("FR")).click();
         chromeDriver.findElement(By.linkText("Gouvernements")).click();
         chromeDriver.findElement(By.cssSelector(".search-icon-btn")).click();
         chromeDriver.findElement(By.cssSelector(".fa-close")).click();
         chromeDriver.findElement(By.linkText("Contactez-nous")).click();
         chromeDriver.findElement(By.name("name")).sendKeys("Fatou");
         chromeDriver.findElement(By.name("company")).sendKeys("CGI");
         chromeDriver.findElement(By.name("email")).sendKeys("abcd");
         chromeDriver.findElement(By.name("phone")).sendKeys("7");
         chromeDriver.findElement(By.name("relationship_to_cgi[select]")).click();


       }








}