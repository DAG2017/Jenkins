import CheckOut.Utils;
import PageObjects.*;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestSuite extends BaseTest {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    CellPhonesPage cellPhonesPage = new CellPhonesPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    public void verifyUserIsAbleToLoginSuccessfully() {
        homePage.navigateToRegister();
        registerPage.registerUser();
        String actualMessage = Utils.actualText(By.xpath("//form/div/div[2]/div"));
        String expectedMessage = "Your registration completed";
        Assert.assertEquals(actualMessage,expectedMessage,"TC1 - User is not able to login" ); //hard assert
    }
/*
    @Test(priority = 2)
    public void verifyUserIsAbleToEmailAFriendSuccessfully(){
        homePage.navigateToRegister();
        registerPage.registerUser();
        Utils.clickElement(By.xpath("//div[2]/input")); // click on continue button - navigate to home page
        homePage.navigateToBuildYourOwnComputer();
        buildYourOwnComputerPage.navigateToEmailAFriend();
        emailAFriendPage.fillEmailAFriendForm();
        String actualMessage = Utils.actualText(By.xpath("//div[3]/div/div/div/div[2]/div[2]"));
        String expectedMessage = "Your message has been sent.";
        softAssert.assertEquals(actualMessage,expectedMessage,"TC2 - Existing user is not able to email a friend"); //soft assert
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyUserIsNotAbleToEmailAFriendWithoutRegistration(){
        homePage.navigateToBuildYourOwnComputer();
        buildYourOwnComputerPage.navigateToEmailAFriend();
        emailAFriendPage.fillEmailAFriendForm();
        String actualMessage = Utils.actualText(By.xpath("//form/div/div/ul/li"));
        String expectedMessage = "Only registered customers can use email a friend feature";
        Assert.assertEquals(actualMessage,expectedMessage,"TC3 - User has to logged in to use email a friend functionality"); //hard assert
    }

    @Test(priority = 4)
    public void verifyRegisteredUserIsAbleToOrderSuccessfully(){
        homePage.navigateToRegister();
        registerPage.registerUser();
        homePage.navigateToCellPhonesHoverOnElectronics();
        cellPhonesPage.selectProductsAndAddToCart();
        shoppingCartPage.verifySelectedProductsAreInShoppingCartAndNavigateToCheckout();
        checkoutPage.fillBillingAddressForm();
        String actual = driver.findElement(By.xpath("//div[@class=\"section order-completed\"]/div/strong")).getText();
        Assert.assertEquals(actual, "Your order has been successfully processed!", "Order is not placed successfully. Please check.");
    }*/
}


