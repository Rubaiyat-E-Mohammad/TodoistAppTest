package TodoistApp;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import Pages.ModifySettings;
import Pages.TaskProjectMod;
import Pages.UserAuthentication;
import java.net.URL;
import io.qameta.allure.*;

public class Todoist {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	@Description("Opening the app")
	public void openTodoist() throws InterruptedException, Exception {
	    
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "sdk_gphone_arm64");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.todoist");
		cap.setCapability("appActivity", "com.todoist.activity.HomeActivity");
		cap.setCapability("automationName", "UIAutomator2");
		
		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Application Started");
	}
	
	@Test(priority = 1, description = "Verify that a user can successfully register his account by Facebook")
    @Severity(SeverityLevel.CRITICAL)
	public void FacebookLogin() throws InterruptedException {
		UserAuthentication user = new UserAuthentication(driver);
		Assert.assertTrue("Error! Couldn't signup ", user.loginWithFacebook());
		Thread.sleep(5000);
		user.logout();
	}
	
	@Test(priority = 2, description = "Verify that a user can successfully register his account by google")
    @Severity(SeverityLevel.CRITICAL)
	public void GoogleLogin() throws Exception {
		UserAuthentication user = new UserAuthentication(driver);
		user.loginWithGoogle();
		Assert.assertTrue("Error! Couldn't signup ", user.isErrorMessageDisplayed());
		Thread.sleep(5000);
		user.logout();
	}
	
	@Test(priority = 3, description = "Verify that a user cannot log in with invalid credentials")
    @Severity(SeverityLevel.NORMAL)
	public void invalidCredential() throws Exception {
		UserAuthentication user = new UserAuthentication(driver);
		Assert.assertFalse("Error!Logged in using invalid credentials", user.invalidCredentials("tons2468@gmail.com", "TonMon@223"));
	}
	
	@Test(priority = 4, description = "Verify that a user can sign up with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
	public void signup() throws Exception {
		UserAuthentication user = new UserAuthentication(driver);
		Assert.assertTrue("Error! Couldn't signup ", user.signup("tonmon48@gmail.com", "TonMon@223"));
		Thread.sleep(10000);
		user.logout();
	}
	
	@Test(priority = 5, description = "Verify that a user can log in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
	public void login() throws Exception {
		UserAuthentication user = new UserAuthentication(driver);
		Assert.assertTrue("Error!Couldn't login", user.login("tonmon10@gmail.com", "TonMon@223"));
		Thread.sleep(2000);
	}
	
	@Test(priority = 6, description = "Create a new task with a specific title")
    @Severity(SeverityLevel.CRITICAL)
	public void createTask() throws Exception {
		TaskProjectMod task = new TaskProjectMod(driver);
		Assert.assertTrue("Error!Couldn't create a task", task.createTask());
		Thread.sleep(1000);
	}
	
	@Test(priority = 7, description = "Edit the due date for the task")
    @Severity(SeverityLevel.CRITICAL)
	public void editDate() throws Exception {
		TaskProjectMod date = new TaskProjectMod(driver);
		Assert.assertFalse("Error!Couldn't edit date", date.editDate());
		Thread.sleep(1000);
	}
	
	@Test(priority = 8, description = "Check that a specific task can mark as completed")
    @Severity(SeverityLevel.CRITICAL)
	public void completeTask() throws Exception {
		TaskProjectMod complete= new TaskProjectMod(driver);
		Assert.assertTrue("Error!Couldn't complete a task", complete.completeTask());
		Thread.sleep(1000);
	}
	
	@Test(priority = 9, description = "Check that a specific task can be deleted")
    @Severity(SeverityLevel.CRITICAL)
	public void deleteTask() throws Exception {
		TaskProjectMod delete = new TaskProjectMod(driver);
		Assert.assertTrue("Error!Couldn't delete a task", delete.deleteTask());
		Thread.sleep(1000);
	}
	
	@Test(priority = 10, description = "Create a new project with a specific name")
    @Severity(SeverityLevel.CRITICAL)
	public void createProject() throws Exception {
		TaskProjectMod project = new TaskProjectMod(driver);
		Assert.assertTrue("Error!Couldn't create a project", project.createProject());
		Thread.sleep(1000);
	}
	
	@Test(priority = 11, description = "Check that a user can check inbox, today and upcoming events")
    @Severity(SeverityLevel.CRITICAL)
	public void checkInbox() throws Exception {
		TaskProjectMod inbox = new TaskProjectMod(driver);
		Assert.assertTrue("Error!Couldn't check", inbox.checkInbox());
		Thread.sleep(1000);
	}
	
	@Test(priority = 12, description = "Check that a user can check filtered task")
    @Severity(SeverityLevel.CRITICAL)
	public void filteredTask() throws Exception {
		TaskProjectMod filtered = new TaskProjectMod(driver);
		Assert.assertTrue("Error!Couldn't find filtered task", filtered.filteredTask());
		Thread.sleep(1000);
	}
	
	@Test(priority = 13, description = "Verify that a user can modify account name")
    @Severity(SeverityLevel.CRITICAL)
	public void modifyName() throws Exception {
		ModifySettings name = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change name", name.modifyName());
		Thread.sleep(1000);
	}
	
	@Test(priority = 14, description = "Verify that a user can change home view")
    @Severity(SeverityLevel.CRITICAL)
	public void chnageView() throws Exception {
		ModifySettings home = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change home view", home.chnageView());
		Thread.sleep(1000);
	}
	
	@Test(priority = 15, description = "Verify that a user can sync home view")
    @Severity(SeverityLevel.CRITICAL)
	public void syncView() throws Exception {
		ModifySettings home = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change sync view", home.syncView());
		Thread.sleep(1000);
	}
	
	@Test(priority = 16, description = "Verify that a user can change language")
    @Severity(SeverityLevel.CRITICAL)
	public void changeLang() throws Exception {
		ModifySettings lang = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change language", lang.changeLang());
		Thread.sleep(1000);
	}
	
	@Test(priority = 17, description = "Verify that a user can modify date and time settings")
    @Severity(SeverityLevel.CRITICAL)
	public void timeDate() throws Exception {
		ModifySettings td = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change time & date", td.timeDate());
		Thread.sleep(1000);
	}
	
	@Test(priority = 18, description = "Verify that a user can adjust swipe action features")
    @Severity(SeverityLevel.CRITICAL)
	public void swipeAction() throws Exception {
		ModifySettings swipe = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't adjust swipe acction", swipe.swipeAction());
		Thread.sleep(1000);
	}
	
	@Test(priority = 19, description = "Verify that a user can change the theme")
    @Severity(SeverityLevel.CRITICAL)
	public void changeTheme() throws Exception {
		ModifySettings theme = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change theme", theme.changeTheme());
		Thread.sleep(1000);
	}
	
	@Test(priority = 20, description = "Verify that a user can change app icon")
    @Severity(SeverityLevel.CRITICAL)
	public void changeIcon() throws Exception {
		ModifySettings icon = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change icon", icon.changeIcon());
		Thread.sleep(1000);
	}
	
	@Test(priority = 21, description = "Verify that a user can change UI of bottom app bar")
    @Severity(SeverityLevel.CRITICAL)
	public void changeAppBar() throws Exception {
		ModifySettings bar = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change App bar", bar.changeAppBar());
		Thread.sleep(1000);
	}
	
	@Test(priority = 22, description = "Verify that a user can modify navigation menu")
    @Severity(SeverityLevel.CRITICAL)
	public void navMenu() throws Exception {
		ModifySettings nav = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't change navigation manu", nav.navMenu());
		Thread.sleep(1000);
	}
	
	@Test(priority = 23, description = "Verify that a user can modify quick add features")
    @Severity(SeverityLevel.CRITICAL)
	public void quickAdd() throws Exception {
		ModifySettings add = new ModifySettings(driver);
		Assert.assertTrue("Error!Couldn't quick add", add.quickAdd());
		Thread.sleep(1000);
	}
	
}
