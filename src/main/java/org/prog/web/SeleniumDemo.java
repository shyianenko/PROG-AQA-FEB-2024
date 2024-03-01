package org.prog.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//TODO: go to rozetka
//TODO: search for any goods (iPhone 15)
//TODO: print that goods name ( Мобильный телефон Apple iPhone 15 Pro Max 256GB Black Titanium (MU773RX/A) )

public class SeleniumDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://rozetka.com.ua");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
            //accept cookies if they are present
            //find all buttons in cookies form

            //sreach for razer
            //Step 1: set search form value to razer
            WebElement searchInput = driver.findElement(By.name("search"));
            WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'search-form__submit')]"));
            searchInput.sendKeys("razer blackshark v2 pro");
//            Thread.sleep(4000);
            //Step 2: press enter while in search form
            searchInput.sendKeys(Keys.ENTER);
//            wait.until(ExpectedConditions.visibilityOf(searchButton));
//            searchButton.click();

            List<WebElement> searchGoods = driver.findElements(By.xpath("//div[@class='goods-tile__inner']//span[@class='goods-tile__title']"));
//            Thread.sleep(4000);
            wait.until(ExpectedConditions.visibilityOfAllElements(searchGoods));
            WebElement firstGood = searchGoods.get(0);
            String titleOfFirstGood = firstGood.getText();
            System.out.println(titleOfFirstGood);

        } finally {
            driver.quit();
        }
    }
}

/*
Without Thread.sleep(4000) on line 33 and 40 I've got such error on every second run:
"C:\Program Files\Java\jdk-17\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.2\lib\idea_rt.jar=57765:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.2\bin" -Dfile.encoding=UTF-8 -classpath "D:\MyWork\Java courses\Homeworks\PROG-AQA-FEB-2024\target\classes;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-java\4.18.1\selenium-java-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-api\4.18.1\selenium-api-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-chrome-driver\4.18.1\selenium-chrome-driver-4.18.1.jar;C:\Users\relli\.m2\repository\com\google\auto\service\auto-service-annotations\1.1.1\auto-service-annotations-1.1.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-chromium-driver\4.18.1\selenium-chromium-driver-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-json\4.18.1\selenium-json-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-manager\4.18.1\selenium-manager-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-devtools-v120\4.18.1\selenium-devtools-v120-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-devtools-v121\4.18.1\selenium-devtools-v121-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-devtools-v122\4.18.1\selenium-devtools-v122-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-devtools-v85\4.18.1\selenium-devtools-v85-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-edge-driver\4.18.1\selenium-edge-driver-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-firefox-driver\4.18.1\selenium-firefox-driver-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-http\4.18.1\selenium-http-4.18.1.jar;C:\Users\relli\.m2\repository\dev\failsafe\failsafe\3.3.2\failsafe-3.3.2.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-ie-driver\4.18.1\selenium-ie-driver-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-remote-driver\4.18.1\selenium-remote-driver-4.18.1.jar;C:\Users\relli\.m2\repository\com\google\guava\guava\33.0.0-jre\guava-33.0.0-jre.jar;C:\Users\relli\.m2\repository\com\google\guava\failureaccess\1.0.2\failureaccess-1.0.2.jar;C:\Users\relli\.m2\repository\com\google\guava\listenablefuture\9999.0-empty-to-avoid-conflict-with-guava\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;C:\Users\relli\.m2\repository\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;C:\Users\relli\.m2\repository\org\checkerframework\checker-qual\3.41.0\checker-qual-3.41.0.jar;C:\Users\relli\.m2\repository\com\google\errorprone\error_prone_annotations\2.23.0\error_prone_annotations-2.23.0.jar;C:\Users\relli\.m2\repository\com\google\j2objc\j2objc-annotations\2.8\j2objc-annotations-2.8.jar;C:\Users\relli\.m2\repository\io\opentelemetry\semconv\opentelemetry-semconv\1.23.1-alpha\opentelemetry-semconv-1.23.1-alpha.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-api\1.35.0\opentelemetry-api-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-context\1.35.0\opentelemetry-context-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-exporter-logging\1.35.0\opentelemetry-exporter-logging-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-sdk-common\1.35.0\opentelemetry-sdk-common-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-sdk-extension-autoconfigure-spi\1.35.0\opentelemetry-sdk-extension-autoconfigure-spi-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-sdk-extension-autoconfigure\1.35.0\opentelemetry-sdk-extension-autoconfigure-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-api-events\1.35.0-alpha\opentelemetry-api-events-1.35.0-alpha.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-sdk-trace\1.35.0\opentelemetry-sdk-trace-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-extension-incubator\1.35.0-alpha\opentelemetry-extension-incubator-1.35.0-alpha.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-sdk\1.35.0\opentelemetry-sdk-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-sdk-metrics\1.35.0\opentelemetry-sdk-metrics-1.35.0.jar;C:\Users\relli\.m2\repository\io\opentelemetry\opentelemetry-sdk-logs\1.35.0\opentelemetry-sdk-logs-1.35.0.jar;C:\Users\relli\.m2\repository\net\bytebuddy\byte-buddy\1.14.12\byte-buddy-1.14.12.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-os\4.18.1\selenium-os-4.18.1.jar;C:\Users\relli\.m2\repository\org\apache\commons\commons-exec\1.3\commons-exec-1.3.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-safari-driver\4.18.1\selenium-safari-driver-4.18.1.jar;C:\Users\relli\.m2\repository\org\seleniumhq\selenium\selenium-support\4.18.1\selenium-support-4.18.1.jar" org.prog.web.SeleniumDemo
Exception in thread "main" org.openqa.selenium.WebDriverException: no such execution context
  (Session info: chrome=122.0.6261.95)
Build info: version: '4.18.1', revision: 'b1d3319b48'
System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '17.0.10'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Command: [73f694d79c8dcb7d86f59a7455d640fb, sendKeysToElement {id=f.9617529AD63372864B907142F46E2BA5.d.AFA2500E840E15CF901924C8179FBA75.e.23, value=[Ljava.lang.CharSequence;@28dcca0c}]
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 122.0.6261.95, chrome: {chromedriverVersion: 122.0.6261.94 (880dbf29479c..., userDataDir: C:\Users\relli\AppData\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:57772}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:57772/devtoo..., se:cdpVersion: 122.0.6261.95, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
Element: [[ChromeDriver: chrome on windows (73f694d79c8dcb7d86f59a7455d640fb)] -> name: search]
Session ID: 73f694d79c8dcb7d86f59a7455d640fb
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
	at org.openqa.selenium.remote.ErrorCodec.decode(ErrorCodec.java:167)
	at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:138)
	at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:50)
	at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:190)
	at org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:216)
	at org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:174)
	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:519)
	at org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:223)
	at org.openqa.selenium.remote.RemoteWebElement.sendKeys(RemoteWebElement.java:110)
	at org.prog.web.SeleniumDemo.main(SeleniumDemo.java:35)

Process finished with exit code 1
 */