package PageObjects;
import CheckOut.BasePage;
import CheckOut.Utils;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private By _Gender = By.id("gender-male");
    private By _FirstName = By.id("FirstName");
    private By _LastName = By.id("LastName");
    private By _DayDOB = By.name("DateOfBirthDay");
    private By _MonthDOB = By.name("DateOfBirthMonth");
    private By _YearDOB = By.name("DateOfBirthYear");
    private By _Email = By.id("Email");
    private By _Company = By.id("Company");
    private By _NewsLetter = By.id("Newsletter");
    private By _Password = By.id("Password");
    private By _ConfirmPassword = By.id("ConfirmPassword");
    private By _RegisterButton = By.id("register-button");

    public void registerUser() {

        Utils.clickElement(_Gender);

        Utils.clearAndEnter(_FirstName,loadProp.getProperty("firstName"));
        Utils.clearAndEnter(_LastName,loadProp.getProperty("lastName"));

        Utils.selectFromListByText(_DayDOB,loadProp.getProperty("dayDOB"));
        Utils.selectFromListByText(_MonthDOB,loadProp.getProperty("monthDOB"));
        Utils.selectFromListByText(_YearDOB,loadProp.getProperty("yearDOB"));

        Utils.clearAndEnter(_Email,loadProp.getProperty("lastName").toLowerCase() + Utils.randomNumber() + "@gmail.com");

        Utils.clearAndEnter(_Company,loadProp.getProperty("companyName"));

        Boolean flag = Utils.isAlreadySelected(_NewsLetter);
        if (flag) { Utils.clickElement(_NewsLetter);}// remove tick

        Utils.clearAndEnter(_Password,loadProp.getProperty("password"));
        Utils.clearAndEnter(_ConfirmPassword,loadProp.getProperty("password"));

        Utils.submitFormElement(_RegisterButton);
    }
}
