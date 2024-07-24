package org.IrvinCampos;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class ConsoleLogsCaptureTest {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","C://Users//Irvin//Desktop//Selenium-Server//chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.partialLinkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

        LogEntries entry = driver.manage().logs().get(LogType.BROWSER); // Get LogEntry object
        List<LogEntry> logs = entry.getAll(); // LogEntry object -> getAll method returns all logs in list
        for (LogEntry log: logs) { // iterating through list and printing log message
            System.out.println(log.getMessage());
        }

    }
}
