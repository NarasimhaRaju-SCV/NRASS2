package Screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeScreenPageObject extends CommonPage {
	
	By homesScreenLoadChkImage = By.xpath("//*[contains(@resource-id,'/fragment_picture_image')]");
	By homeSearchBtn = By.xpath("//*[contains(@resource-id,'menu')]");   //menu_home_search
	By homeSearchTextBox = By.xpath("//*[contains(@resource-id,'search_query')]");
	By selectFirstDisplayedProduct = By.xpath("(//*[contains(@resource-id,'subcategory_list_page_listview_item_trending_title')])[1]");
	
	public HomeScreenPageObject(AndroidDriver<WebElement> driver) {
		super(driver);
		try {
			driver.findElement(homeSearchBtn);
		} catch (NoSuchElementException e) {
			Assert.fail("Home Screen Page did not get displayed");
		}
	}
	
	private void clickHomeSearchBtn() throws Exception
	{
		driver.findElement(homeSearchBtn).click();
		
	}
	
	private void setDataHomeSearchTextBox(String searchText) throws Exception
	{
		driver.findElement(homeSearchTextBox).sendKeys(searchText);		
		driver.pressKeyCode(AndroidKeyCode.ENTER);		
	}
	
	private ProductDisplayPageObject selectFirstDisplayedProductClick() throws Exception
	{
		driver.findElement(selectFirstDisplayedProduct).click();
		return new ProductDisplayPageObject(driver);
	}
	
	public ProductDisplayPageObject searchAndSelectDevice(String deviceName) throws Exception{
		clickHomeSearchBtn();
		setDataHomeSearchTextBox(deviceName);
		return this.selectFirstDisplayedProductClick();
	}
	
	
	
}
