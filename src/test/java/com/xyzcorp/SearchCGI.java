package com.xyzcorp;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchCGI {

    WebDriver chromeDriver;

    @BeforeEach
    void setup() {
        chromeDriver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void teardown() {
        chromeDriver.quit();
    }

    @Test
    public void searchingInCGI() {
        chromeDriver.get("https://www.cgi.com/fr");
        //chromeDriver.manage().window().setSize(new Dimension(1936, 1056));

        chromeDriver.findElement(By.xpath("//*[@id='popup-buttons']/button[1]")).click();

        chromeDriver.manage().window().maximize();


        //chromeDriver.manage().window().setPosition(new Point(0, 0));

        //chromeDriver.findElement(By.cssSelector("#block-languageswitcher > ul > li.en.is-active > a")).click();
        //chromeDriver.findElement(By.cssSelector("#block-languageswitcher > ul > li.fr > a")).click();
        /*chromeDriver.findElement(By.linkText("Gouvernements")).click();
        chromeDriver.findElement(By.cssSelector(".search-icon-btn")).click();
        chromeDriver.findElement(By.cssSelector(".fa-close")).click();*/

        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

        WebElement contactezNous = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.linkText("Contactez-nous")));

                contactezNous.click();

        //chromeDriver.findElement(By.linkText("Contactez-nous")).click();
        chromeDriver.findElement(By.name("name")).sendKeys("Fatou");
        chromeDriver.findElement(By.name("company")).sendKeys("CGI");
        chromeDriver.findElement(By.name("email")).sendKeys("abcd");
        chromeDriver.findElement(By.name("phone")).sendKeys("7");
        chromeDriver.findElement(By.name("relationship_to_cgi[select]")).click();
        {
            WebElement dropdown = chromeDriver.findElement(By.name("relationship_to_cgi[select]"));
            dropdown.findElement(By.xpath("//option[. = 'Nouveau fournisseur']")).click();
        }
        chromeDriver.findElement(By.name("message")).click();
        chromeDriver.findElement(By.name("message")).sendKeys("jfiovjrg");
        chromeDriver.findElement(By.cssSelector(".ui-button:nth-child(1)")).click();
    }

}
