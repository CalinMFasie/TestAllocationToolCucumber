package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage {
    @FindBy(xpath = "//input[@ng-reflect-name='username']")
    private WebElement username;

    @FindBy(xpath= "//input[contains(@formcontrolname,'password')]")
    private WebElement password;

    //    @FindBy(xpath = "//button[@class='btn btn-outline-primary']")
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Login')]")
    private WebElement loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
