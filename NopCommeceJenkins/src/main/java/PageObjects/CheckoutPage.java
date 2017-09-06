package PageObjects;

import CheckOut.BasePage;
import CheckOut.Utils;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private By _emailBillingAddress = By.id("BillingNewAddress_Email");
    private By _countryId = By.id("BillingNewAddress_CountryId");
    private By _stateId = By.id("BillingNewAddress_StateProvinceId");
    private By _city = By.id("BillingNewAddress_City");
    private By _address1 = By.id("BillingNewAddress_Address1");
    private By _zipCode = By.id("BillingNewAddress_ZipPostalCode");
    private By _phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    private By _continueButtonBillingAddress = By.xpath("//input[@class=\"button-1 new-address-next-step-button\"]");
    private By _shippingMethod = By.cssSelector("li#opc-shipping_method > div > h2");
    private By _nextDayAir = By.id("shippingoption_1");
    private By _continueButtonShippingMethod = By.xpath("//input[@class=\"button-1 shipping-method-next-step-button\"]");
    private By _paymentMethod = By.cssSelector("li#opc-payment_method > div > h2");
    private By _creditCard = By.id("paymentmethod_1");
    private By _continuePaymentMethod = By.xpath("//input[@class=\"button-1 payment-method-next-step-button\"]");
    private By _paymentInformation = By.cssSelector("li#opc-payment_info > div > h2");
    private By _creditCardType = By.id("CreditCardType");
    private By _cardHolderName = By.id("CardholderName");
    private By _cardNumber = By.id("CardNumber");
    private By _expireMonth = By.id("ExpireMonth");
    private By _expireYear = By.id("ExpireYear");
    private By _cardCode = By.id("CardCode");
    private By _continueButtonPayInfo = By.xpath("//input[@class=\"button-1 payment-info-next-step-button\"]");
    private By _continueButtonConfirmOrder = By.xpath("//input[@class=\"button-1 confirm-order-next-step-button\"]");

    public void fillBillingAddressForm(){

        Utils.clearAndEnter(_emailBillingAddress, loadProp.getProperty("newYourEmail"));
        Utils.selectFromListByText(_countryId, loadProp.getProperty("country"));
        Utils.clearAndEnter(_city, loadProp.getProperty("city"));
        Utils.clearAndEnter(_address1, loadProp.getProperty("addressLine1"));
        Utils.clearAndEnter(_zipCode, loadProp.getProperty("postCode"));
        Utils.clearAndEnter(_phoneNumber, loadProp.getProperty("phoneNo"));

        Utils.clickElement(_continueButtonBillingAddress);
        softAssert.assertEquals(Utils.actualText(_shippingMethod), "Shipping method", "This is not shipping method section");

        Utils.clickElement(_nextDayAir); // click on next day air radio button

        Utils.clickElement(_continueButtonShippingMethod);
        softAssert.assertEquals(Utils.actualText(_paymentMethod), "Payment method", "This is not payment method section");

        Utils.clickElement(_creditCard); //click on credit card radio button

        Utils.clickElement(_continuePaymentMethod);

        String actualString2 = Utils.actualText(_paymentInformation);
        softAssert.assertEquals(actualString2, "Payment information", "This is not payment information section");

        Utils.selectFromListByText(_creditCardType, loadProp.getProperty("creditCardType"));
        Utils.clearAndEnter(_cardHolderName, loadProp.getProperty("cardholderName"));
        Utils.clearAndEnter(_cardNumber, loadProp.getProperty("creditCardNo"));
        Utils.selectFromListByText(_expireMonth, loadProp.getProperty("monthExpirationDate"));
        Utils.selectFromListByText(_expireYear, loadProp.getProperty("yearExpirationDate"));
        Utils.clearAndEnter(_cardCode, loadProp.getProperty("creditCardCode"));

        Utils.clickElement(_continueButtonPayInfo);

        Utils.clickElement(_continueButtonConfirmOrder);

        softAssert.assertAll();
    }
}
