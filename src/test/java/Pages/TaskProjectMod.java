package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TaskProjectMod {
	
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	
	public TaskProjectMod(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	public boolean createTask() {
		By addTask = MobileBy.id("com.todoist:id/fab");
		wait.until(ExpectedConditions.presenceOfElementLocated(addTask));
		driver.findElement(addTask).click();
		
		By taskName = MobileBy.id("android:id/message");
		wait.until(ExpectedConditions.presenceOfElementLocated(taskName));
		driver.findElement(taskName).sendKeys("Meeting with QUPS");
		
		By taskDesc = MobileBy.id("com.todoist:id/description");
		wait.until(ExpectedConditions.presenceOfElementLocated(taskDesc));
		driver.findElement(taskDesc).sendKeys("Interview with QUPS for SQA intern");
		
		By done = MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Add\"]");
		wait.until(ExpectedConditions.presenceOfElementLocated(done));
		driver.findElement(done).click();
		
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		try {
			By added = MobileBy.xpath("//android.widget.TextView[@text='Meeting with QUPS']");
			wait.until(ExpectedConditions.presenceOfElementLocated(added));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean editDate() throws InterruptedException {
		
		By addedTask = MobileBy.xpath("//android.widget.TextView[@text='Meeting with QUPS']");
		wait.until(ExpectedConditions.presenceOfElementLocated(addedTask));
		driver.findElement(addedTask).click();
		
		By editDate = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.View/android.view.View/android.widget.TextView");
		wait.until(ExpectedConditions.presenceOfElementLocated(editDate));
		driver.findElement(editDate).click();
		
		By selectDate = MobileBy.AccessibilityId("25 October 2023");
		wait.until(ExpectedConditions.presenceOfElementLocated(selectDate));
		driver.findElement(selectDate).click();
		
		By addtime = MobileBy.id("com.todoist:id/add_time_text");
		wait.until(ExpectedConditions.presenceOfElementLocated(addtime));
		driver.findElement(addtime).click();
		
		By selectHour = MobileBy.xpath("//android.view.View[@content-desc=\"3 o'clock\"]");
		wait.until(ExpectedConditions.presenceOfElementLocated(selectHour));
		driver.findElement(selectHour).click();
		
		By selectMinute = MobileBy.AccessibilityId("25 minutes");
		wait.until(ExpectedConditions.presenceOfElementLocated(selectMinute));
		driver.findElement(selectMinute).click();
		
		By selectside = MobileBy.xpath("//android.view.View[@content-desc=\"Select AM or PM\"]/android.view.View[2]/android.widget.Button");
		wait.until(ExpectedConditions.presenceOfElementLocated(selectside));
		driver.findElement(selectside).click();
		
		By confirm = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[10]/android.widget.Button");
		wait.until(ExpectedConditions.presenceOfElementLocated(confirm));
		driver.findElement(confirm).click();
		
		By save = MobileBy.id("com.todoist:id/scheduler_submit");
		wait.until(ExpectedConditions.presenceOfElementLocated(save));
		driver.findElement(save).click();
		
		Thread.sleep(2000);
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		
		try {
			By edited = MobileBy.xpath("//android.widget.TextView[@text='Meeting with QUPS']");
			wait.until(ExpectedConditions.presenceOfElementLocated(edited));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean completeTask() throws InterruptedException {
		try {
    		By menubtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]");
    		driver.findElement(menubtn).click();
    	}catch(Exception e) {
    		By menubtn = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    		driver.findElement(menubtn).click();
    	}
		
		By inbox = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.compose.ui.platform.ComposeView[1]/android.view.View/android.view.View");
		wait.until(ExpectedConditions.presenceOfElementLocated(inbox));
		driver.findElement(inbox).click();
		
		By task = MobileBy.xpath("//android.widget.TextView[@text='Meeting with QUPS']");
		wait.until(ExpectedConditions.presenceOfElementLocated(task));
		driver.findElement(task).click();
		
		By complete = MobileBy.xpath("//android.widget.CheckBox[@content-desc=\"Complete\"]") ;
		wait.until(ExpectedConditions.presenceOfElementLocated(complete));
		driver.findElement(complete).click();
		Thread.sleep(2000);
		try {
			By completed = MobileBy.xpath("//android.widget.TextView[@text='Meeting with QUPS']");
			wait.until(ExpectedConditions.presenceOfElementLocated(completed));
			return false;
		}catch(Exception e) {
			return true;
		}
		
	}
	
	public boolean deleteTask() throws InterruptedException {
		
		By task = MobileBy.xpath("//android.widget.TextView[@text='Bangladesh Match']");
		wait.until(ExpectedConditions.presenceOfElementLocated(task));
		driver.findElement(task).click();
		
		Thread.sleep(1000);
		driver.findElement(MobileBy.id("com.todoist:id/item_overflow")).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.id("com.todoist:id/delete")).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.id("android:id/button1")).click();
		
		Thread.sleep(2000);
		
		try {
			By deleted = MobileBy.xpath("//android.widget.TextView[@text='Bangladesh Match']");
			wait.until(ExpectedConditions.presenceOfElementLocated(deleted));
			return false;
		}catch(Exception e) {
			return true;
		}
		
	}
	
	public boolean createProject() throws InterruptedException {
		try {
    		By menubtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]");
    		driver.findElement(menubtn).click();
    	}catch(Exception e) {
    		By menubtn = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    		driver.findElement(menubtn).click();
    	}
		
		By addProject = MobileBy.xpath("//android.view.View[@content-desc=\"Add\"]");
		wait.until(ExpectedConditions.presenceOfElementLocated(addProject));
		driver.findElement(addProject).click();
		
		By name = MobileBy.id("com.todoist:id/name");
		wait.until(ExpectedConditions.presenceOfElementLocated(name));
		driver.findElement(name).sendKeys("Q2 assignment");

		By color = MobileBy.id("com.todoist:id/form_color");
		wait.until(ExpectedConditions.presenceOfElementLocated(color));
		driver.findElement(color).click();
		
		By select = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[10]");
		wait.until(ExpectedConditions.presenceOfElementLocated(select));
		driver.findElement(select).click();
		
		By fav = MobileBy.id("com.todoist:id/favorite");
		wait.until(ExpectedConditions.presenceOfElementLocated(fav));
		driver.findElement(fav).click();
		
		By view = MobileBy.id("com.todoist:id/board_view_radio");
		wait.until(ExpectedConditions.presenceOfElementLocated(view));
		driver.findElement(view).click();
		
		By done = MobileBy.id("com.todoist:id/menu_form_submit");
		wait.until(ExpectedConditions.presenceOfElementLocated(done));
		driver.findElement(done).click();
		
		try {
			By created = MobileBy.xpath("//android.widget.TextView[@text='Q2 assignment']");
			wait.until(ExpectedConditions.presenceOfElementLocated(created));
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public boolean checkInbox() {
		
		try {
			try {
	    		By menubtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]");
	    		driver.findElement(menubtn).click();
	    	}catch(Exception e) {
	    		By menubtn = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
	    		driver.findElement(menubtn).click();
	    	}
			
			By inbox = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.compose.ui.platform.ComposeView[1]/android.view.View/android.view.View");
			wait.until(ExpectedConditions.presenceOfElementLocated(inbox));
			driver.findElement(inbox).click();
			
			try {
	    		By menubtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]");
	    		driver.findElement(menubtn).click();
	    	}catch(Exception e) {
	    		By menubtn = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
	    		driver.findElement(menubtn).click();
	    	}
			
			By today = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.compose.ui.platform.ComposeView[2]/android.view.View/android.view.View");
			wait.until(ExpectedConditions.presenceOfElementLocated(today));
			driver.findElement(today).click();
			
			try {
	    		By menubtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]");
	    		driver.findElement(menubtn).click();
	    	}catch(Exception e) {
	    		By menubtn = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
	    		driver.findElement(menubtn).click();
	    	}
			
			By upcoming = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.compose.ui.platform.ComposeView[3]/android.view.View/android.view.View");
			wait.until(ExpectedConditions.presenceOfElementLocated(upcoming));
			driver.findElement(upcoming).click();
			
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public boolean filteredTask() throws InterruptedException {
		
		try {
			try {
	    		By menubtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]");
	    		driver.findElement(menubtn).click();
	    	}catch(Exception e) {
	    		By menubtn = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
	    		driver.findElement(menubtn).click();
	    	}
			
			By filtered = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.compose.ui.platform.ComposeView[4]/android.view.View/android.view.View");
			wait.until(ExpectedConditions.presenceOfElementLocated(filtered));
			driver.findElement(filtered).click();
			
			By assigned = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView");
			wait.until(ExpectedConditions.presenceOfElementLocated(assigned));
			driver.findElement(assigned).click();
			
			Thread.sleep(1000);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			
			By priority = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView");
			wait.until(ExpectedConditions.presenceOfElementLocated(priority));
			driver.findElement(priority).click();
			
			Thread.sleep(1000);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			
			By routines = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(routines));
			driver.findElement(routines).click();
			
			Thread.sleep(1000);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			return true;
			
		}catch(Exception e) {
			return false;
		}
		
	}
	
}
