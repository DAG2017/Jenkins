package CheckOut;

//import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSelector extends BasePage {

    // if - else ladder
    public void LaunchBrowser(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            driver =new FirefoxDriver();
            System.out.println("Firefox Browser launched");
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            //BasicConfigurator.configure();
            System.out.println("Google Chrome Browser launched");
        }else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver",".\\src\\main\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            System.out.println("Internet Explorer Browser launched");
        }else{
            System.out.println("Browser name is empty or invalid");
        }
    }

    // switch case
    public void setUpBrowser(String browser) {
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                Utils.maxWindow();
                System.out.println("Setup Firefox Browser");
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                Utils.maxWindow();
                System.out.println("Setup Google Chrome Browser");
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                Utils.maxWindow();
                if (Utils.isAlertPresent()) {
                        System.out.println("Alert is present");
                        driver.switchTo().alert();
                        driver.switchTo().alert().accept();
                        driver.switchTo().defaultContent();
                }else{
                    System.out.println("No Alert Found!!");
                }
                System.out.println("Setup Internet Explorer Browser");
            default:
                System.out.println("Browser name is empty or invalid");
        }
    }
}
