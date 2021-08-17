package Java;


import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter@Setter
public class AddEmployee {

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Employees')]")
    private WebElement employeesButton;

    @FindBy(xpath = "//span[@class='material-icons'][contains(.,'add')]")
    private WebElement addEmployeeButton;

//    @FindBy(xpath = "//i[@class='fas fa-times fa-3x']")
//    private WebElement xButton;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement name;

    @FindBy(xpath = "(//td[@role='cell'][contains(.,'Calin Marcel')])")
    private WebElement insertedName;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement email;

@FindBy(xpath = "//div[@class='mat-select-arrow ng-tns-c116-96']")
    private WebElement internalPosition;

    @FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c72-23'][contains(.,'Unit')]")
    private WebElement unit;

    @FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'U1')]")
    private WebElement unitChoice1;

    @FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c72-25'][contains(.,'Business unit')]")
    private WebElement businessUnit;

    @FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'BU1')]")
    private WebElement businessUnitChoice1;

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

    public AddEmployee(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setName(String employee){
        name.sendKeys(employee);
    }
    public void setEmail(String emailL){
        email.sendKeys(emailL);
    }
}