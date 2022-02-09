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
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.cgi.com/fr");

        chromeDriver.findElement(By.xpath("//*[@id='popup-buttons']/button[1]")).click();
    }

    @AfterEach
    void teardown() {
        chromeDriver.quit();
    }

  /*  @Test
    public void AcceptCookies() {
        chromeDriver.get("https://www.cgi.com/fr");

        chromeDriver.findElement(By.xpath("//*[@id='popup-buttons']/button[1]")).click();
    }*/


    @Test
    public void ChangeLanguage() {

        chromeDriver.findElement(By.cssSelector("#block-languageswitcher > ul > li.fr.is-active > a")).click();
        chromeDriver.findElement(By.cssSelector("#block-languageswitcher > ul > li.en > a")).click();
    }

    @Test
    public void ChangePageClickSearchButtonAndFillInContactUsForm() throws InterruptedException {
        chromeDriver.findElement(By.cssSelector("#cgi-offers-section > div > div.paragraph.paragraph--type--cgi-offer.paragraph--view-mode--default.offer-icon-bulb > div.keywords > div > div:nth-child(2) > a")).click();
        //chromeDriver.findElement(By.linkText("Gouvernements")).click();
        chromeDriver.findElement(By.cssSelector(".search-icon-btn")).click();
        chromeDriver.findElement(By.cssSelector(".fa-close")).click();


        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

        WebElement contactezNous = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.linkText("Contactez-nous")));

        contactezNous.click();

        WebDriverWait waitContacts = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement contactlist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ui-id-2")));



        chromeDriver.findElement(By.name("name")).sendKeys("Fatou");
        chromeDriver.findElement(By.name("company")).sendKeys("CGI");
        //chromeDriver.findElement(By.name("email")).sendKeys("abcd");
        chromeDriver.findElement(By.name("phone")).sendKeys("7");
        chromeDriver.findElement(By.name("relationship_to_cgi[select]")).click();
        {
            WebElement dropdown = chromeDriver.findElement(By.name("relationship_to_cgi[select]"));
            dropdown.findElement(By.xpath("//option[. = 'Nouveau fournisseur']")).click();
        }
        chromeDriver.findElement(By.name("message")).click();
        chromeDriver.findElement(By.name("message")).sendKeys("jfiovjrg");
        chromeDriver.findElement(By.cssSelector(".ui-button:nth-child(1)")).click();

        /*WebDriverWait waitErrorMessage = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement ErrorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#webform-submission-how-can-we-help-add-form--WXFlF07z_kc > div.messages.drupal-messages.messages--error > div > ul > li:nth-child(1)")));*/



    }

}

