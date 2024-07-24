package org.IrvinCampos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.ConnectionType;

import java.util.Optional;

public class NetworkSpeedTest {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","Users/irvin/Desktop//selenium-server/chromedriver.exe");
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false,3000,20000,100000, Optional.of(ConnectionType.ETHERNET),
                Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });

        long startTime = System.currentTimeMillis();
        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String title = driver.findElement(By.xpath("//h1[@class='default-ltr-cache-jpuyb8 e9eyrqp8']")).getText();
//        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
//        driver.close();
    }
}
