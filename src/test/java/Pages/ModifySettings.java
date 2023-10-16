package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ModifySettings {
	
	
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	
	public ModifySettings(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public boolean modifyName() throws InterruptedException {
		try {
			try {
	    		By menubtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]");
	    		driver.findElement(menubtn).click();
	    	}catch(Exception e) {
	    		By menubtn = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
	    		driver.findElement(menubtn).click();
	    	}
			By settingsbtn = MobileBy.id("com.todoist:id/profile_settings");
			wait.until(ExpectedConditions.presenceOfElementLocated(settingsbtn));
			driver.findElement(settingsbtn).click();
	    	Thread.sleep(2000);
	    	driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
			Thread.sleep(1000);
			driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
			Thread.sleep(1000);
			MobileElement textbox = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText"));
			textbox.clear();
			textbox.sendKeys("Tonmoy Monmoy");
			driver.findElement(MobileBy.id("android:id/button1")).click();
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean chnageView() throws InterruptedException {
		
		try {
			By general = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView");
			wait.until(ExpectedConditions.presenceOfElementLocated(general));
			driver.findElement(general).click();
			
			By homeview = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout") ;
			wait.until(ExpectedConditions.presenceOfElementLocated(homeview));
			driver.findElement(homeview).click();
			
			By select = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ViewAnimator/android.widget.ExpandableListView/android.widget.CheckedTextView[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(select));
			driver.findElement(select).click();
			Thread.sleep(1000);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean syncView() {
		
		try {
			By syncview = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox");
			wait.until(ExpectedConditions.presenceOfElementLocated(syncview));
			driver.findElement(syncview).click();
			driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox")).click();
			Thread.sleep(1000);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean changeLang() throws InterruptedException {
		
		try {
			By lang = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(lang));
			driver.findElement(lang).click();
			
			By select = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(select));
			driver.findElement(select).click();
			return true;
		}catch(Exception e) {
			return false;
		}
	
	}
	
	public boolean timeDate() throws InterruptedException {
		
		try {
			By zone = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(zone));
			driver.findElement(zone).click();
			
			By select = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(select));
			driver.findElement(select).click();
			
			By start = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[9]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(start));
			driver.findElement(start).click();
			
			By sunday = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(sunday));
			driver.findElement(sunday).click();
			
			Thread.sleep(2000);
	        int height = driver.manage().window().getSize().getHeight();

	        int startY = (int) (height * 0.8);
	        int endY = (int) (height * 0.2);

	        int centerX = driver.manage().window().getSize().getWidth() / 2;

	        new TouchAction<>(driver)
	            .press(PointOption.point(centerX, startY))
	            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	            .moveTo(PointOption.point(centerX, endY))
	            .release()
	            .perform();
	        
	        By nextWeek = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(nextWeek));
			driver.findElement(nextWeek).click();
			
			By next = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(next));
			driver.findElement(next).click();
			
			By weekend = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(weekend));
			driver.findElement(weekend).click();
			
			By end = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[6]");
			wait.until(ExpectedConditions.presenceOfElementLocated(end));
			driver.findElement(end).click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean swipeAction() {
		try {
			By swiperight = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(swiperight));
			driver.findElement(swiperight).click();
			
			By right = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
			wait.until(ExpectedConditions.presenceOfElementLocated(right));
			driver.findElement(right).click();
			
			By swipeleft = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(swipeleft));
			driver.findElement(swipeleft).click();
			
			By left = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]");
			wait.until(ExpectedConditions.presenceOfElementLocated(left));
			driver.findElement(left).click();
			
			Thread.sleep(1000);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean changeTheme() {
		try {
			
			By theme = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(theme));
			driver.findElement(theme).click();
			Thread.sleep(1000);
			By select = MobileBy.xpath("(//android.widget.ImageView[@content-desc=\"Theme preview\"])[3]");
			wait.until(ExpectedConditions.presenceOfElementLocated(select));
			driver.findElement(select).click();
			
			Thread.sleep(1000);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			
			Thread.sleep(1000);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean changeIcon() {
		try {
			
			By icon = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(icon));
			driver.findElement(icon).click();
			
			By select = MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Black\"]");
			wait.until(ExpectedConditions.presenceOfElementLocated(select));
			driver.findElement(select).click();
			
			Thread.sleep(1000);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			
			Thread.sleep(1000);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean changeAppBar() {
		try {
			
			By appbar = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(appbar));
			driver.findElement(appbar).click();
			
			By select = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView/android.widget.RadioButton[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(select));
			driver.findElement(select).click();
			
			Thread.sleep(500);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			
			Thread.sleep(1000);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean navMenu() {
		try {
			By navmenu = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(navmenu));
			driver.findElement(navmenu).click();
			
			By select = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.widget.CheckBox[4]");
			wait.until(ExpectedConditions.presenceOfElementLocated(select));
			driver.findElement(select).click();
			Thread.sleep(500);
			
			By toggle = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(toggle));
			driver.findElement(toggle).click();
			
			Thread.sleep(1000);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			
			Thread.sleep(1000);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean quickAdd() {
		try {
			
			By quickadd = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.RelativeLayout");
			wait.until(ExpectedConditions.presenceOfElementLocated(quickadd));
			driver.findElement(quickadd).click();
			
			By add1 = MobileBy.xpath("(//android.view.View[@content-desc=\"Show\"])[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(add1));
			driver.findElement(add1).click();

			By add2 = MobileBy.xpath("//android.view.View[@content-desc=\"Show\"]");
			wait.until(ExpectedConditions.presenceOfElementLocated(add2));
			driver.findElement(add2).click();

			By remove1 = MobileBy.xpath("(//android.view.View[@content-desc=\"Hide\"])[4]");
			wait.until(ExpectedConditions.presenceOfElementLocated(remove1));
			driver.findElement(remove1).click();

			By label = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(label));
			driver.findElement(label).click();

			Thread.sleep(1000);
			((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			
			Thread.sleep(2000);
	        int height = driver.manage().window().getSize().getHeight();

	        int startY = (int) (height * 0.8);
	        int endY = (int) (height * 0.2);

	        int centerX = driver.manage().window().getSize().getWidth() / 2;

	        new TouchAction<>(driver)
	            .press(PointOption.point(centerX, startY))
	            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	            .moveTo(PointOption.point(centerX, endY))
	            .release()
	            .perform();
			
	        Thread.sleep(1000);
	        
	        ((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	        ((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
