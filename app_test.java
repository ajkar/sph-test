package sph_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
 
public class app_test {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Nexus 5X");
		caps.setCapability("platformName", "Android");
		caps.setCapability("app", "/Users/Ajkar/Downloads/com.buuuk.st.apk");
		caps.setCapability("appWaitActivity", "com.sph.straitstimes.*");
		
		//Instantiate Appium Driver
		try {
			AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			
			//To bypass terms and conditions
			MobileElement el1 = (MobileElement) driver.findElementById("com.buuuk.st:id/btn_tnc_ok");
			el1.click();
			// Scroll operation at Introduction Screen
			 TouchAction touch = new TouchAction(driver);
			 touch.press(471,780)
			  .moveTo(531,-9)
			  .release()
			  .perform();
			  
			(new TouchAction(driver))
			  .press(52,858)
			  .moveTo(907,-52)
			  .release()
			  .perform();
			  
			(new TouchAction(driver))
			  .press(982,823)
			  .moveTo(-890,17)
			  .release()
			  .perform();
			  
			MobileElement el2 = (MobileElement) driver.findElementById("com.buuuk.st:id/tv_skip_intro");
			el2.click();
			
			MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
			el3.click();

			MobileElement el4 = (MobileElement) driver.findElementById("com.buuuk.st:id/tv_login");
			el4.click();
			//Login
			MobileElement el5 = (MobileElement) driver.findElementById("com.buuuk.st:id/et_ldap_login_username");
			el5.sendKeys("mohamedajkarali@gmail.com");
			MobileElement el6 = (MobileElement) driver.findElementById("com.buuuk.st:id/et_ldap_login_password");
			el6.sendKeys("20091988Aa");
			MobileElement el7 = (MobileElement) driver.findElementById("com.buuuk.st:id/btn_ldap_login_continue");
			el7.click();
			
			// To verify Login
			MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
			el8.click();
			List<MobileElement> els3 = driver.findElementsById("com.buuuk.st:id/tv_login_name");
			if (els3.get(0).getText().equals("mohamedajkarali@gmail.com")) {
				System.out.println("User logged in successfully");
			} else {
				System.out.println("User login failed");
			}
			
			// Navigate to home
			MobileElement el9 = (MobileElement) driver.findElementById("com.buuuk.st:id/rl_home");
			el9.click();
			
			// Click on latest tab
			MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]/android.widget.LinearLayout/android.widget.TextView");
			el12.click();
			
			// Click on recent article in latest tab
			MobileElement el13 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout");
			el13.click();
			
			// Verify article
			List<MobileElement> els4 = driver.findElementsById("com.buuuk.st:id/article_headline");
			if (els4.size() > 0) {
				System.out.println("Article found");
			} else {
				System.out.println("Article not found");
			}
			
			// Verify article media
			List<MobileElement> els5 = driver.findElementsById("com.buuuk.st:id/article_image");
			if (els5.size() > 0) {
				System.out.println("Media found");
			} else {
				System.out.println("Media not found");
			}
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
 
}

