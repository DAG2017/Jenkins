package PageObjects;

import CheckOut.BasePage;
import CheckOut.Utils;
import org.openqa.selenium.By;

public class CellPhonesPage extends BasePage {

    private By _HTCOneM8 = By.linkText("HTC One M8 Android L 5.0 Lollipop");
    private By _AddToCartHTCOneM8 = By.xpath("//div[@class=\"item-grid\"]/div/div/div[2]/div[3]/div[2]/input");
    private By _Lumia1020 = By.linkText("Nokia Lumia 1020");
    private By _AddToCartLumia1020 = By.xpath("//div[@class=\"item-grid\"]/div[3]/div/div[2]/div[3]/div[2]/input");
    private By _closeShoppingCartNotificationBar = By.xpath("//div[@id=\"bar-notification\"]/span");
    private By _shoppingCart = By.linkText("Shopping cart");


    public void selectProductsAndAddToCart(){

        String HTCOneM8 = Utils.actualText(_HTCOneM8);
        Utils.scrollPage(0, 350); //scroll page down
        Utils.clickElement(_AddToCartHTCOneM8);
        String Lumia1020 =  Utils.actualText(_Lumia1020);
        Utils.scrollPage(0,250); //scroll page down
        Utils.clickElement(_AddToCartLumia1020);
        Utils.clickElement(_closeShoppingCartNotificationBar); //click on close button of notification bar
        Utils.scrollPage(0, -250); //scroll page up
        Utils.clickElement(_shoppingCart); //click on shopping cart on top right corner
    }
}


