package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LogOut {
    private WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Logout')]")
    private WebElement logOutButton;

    public LogOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
