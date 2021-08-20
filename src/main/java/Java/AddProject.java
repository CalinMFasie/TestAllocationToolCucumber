package Java;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class AddProject {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='material-icons'][contains(.,'add')]")
    private WebElement addButton;

    @FindBy(xpath = "//input[contains(@formcontrolname,'name')]")
    private WebElement projectName;

    @FindBy(xpath = "(//td[@role='cell'][contains(.,'AutonomousLogan')])")
    private WebElement insertedProject;

    @FindBy(xpath = "//input[@formcontrolname='client']")
    private WebElement clientName;

    @FindBy(xpath = "//input[contains(@formcontrolname,'startDate')]")
    private WebElement startDate;

    @FindBy(xpath = "//input[contains(@formcontrolname,'endDate')]")
    private WebElement endDate;

    @FindBy(xpath = "//textarea[contains(@formcontrolname,'description')]")
    private WebElement description;

    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Add Project')]")
    private WebElement addProjectButton;

    public AddProject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setProjectName(String project) {
        projectName.sendKeys(project);
    }

    public void setClientName(String client) {
        clientName.sendKeys(client);
    }

    public void setDescription(String descriptionText) {
        description.sendKeys(descriptionText);
    }
    public void setStartDate(String startDate1) {
        startDate.sendKeys(startDate1);
    }
    public void setEndDate(String endDate1) {
        endDate.sendKeys(endDate1);
    }
}
