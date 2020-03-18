package com.example.demo.Tests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class WebDriverTests {

    private WebDriver webDriver;

    @Value("${local.server.port}")
    private int port;


    @Test
    public void createEventPageContainsNewEvent() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c1981660\\Desktop\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        this.webDriver = new ChromeDriver(options);


        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/CreateEventPage");
        assertTrue(webDriver.findElement(By.id("test2")).getText().contains("New Event"));
        this.webDriver.quit();
    }


    @Test
    public void loginPageContainsRegister() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c1981660\\Desktop\\ChromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        this.webDriver = new ChromeDriver(options);

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/");
        assertTrue(webDriver.findElement(By.id("test3")).getText().contains("Register"));
        this.webDriver.quit();
    }
/*

@Test
    public void specificEventPageContains() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c1981660\\Desktop\\ChromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        this.webDriver = new ChromeDriver(options);

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/viewSpecificEvent");
        assertTrue(webDriver.findElement(By.id("test5")).getText().contains("dietary requirements"));
        this.webDriver.quit();
    }
    */

    /*
    @Test
    public void registerPageContainsRegisterForm() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c1981660\\Desktop\\ChromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        this.webDriver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("registerForm")));

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/register");
        assertTrue(webDriver.findElement(By.id("registerForm")).getText().contains("Register"));
        this.webDriver.quit();
    } */

}

