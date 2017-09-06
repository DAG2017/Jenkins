package PageObjects;

import CheckOut.BasePage;
import CheckOut.Utils;
import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage {

    private By _HTCOneM8inCheckout = By.xpath("//tbody/tr/td[4]/a");
    private By _Lumia1020inCheckout = By.xpath("//tbody/tr[2]/td[4]/a");
    private By _countryID = By.id("CountryId");
    private By _termsOfService = By.id("termsofservice");
    private By _checkOut = By.id("checkout");

    public void verifySelectedProductsAreInShoppingCartAndNavigateToCheckout() {

        softAssert.assertEquals(Utils.actualText(_HTCOneM8inCheckout), "HTC One M8 Android L 5.0 Lollipop", "Selected first product is different in shopping cart");
        softAssert.assertEquals(Utils.actualText(_Lumia1020inCheckout), "Nokia Lumia 1020", "Selected second product is different in shopping cart");

        Utils.selectFromListByText(_countryID, loadProp.getProperty("country"));
        Utils.clickElement(_termsOfService);
        Utils.clickElement(_checkOut); // navigate to checkout page
    }
}

