package stepdefs;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import cucumber.api.java.After;

public class Hooks {

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        Configuration.timeout = 3000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        System.out.println("Мы в бефор хукс");
    }

    @After
    public void quitBrowser () {WebDriverRunner.closeWebDriver();;
    }


}
