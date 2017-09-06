package PageObjects;

import CheckOut.BasePage;
import CheckOut.LoadProp;
import CheckOut.Utils;
import org.openqa.selenium.By;

public class EmailAFriendPage extends BasePage {
    private By _FriendEmail = By.id("FriendEmail");
    private By _YourEmailAddress = By.id("YourEmailAddress");
    private By _PersonalMessage = By.id("PersonalMessage");
    private By _SendEmailButton = By.name("send-email");

    public void fillEmailAFriendForm(){
        Utils.clearAndEnter(_FriendEmail,loadProp.getProperty("friendEmail"));
        if(driver.findElement(_YourEmailAddress).getAttribute("value").isEmpty()){
            Utils.clearAndEnter(_YourEmailAddress,loadProp.getProperty("newYourEmail"));
        }
        Utils.clearAndEnter(_PersonalMessage,loadProp.getProperty("personalMessage"));
        Utils.clickElement(_SendEmailButton);
    }
}
