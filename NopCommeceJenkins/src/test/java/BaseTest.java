import CheckOut.BasePage;
import CheckOut.Utils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BasePage {

    @BeforeMethod
    public void openBrowser(){
        browserSelector.setUpBrowser(System.getProperty("Browser"));
        Utils.implicitWait(Integer.parseInt(loadProp.getProperty("waitInSec")));
        Utils.setupUrl(loadProp.getProperty("baseUrl"));
        Utils.delallCookies();
    }

    @AfterMethod
    public void tearDownBrowser(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Utils.captureScreenshot(driver,result.getName());
        }
        driver.quit();
    }
}
