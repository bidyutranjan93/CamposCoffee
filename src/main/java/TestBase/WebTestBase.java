package TestBase;

import Util.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {

    public Properties prop;
    public static WebDriver driver;

    public WebTestBase(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
        }catch (Exception e){
            e.printStackTrace();
        }

        prop = new Properties();
        try {
            prop.load(fileInputStream);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void initialization(){
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/browser/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/browser/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/browser/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please select a correct browser name");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WebDriverUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverUtil.IMPLICIT_WAIT));
        driver.manage().deleteAllCookies();
    }
}
