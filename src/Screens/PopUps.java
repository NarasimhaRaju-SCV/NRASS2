package Screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class PopUps extends CommonPage {
	
	By sysAlertTitle = By.xpath("//*[@resource-id='android:id/alertTitle']");
	By sysAlertOkBtn = By.xpath("//*[@resource-id='android:id/button1']");
	By sysAlertBackBtn = By.xpath("//*[@resource-id='android:id/up']");
	By nextBtn = By.xpath("//*[contains(@resource-id,'id/enable_button_text')]");
	By skipBtn = By.xpath("//*[@text='SKIP »']");
	By mobTabTextLink = By.xpath("//*[contains(@text,'Mobile, Tablets & Accessories')]");
	

	public PopUps(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	private void acceptSystemAlert()
	{
		try{
			driver.findElement(sysAlertTitle);	
			driver.findElement(sysAlertOkBtn).click();
			driver.findElement(sysAlertBackBtn).click();
		}catch(Exception e){			
		}
	}
	
	private void clickNextAndSkipBtn()
	{	
		try{
			driver.findElement(nextBtn).click();
			Thread.sleep(1000);
			driver.findElement(nextBtn).click();
			driver.findElement(skipBtn).click();
		}catch(Exception e){			
		}
	}	
	
	private void clickMobTabTextLink()
	{
		try{
			driver.findElement(mobTabTextLink).click();			
		}catch(Exception e){			
		}		
	}	
	
	public HomeScreenPageObject checkForPopUp(){
		//acceptSystemAlert();
		clickNextAndSkipBtn();
		clickMobTabTextLink();
		return new HomeScreenPageObject(driver);		
	}
}
