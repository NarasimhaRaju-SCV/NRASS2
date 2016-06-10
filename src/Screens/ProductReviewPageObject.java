package Screens;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;


public class ProductReviewPageObject extends CommonPage {
	
	
	By userReviewNumberText = By.xpath("(//*[contains(@resource-id,'id/fragment_user_reviews_list_rating')])[2]");
	
	By pricesTab = By.xpath("//*[@text='Prices']");
	
	public ProductReviewPageObject(AndroidDriver<WebElement> driver) {
		super(driver);
		try {
			driver.findElement(userReviewNumberText);
			} catch (NoSuchElementException e) {
				Assert.fail("Element not found in the Product review page");
			}
	}
	

	public String userReviewNumberTextGetText() throws Exception
	{
		String reviewRating = null;
		reviewRating=driver.findElement(userReviewNumberText).getAttribute("text");//getText();				
		return reviewRating;
		
	}	
	
	public ProductDisplayPageObject clickPricesTab() throws Exception
	{	
		driver.findElement(pricesTab).click();
		return new ProductDisplayPageObject(driver);
	}	
	
	
}
