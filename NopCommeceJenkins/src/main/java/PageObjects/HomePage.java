package PageObjects;

import CheckOut.BasePage;
import CheckOut.Utils;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By _Register = By.linkText("Register");
    private By _BuildYourOwnComputer = By.xpath("//div[2]/h2/a");
    private By _Electronics = By.linkText("Electronics");
    private By _CellPhones = By.linkText("Cell phones");

    public void navigateToRegister() {
        Utils.clickElement(_Register);
    }

    public void navigateToBuildYourOwnComputer(){
        Utils.clickElement( _BuildYourOwnComputer);
    }

    public void navigateToCellPhonesHoverOnElectronics(){ Utils.hoverEffect(_Electronics, _CellPhones); }

}