package Pages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class UserAuthentication {
	
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	public UserAuthentication(AppiumDriver<MobileElement> driver) throws InterruptedException {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public boolean loginWithFacebook() throws InterruptedException {
		
		By fbbtn = MobileBy.id("com.todoist:id/btn_facebook");
		wait.until(ExpectedConditions.presenceOfElementLocated(fbbtn));
		driver.findElement(fbbtn).click();
		return isErrorMessageDisplayed();
	}
	
	public boolean loginWithGoogle() throws InterruptedException {
		
		By googlebtn = MobileBy.id("com.todoist:id/btn_google");
		wait.until(ExpectedConditions.presenceOfElementLocated(googlebtn));
		driver.findElement(googlebtn).click();
		Thread.sleep(5000);
		Set<String> contextHandles = driver.getContextHandles();
        for (String context : contextHandles) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.LinearLayout[1]")));
        driver.findElement(MobileBy.xpath("//android.widget.LinearLayout[1]")).click();
        driver.context("NATIVE_APP");
		return isErrorMessageDisplayed();
	}
	
	public boolean invalidCredentials(String useremail, String password) throws InterruptedException {
		
		By opt = MobileBy.id("com.todoist:id/more_signin_options");
		wait.until(ExpectedConditions.presenceOfElementLocated(opt));
		driver.findElement(opt).click();
		By log = MobileBy.xpath("//android.widget.TextView[@text='Login with Email']");
		wait.until(ExpectedConditions.presenceOfElementLocated(log));
		driver.findElement(log).click();
		
		Thread.sleep(2000);
		Set<String> contextHandles = driver.getContextHandles();
        for (String context : contextHandles) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
        By cancel = MobileBy.id("com.google.android.gms:id/cancel");
		wait.until(ExpectedConditions.presenceOfElementLocated(cancel));
		driver.findElement(cancel).click();
        
		Thread.sleep(2000);
		Set<String> handles = driver.getContextHandles();
        for (String context : handles) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
        Thread.sleep(2000);
        
        driver.findElement(MobileBy.className("android.widget.ScrollView")).click();
        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")).sendKeys(useremail);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]")).sendKeys(password);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.Button")).click();
		Thread.sleep(2000);
		((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		return isErrorMessageDisplayed();
	}
	
	public boolean login(String useremail, String password) throws InterruptedException {
		By opt = MobileBy.id("com.todoist:id/more_signin_options");
		wait.until(ExpectedConditions.presenceOfElementLocated(opt));
		driver.findElement(opt).click();
		
		By log = MobileBy.xpath("//android.widget.TextView[@text='Login with Email']");
		wait.until(ExpectedConditions.presenceOfElementLocated(log));
		driver.findElement(log).click();
		
		
		Thread.sleep(2000);
		Set<String> contextHandles = driver.getContextHandles();
        for (String context : contextHandles) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
        By cancel = MobileBy.id("com.google.android.gms:id/cancel");
		wait.until(ExpectedConditions.presenceOfElementLocated(cancel));
		driver.findElement(cancel).click();
        
        
		Thread.sleep(2000);
		Set<String> handles = driver.getContextHandles();
        for (String context : handles) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
        driver.findElement(MobileBy.className("android.widget.ScrollView")).click();
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")).sendKeys(useremail);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]")).sendKeys(password);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.Button")).click();
		driver.context("NATIVE_APP");
		Thread.sleep(20000);
		return isErrorMessageDisplayed();
		
	}

	public boolean signup(String useremail, String password) throws InterruptedException {
		
		By opt = MobileBy.id("com.todoist:id/more_signin_options");
		wait.until(ExpectedConditions.presenceOfElementLocated(opt));
		driver.findElement(opt).click();
		
		By sign = MobileBy.xpath("//android.widget.TextView[@text='Sign up with Email']");
		wait.until(ExpectedConditions.presenceOfElementLocated(sign));
		driver.findElement(sign).click();
		
		Thread.sleep(2000);
		Set<String> handles = driver.getContextHandles();
        for (String context : handles) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
        Thread.sleep(2000);
        By email = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
        wait.until(ExpectedConditions.presenceOfElementLocated(email));
        driver.findElement(email).sendKeys(useremail);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]")).sendKeys(password);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]/android.widget.Button")).click();
		
		By options = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]");
		wait.until(ExpectedConditions.elementToBeClickable(options));
		driver.findElement(options).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[5]/android.widget.Button")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]")).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[5]/android.widget.Button")).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.Button")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]")).click();
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[2]")).click();
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]")).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.xpath("//android.view.View[@content-desc=\"Done\"]")).click();
		return isErrorMessageDisplayed();
		
	}
	
    public void logout() throws InterruptedException {
    	
    	try {
    		By menubtn = MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    		wait.until(ExpectedConditions.presenceOfElementLocated(menubtn));
    		driver.findElement(menubtn).click();
    	}catch(Exception e) {
    		By menubtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]");
    		wait.until(ExpectedConditions.presenceOfElementLocated(menubtn));
    		driver.findElement(menubtn).click();
    	}
		By settingsbtn = MobileBy.id("com.todoist:id/profile_settings");
		wait.until(ExpectedConditions.presenceOfElementLocated(settingsbtn));
		driver.findElement(settingsbtn).click();
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
        
        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[12]/android.widget.RelativeLayout")).click();
        Thread.sleep(1000);
		Set<String> handles = driver.getContextHandles();
        for (String context : handles) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
        driver.findElement(MobileBy.id("android:id/button1")).click();
        driver.context("NATIVE_APP");
     }
    
    public boolean isErrorMessageDisplayed() throws InterruptedException {
    	try {
    		By elementLocator = MobileBy.id("com.todoist:id/fab");
    		wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
    }

}
