package Screens;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class ProductDisplayPageObject  extends CommonPage {
	
	

	By productDisplayConfrmation = By.xpath("//*[contains(@resource-id,'fragment_product_description_overview_fragment_image_view')]");
	
	By reviewTab = By.xpath("//*[@text='Reviews']");
	

	
	By sortPriceBtn = By.xpath("//*[contains(@resource-id,'fragment_product_description_other_sellers_sort_button')]");
	
	By selectSortType = By.xpath("//*[@text='Price - low to high']");
	
	By fetchThirdLowestPrice = By.xpath("(//*[contains(@resource-id,'other_sellers_list_item_best_price_value')])[3]");
	
	
	public ProductDisplayPageObject(AndroidDriver<WebElement> driver) throws Exception {
		super(driver);
		try {
			driver.findElement(productDisplayConfrmation);
		} catch (NoSuchElementException e) {
			Assert.fail("Element not found in the Product Display page");
		}
	}
	
	public ProductReviewPageObject clickReviewTab()
	{			
		driver.findElement(reviewTab).click();
		return new ProductReviewPageObject(driver);
	}	
	
	public static void usePerfectoScrollSwipeUp(AppiumDriver<WebElement> driver,String searchItem){
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("content", searchItem);
        params.put("scrolling", "scroll");
        //params.put("maxscroll", "10");
        params.put("next", "SWIPE_UP");
        driver.executeScript("mobile:text:find", params);
	}
	
	
	private void sortPriceBtnClick() throws Exception
	{
		scrollToText("Recommended");
		driver.findElement(sortPriceBtn).click();
	}	
	
	private void selectSortTypeClick() throws Exception
	{
		driver.findElement(selectSortType).click();
	}	
	
	private String fetchThirdLowestPriceText() throws Exception
	{
		String thirdLowestPrice=null;
		thirdLowestPrice=driver.findElement(fetchThirdLowestPrice).getText();		
		return thirdLowestPrice;
	}	
	
	public String sortAndSelectThirdLowVal() throws Exception{
		sortPriceBtnClick();
		selectSortTypeClick();
		scrollToText("Free shipping");
		return fetchThirdLowestPriceText();
		
	}
	
	
	private void scrollToText(String textContent)
	{
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("content", textContent);
        params.put("scrolling", "scroll");        
        //params.put("maxscroll", "10");
        params.put("next", "SWIPE_UP");
        driver.executeScript("mobile:text:find", params);
	}
}
