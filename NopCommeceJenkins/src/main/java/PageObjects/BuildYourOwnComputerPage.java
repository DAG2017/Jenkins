package PageObjects;

import CheckOut.BasePage;
import CheckOut.Utils;
import org.openqa.selenium.By;

public class BuildYourOwnComputerPage extends BasePage {

    private By _EmailAFriendButton = By.cssSelector("input[class=\"button-2 email-a-friend-button\"]");

    public void navigateToEmailAFriend(){
        Utils.clickElement(_EmailAFriendButton);
    }
}
