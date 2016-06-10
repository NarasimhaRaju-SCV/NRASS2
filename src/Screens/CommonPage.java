/**
 * 
 */
package Screens;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Narasimha Raju
 *
 */
public class CommonPage {

	protected final AndroidDriver<WebElement> driver;

	//constructor returns the driver instance
	public CommonPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

}
