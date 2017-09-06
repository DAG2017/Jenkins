package CheckOut;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {

    //1. Create unique random number using date format
    public static String randomNumber() {
        format = new SimpleDateFormat("YYMMddHms");
        return format.format(new Date());
    }

    public static String nextSessionId() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    //2. Clear default value by clear method and enter new value using sendKeys method
    public static void clearAndEnter(By by,String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    //3. Select web element (e.g. radio button, check box, button etc.) or deselect web element by click method
    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    /*4. Use submit() for form element
         This method works better than the click() if the current element is a form, or an element within a form.
         If submit() causes the current page to change, then this method will wait until the new page is loaded.
    */
    public static void submitFormElement(By by) {
        driver.findElement(by).submit();
    }

    //5. Select value from dropdown list using byVisibleText method
    public static void selectFromListByText(By by,String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }


    //6. Select value from dropdown list using byValue method
    public static void selectFromListByValue(By by,String text) {
        new Select(driver.findElement(by)).selectByValue(text);
    }

    //7. Select value from dropdown list using byIndex method
    public static void selectFromListByIndex(By by,int i) {
        new Select(driver.findElement(by)).selectByIndex(i);
    }

    //8. Launch browser and direct it to the Base URL
    public static void setupUrl(String baseUrl) {
        driver.get(baseUrl);
    }

    //9. Create implicit wait
    public static void implicitWait(int sec) {
        driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
    }

    //10. Wait until web element (e.g.text box) load.
    public static void untilElementLoadImplicitWait(By by) {
        myWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //11. Maximize screen
    public static void maxWindow() {
        driver.manage().window().maximize();
    }

    //12. Full screen
    public static void fullScreenWindow() {
        driver.manage().window().fullscreen();
    }

    //13. Compare the actual URL with expected URL
    public static boolean compareActualUrlWithExpectedUrl(String expectedURL) {
        String actualUrl = driver.getCurrentUrl(); // Storing URL in String variable
        return status = actualUrl.equals(expectedURL);
    }

    //14. Printing Title & Title length in the Console window
    public static void printPageTitleAndLength() {
        String title = driver.getTitle();// Storing Title name in the String variable
        int titleLength = driver.getTitle().length(); // Storing Title length in the Int variable
        System.out.println("Title of the page is : " + title);
        System.out.println("Length of the title is : " + titleLength);
    }

    //15. Printing length of the Page Source on console
    public static void printPageSourceLength() {
        String pageSource = driver.getPageSource();// Storing Page Source in String variable
        int pageSourceLength = pageSource.length();// Storing Page Source length in Int variable
        System.out.println("Total length of the Pgae Source is : " + pageSourceLength);
    }

    //16. Go back to Home Page
    public static void homePage(String baseURL) {
        driver.navigate().to(baseURL);
    }

    //17. Go back to Previous Page (backword)
    public static void backPage() {
        driver.navigate().back();
    }

    //18. Go to Next Page (Forward)
    public static void nextPage() {
        driver.navigate().forward();
    }

    //19. Refresh browser
    public static void refreshBrowser() {
        driver.navigate().refresh();
    }

    //20. Check that if the Text field is enabled, if yes enter value
    public static void isEnabledThenEnterValue(By by,String text) {
        element = driver.findElement(by);
        status = element.isEnabled();
        if (status) {
            element.sendKeys(text);
        }
    }

    //21. Determine whether or not element (e.g. Checkboxes, Select Options and Radio Buttons) is selected or not
    public static boolean isAlreadySelected(By by) {
        element = driver.findElement(by);
        status = element.isSelected();
        return status;
    }

    //22. Print all the Options
    // To get the Count of the total elements inside SELECT and to Print the text value of every element present in the SELECT.
    public static void printAllOptionsDropDownList(By by) {
        Select oSelect = new Select(driver.findElement(by));
        List<WebElement> elementCount = oSelect.getOptions();
        int iSize = elementCount.size();
        for (int i = 0; i < iSize; i++) {
            String sValue = elementCount.get(i).getText();
            System.out.println(sValue);
        }
    }

    //23. Multi Select ByVisibleText Methods ----- NEED TO MODIFY AS PER REQUIREMENT
    //This works on Multiple selection boxes and not on regular List boxes or dropdown.
    public static void multiSelectByVisibleText(By by,String s1,String s2) {
        Select oSelect = new Select(driver.findElement(by));
        oSelect.selectByVisibleText(s1);
        oSelect.selectByVisibleText(s2);
    }

    //24. Multi Select ByValue
    public static void multiSelectByValue(By by,String s1,String s2) {
        Select oSelect = new Select(driver.findElement(by));
        oSelect.selectByValue(s1);
        oSelect.selectByValue(s2);
    }

    //25. Multi Select ByIndex
    public static void multiSelectByIndex(By by,int i1,int i2) {
        Select oSelect = new Select(driver.findElement(by));
        oSelect.selectByIndex(i1);
        oSelect.selectByIndex(i2);
    }

    //26. To find Actual Text in available in entire page
    public static boolean isPageContainsActualText(String text) {
        status = driver.getPageSource().contains(text);
        return status;
    }

    //27. To get Actual Text of element
    public static String actualText(By by) {
        String aText = driver.findElement(by).getText();
        //System.out.println(aText);
        return aText;
    }

    //28. Capture Screenshot
    public static void captureScreenshot(WebDriver driver,String screenshotName) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver; //down casting
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            format = new SimpleDateFormat("ddMMMYHHmmss");
            FileUtils.copyFile(source,new File("./Screenshots/" + screenshotName + format.format(new Date()) +".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    //29. Compare the actual text with expected text
    public static boolean compareActualTextWithExpectedText(By by,String expectedText) {
        String actualText = driver.findElement(by).getText();
        return status = actualText.equals(expectedText);
    }

    //30. Delete all cookies
    public static void delallCookies(){
        driver.manage().deleteAllCookies();
    }

    //31. Hover / Mouse Over element
    public static void hoverEffect(By by, By by1){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(by);
        action.moveToElement(we).build().perform();
        clickElement(by1);
    }

    //32. scroll page up or down (up is minus i.e. -250)
    public static void scrollPage(int x, int y){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy("+x+","+y+")", "");
    }

    //33. Check Alert is Present
    public static boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } // try
        catch (Exception e) {
            return false;
        } // catch
    }


}