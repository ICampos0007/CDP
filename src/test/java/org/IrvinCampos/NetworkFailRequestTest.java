package org.IrvinCampos;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v126.fetch.Fetch;
import org.openqa.selenium.devtools.v126.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v126.network.model.ErrorReason;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NetworkFailRequestTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://Users//Irvin//Desktop//Selenium-Server//chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
//        java.util.Optional<java.lang.String> urlPattern
        Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
        devTools.send(Fetch.enable(patterns, Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), request ->
        {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }
}
