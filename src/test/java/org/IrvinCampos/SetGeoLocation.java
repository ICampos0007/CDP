package org.IrvinCampos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class SetGeoLocation {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Map<String,Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 40);
        coordinates.put("longtitude", 3);
        coordinates.put("accuracy", 1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String title = driver.findElement(By.xpath("//h1[@class='default-ltr-cache-jpuyb8 e9eyrqp8']")).getText();
        System.out.println(title);
    }
}
