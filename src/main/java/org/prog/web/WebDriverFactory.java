package org.prog.web;

import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class WebDriverFactory {

    @SneakyThrows
    public static WebDriver getDriver() {
        String driverType = System.getProperty("driver.type", "chrome");
        String isJenkins = System.getProperty("jenkins.container", "false");

        if (isJenkins.equals("false")) {
            switch (driverType) {
                case "selenoid":
                    return new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"), remoteChromeOptions());
                case "firefox":
                    return new FirefoxDriver();
                case "edge":
                    return new EdgeDriver();
                default:
                    return new ChromeDriver(chromeOptions());
            }
        } else {
            Capabilities options;
            switch (driverType) {
                case "firefox":
                    options = remoteFFOptions();
                    break;
                default:
                    options = remoteChromeOptions();
            }
            return new RemoteWebDriver(
                    new URL("http://selenoid-selenoid-1:4444/wd/hub"), options);
        }
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--start-maximized");
        return options;
    }

    private static ChromeOptions remoteChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("enableVNC", true);
        }});
        return options;
    }

    private static FirefoxOptions remoteFFOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("enableVNC", true);
        }});
        return options;
    }
}
