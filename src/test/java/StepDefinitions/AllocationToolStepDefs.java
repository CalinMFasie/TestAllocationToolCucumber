package StepDefinitions;

import Java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AllocationToolStepDefs {

    private static final String BASE_URL = "http://localhost:4200/users";
    public WebDriver driver;
    private LoginPage loginPage;

    @Given("User is logged in")
    public void TestUserIsLoggedIn() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        loginPage.getUsername().sendKeys("AdminOne");
        loginPage.getPassword().sendKeys("PasswordOne");
        loginPage.getLoginButton().click();

        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/projects");
    }

    @Then("Add new Employee with Name as {string} email as {string}")
    public void TestAddNewEmployee(String employeeName, String employeeEmail) throws AWTException, InterruptedException {
        AddEmployee addEmployee = new AddEmployee(driver);
        addEmployee.getEmployeesButton().click();
        addEmployee.getAddEmployeeButton().click();
        addEmployee.setName(employeeName);
        addEmployee.setEmail(employeeEmail);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        addEmployee.getUnit().click();
        Thread.sleep(100);
        addEmployee.getUnitChoice1().click();
        addEmployee.getBusinessUnit().click();
        addEmployee.getBusinessUnitChoice1().click();
        addEmployee.getSupervisor().sendKeys("Manager");
        addEmployee.getActive().click();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
//      addEmployee.getWorkingHours().click();
        Thread.sleep(100);
        addEmployee.getScrollWorkingHours().sendKeys(Keys.ARROW_UP);
        addEmployee.getStartDate().sendKeys("8/1/2021");
        addEmployee.getEndDate().sendKeys("8/31/2021");
        addEmployee.getSaveButton().click();
        Thread.sleep(1000);
        boolean isInserted = addEmployee.getInsertedName().isDisplayed();
        assertTrue(isInserted);
        System.out.println(isInserted);
        driver.quit();
    }

    @And("Edit employee")
    public void TestEditEmployee() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/employees");
        loginPage = new LoginPage(driver);
        loginPage.getUsername().sendKeys("AdminOne");
        loginPage.getPassword().sendKeys("PasswordOne");
        loginPage.getLoginButton().click();

        Thread.sleep(100);
        EditEmployee editEmployee;
        editEmployee = new EditEmployee(driver);
        List<WebElement> webElementList = driver.findElements(By.xpath("/html/body/app-root/div/app-overview/div[2]/mat-table/tr"));
        for (int i = 0; i < webElementList.size(); i++) {
            if (webElementList.get(i).getText().contains("Calin Marcel")) {
                webElementList.get(i).findElement(By.xpath("(//span[@class='material-icons'][contains(.,'edit')])[" + i + "]")).click();
            }
        }
        clearFields();
        editEmployee.getName().sendKeys("Modified user");
        editEmployee.getEmail().sendKeys("email@modified.ro");
        editEmployee.getSaveButton().click();
    }

    public void clearFields() {
        EditEmployee editEmployee;
        editEmployee = new EditEmployee(driver);
        editEmployee.getName().clear();
        editEmployee.getEmail().clear();
    }

    @Then("Delete employee")
    public void TestDeleteEmployee() throws InterruptedException {
        Thread.sleep(200);
        List<WebElement> webElementList = driver.findElements(By.xpath("/html/body/app-root/div/app-overview/div[2]/mat-table/tr"));
        for (int i = 0; i < webElementList.size(); i++) {
            if (webElementList.get(i).getText().contains("Modified user")) {
                webElementList.get(i).findElement(By.xpath("(//span[@class='material-icons'][contains(.,'delete')])[" + i + "]")).click();
                DeleteEmployee deleteUser = new DeleteEmployee(driver);
                deleteUser.getAcceptDelete().click();
            }
        }
        Thread.sleep(100);
    }

    @Then("User is logged out")
    public void TestLogout() {
        LogOut logOut = new LogOut(driver);
        logOut.getLogOutButton().click();
        driver.navigate().refresh();
        final String ACTUAL_URL = driver.getCurrentUrl();
        assertEquals(ACTUAL_URL, "http://localhost:4200/login");
        driver.quit();
    }
}