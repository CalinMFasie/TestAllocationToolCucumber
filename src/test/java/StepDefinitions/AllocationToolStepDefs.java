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
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AllocationToolStepDefs {
    SoftAssert softAssert = new SoftAssert();
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

        assertEquals(driver.getCurrentUrl(), "http://localhost:4200/projects");
    }

    @Then("Add new Employee with Name as {string} email as {string} supervisor as {string} workingHours as {string} startDate as {string} endDate as {string}")
    public void TestAddNewEmployee(String employeeName, String employeeEmail, String supervisor, String workingHours, String startDate, String endDate) throws AWTException, InterruptedException {
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
        addEmployee.getActive().click();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(100);
        addEmployee.setSupervisor(supervisor);
        addEmployee.setWorkingHours(workingHours);
        addEmployee.setStartDate(startDate);
        addEmployee.setEndDate(endDate);
        addEmployee.getSaveButton().click();
        Thread.sleep(200);
        boolean isInserted = addEmployee.getInsertedName().isDisplayed();
        assertTrue(isInserted);
        System.out.println(isInserted);
        driver.quit();
    }

    @Given("Edit Employee with Name as {string} email as {string} supervisor as {string} workingHours as {string} startDate as {string} endDate as {string}")
    //@And("Edit employee with Name as {string} email as {string} supervisor as {string} workingHours as {string} startDate as {string} endDate as {string}")
    public void TestEditEmployee(String employeeName, String employeeEmail, String supervisor, String workingHours, String startDate, String endDate) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/employees");
        loginPage = new LoginPage(driver);
        loginPage.getUsername().sendKeys("AdminOne");
        loginPage.getPassword().sendKeys("PasswordOne");
        loginPage.getLoginButton().click();

        Thread.sleep(1000);
        EditEmployee editEmployee;
        editEmployee = new EditEmployee(driver);
        List<WebElement> webElementList = driver.findElements(By.xpath("/html/body/app-root/div/app-overview/div[2]/mat-table/tr"));
        for (int i = 0; i < webElementList.size(); i++) {
            if (webElementList.get(i).getText().contains("Calin Marcel")) {
                webElementList.get(i).findElement(By.xpath("(//span[@class='material-icons'][contains(.,'edit')])[" + i + "]")).click();
            }
        }
        clearFields();
        editEmployee.setName(employeeName);
        editEmployee.setEmail(employeeEmail);
        editEmployee.setSupervisor(supervisor);
        editEmployee.setWorkingHours(workingHours);
        editEmployee.getSaveButton().click();
        Thread.sleep(1000);
        try {
            boolean isModified = editEmployee.getModifiedName().isDisplayed();
            assertTrue(isModified);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }

    public void clearFields() {
        EditEmployee editEmployee;
        editEmployee = new EditEmployee(driver);
        editEmployee.getName().clear();
        editEmployee.getEmail().clear();
        editEmployee.getSupervisor().clear();
        editEmployee.getWorkingHours().clear();
        editEmployee.getStartDate().clear();//not working
        editEmployee.getStartDate().sendKeys(Keys.SPACE);
        editEmployee.getEndDate().clear();
    }

    @Then("Delete employee")
    public void TestDeleteEmployee() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/employees");
        loginPage = new LoginPage(driver);
        loginPage.getUsername().sendKeys("AdminOne");
        loginPage.getPassword().sendKeys("PasswordOne");
        loginPage.getLoginButton().click();
        DeleteEmployee deleteUser = new DeleteEmployee(driver);

        Thread.sleep(200);
        List<WebElement> webElementList = driver.findElements(By.xpath("/html/body/app-root/div/app-overview/div[2]/mat-table/tr"));

        for (int i = 0; i < webElementList.size(); i++) {
            if (webElementList.get(i).getText().contains("Modified User")) {
                webElementList.get(i).findElement(By.xpath("(//span[@class='material-icons'][contains(.,'delete')])[" + i + "]")).click();
                deleteUser.getAcceptDelete().click();
                break;
            }
        }
        Thread.sleep(100);
        for (int i = 0; i < webElementList.size(); i++) {
            try {
                assertFalse(webElementList.get(i).getText().contains("Modified User"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driver.close();
    }

//   @Then("Add new project with ([^\"]*),([^\"]*)")
    @Then("Add new project with Name as {string} client as {string} startDate as {string} endDate as {string} description as {string}")
    public void TestAddNewProject(String projectName, String clientName, String startDate, String endDate, String description) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/projects");
        loginPage = new LoginPage(driver);
        loginPage.getUsername().sendKeys("AdminOne");
        loginPage.getPassword().sendKeys("PasswordOne");
        loginPage.getLoginButton().click();

        Thread.sleep(100);
        AddProject addProject = new AddProject(driver);
        addProject.getAddButton().click();
        addProject.setProjectName(projectName);
        addProject.setClientName(clientName);
        addProject.setDescription(description);
        addProject.setStartDate(startDate);
        addProject.setEndDate(endDate);
        addProject.getAddProjectButton().click();
        Thread.sleep(50);

        try {
            Assert.assertTrue(addProject.getInsertedProject().isDisplayed());
        } catch (Exception e) {
            Assert.fail("Project was not added");
        }
        driver.close();
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