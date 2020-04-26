/*
package com.example.demo.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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

 //ChromeDriver Tests x 4

    @Test
    public void homeButtonInSpecificEventPageWorks() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c1981660\\Desktop\\ChromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        this.webDriver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/viewSpecificEvent?eventId=1");
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("showevent"), "Harry"));
        this.webDriver.findElement(By.id("hometest")).click();
        assertTrue(webDriver.findElement(By.id("eventtitle")).getText().contains("Events"));
        this.webDriver.quit();
    }

    @Test
    public void createEventButtonInSpecificEventPageWorks() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c1981660\\Desktop\\ChromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        this.webDriver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/viewSpecificEvent?eventId=1");
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("showevent"), "Harry"));
        this.webDriver.findElement(By.id("createeventtest")).click();
        assertTrue(webDriver.findElement(By.id("createeventtesttitle")).getText().contains("Create a New Event"));
        this.webDriver.quit();
    }

    @Test
    public void loginPageLinksToRegisterPageAndAsksForCorrectInfo() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c1981660\\Desktop\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        this.webDriver = new ChromeDriver(options);

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/loginTemplate");
        assertTrue(webDriver.findElement(By.id("testregisterlink")).getText().contains("No account? Register"));
        this.webDriver.findElement(By.id("testregisterlinktwo")).click();
        assertTrue(webDriver.findElement(By.id("testregisteremail")).getText().contains("Email"));
        assertTrue(webDriver.findElement(By.id("testregisterpassword")).getText().contains("Password"));
        assertTrue(webDriver.findElement(By.id("testregisterfirstname")).getText().contains("First Name"));
        assertTrue(webDriver.findElement(By.id("testregistersurname")).getText().contains("Surname"));
        this.webDriver.quit();
    }



    @Test
    public void cancelEventWorksAndDeletesEventFromEventFeed() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\c1981660\\Desktop\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=42227");
        this.webDriver = new ChromeDriver(options);

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/viewEvents");
        int sizeOfEventListBeforeDeletingEvent = webDriver.findElements(By.id("listofevents")).size();
        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/viewSpecificEvent?eventId=4");
        this.webDriver.findElement(By.id("deleteeventtestbutton")).click();
        assertTrue(webDriver.findElement(By.id("testdeleteeventalert")).getText().contains("Are you sure you want to cancel"));
        this.webDriver.findElement(By.id("deleteeventtest")).click();
        assertTrue(webDriver.findElement(By.id("eventtitle")).getText().contains("Events"));
        int sizeOfEventListAfterDeletingEvent = webDriver.findElements(By.id("listofevents")).size();
        assertTrue(sizeOfEventListBeforeDeletingEvent > sizeOfEventListAfterDeletingEvent);
        this.webDriver.quit();
    }

    //FIREFOX DRIVER TESTs x 2

    @Test
    public void errorAlertIfRegistrationFormNotComplete() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\c1981660\\Desktop\\GeckoDriver\\geckodriver.exe");
        this.webDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/loginTemplate");
        this.webDriver.findElement(By.id("testregisterlinktwo")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sub")));
        this.webDriver.findElement(By.id("sub")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("errortest"), "ERROR"));
        assertTrue(webDriver.findElement(By.id("errortest")).getText().contains("ERROR"));
        this.webDriver.quit();
    }

    @Test
    public void eventFeedDisplaysCorrectPreviousAndUpcomingEvents() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\c1981660\\Desktop\\GeckoDriver\\geckodriver.exe");
        this.webDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/viewEvents");
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("eventtitletest"), "Summer"));
        assertTrue(webDriver.findElement(By.id("eventtitletest")).getText().contains("Summer Party"));
        this.webDriver.findElement(By.id("previoustest")).click();
        assertTrue(webDriver.findElement(By.id("eventtitletest")).getText().contains("Xmas Party"));
        this.webDriver.quit();
    }

    //IEDriver Test x 1

    @Test
    public void specificEventPageShowsCorrectEventDetails() {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\c1981660\\Desktop\\IEDriver\\IEDriverServer.exe");
        this.webDriver = new InternetExplorerDriver();

        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/viewSpecificEvent?eventId=1");
        assertTrue(webDriver.findElement(By.id("showevent")).getText().contains("Harry"));
        assertTrue(webDriver.findElement(By.id("time")).getText().contains("1900"));
        assertTrue(webDriver.findElement(By.id("date")).getText().contains("2020-12-31"));
        assertTrue(webDriver.findElement(By.id("location")).getText().contains("Board Room"));
        assertTrue(webDriver.findElement(By.id("description")).getText().contains("Wizardry"));
        this.webDriver.quit();
    }

}*/