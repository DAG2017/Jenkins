package CheckOut;
import PageObjects.CellPhonesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;

public class BasePage {
    protected static WebDriver driver;
    static WebDriverWait myWait;
    static WebElement element;
    static DateFormat format;

    static boolean status;

    protected static BrowserSelector browserSelector=new BrowserSelector();
    protected static LoadProp loadProp=new LoadProp();
    protected static SoftAssert softAssert = new SoftAssert();
    static CellPhonesPage cellPhonesPage = new CellPhonesPage();
}
