package Java;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class EditEmployee {
    private WebDriver driver;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement name;

    @FindBy(xpath = "(//td[@role='cell'][contains(.,'Calin Marcel')])[1]")
    private WebElement insertedName;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement email;

    @FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'U2')]")
    private WebElement unitChoice2;

    @FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c72-25'][contains(.,'Business unit')]")
    private WebElement businessUnit;

    @FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'BU2')]")
    private WebElement businessUnitChoice2;

    @FindBy(xpath = "//input[@formcontrolname='supervisor']")
    private WebElement supervisor;

    @FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
    private WebElement active;

    @FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c72-28'][contains(.,'Working hours')]")
    private WebElement workingHours;

    @FindBy(xpath = "//input[contains(@type,'number')]")
    private WebElement scrollWorkingHours;

    @FindBy(xpath = "//input[@formcontrolname='startDate']")
    private WebElement startDate;

    @FindBy(xpath = "//input[@formcontrolname='endDate']")
    private WebElement endDate;

    @FindBy(xpath = "//span[contains(.,'Save')]")
    private WebElement saveButton;

    public EditEmployee(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
