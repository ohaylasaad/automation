package booking.automationtask;

import static org.testng.Assert.fail;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TestNGBooking extends BaseTest {

	String hotelName;

	@Test(priority = 0)
	public void selectDateAndSearch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// type Distination

		WebElement distination = driver.findElement(By.id("ss"));
		
		distination.sendKeys("Riyadh, Riyadh Province, Saudi Arabia");

		// wait autocomplete search and select

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']/li[1]")));
		} catch (Exception e) {
			fail("failed to found first element on automcomplete");
		}

		driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();

	

		

		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//table[@class='bui-calendar__dates']/tbody//span[.='1'])[1]")));
		} catch (Exception e) {
			fail("failed to find check-in date");
		}

		// click from date "1 of the month"
		driver.findElement(By.xpath("//table[@class='bui-calendar__dates']/tbody/tr[1]/td[1]//span[.='1']")).click();

		// click to date "7 of the month"
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//table[@class='bui-calendar__dates']/tbody//td[@class='bui-calendar__date']//span[.='7'])[1]")));
			
		} catch (Exception e) {
			fail("failed to find check-in date");
		}

		// click from date "today"
		
		driver.findElement(By.xpath("(//table[@class='bui-calendar__dates']/tbody//td[@class='bui-calendar__date']//span[.='7'])[1]")).click();
		// click on search button
		WebElement search = driver.findElement(By.xpath("//form[@id='frm']//button[@type='submit']"));
		search.click();

	}


	@Test(priority = 2)
	public void getHotelNamepriceandimage() {
		// Get  Hotel Name and rating 
		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[@class='sr-hotel__title-wrap'])")));	
			} catch (Exception e) {
			fail("Fail to load search result");
		}

		
	
		List<WebElement> Names = driver.findElements(By.xpath("//a[@class='js-sr-hotel-link hotel_name_link url']"));
		
		 List<WebElement> ratings = driver.findElements(By.xpath("//div[@class='bui-review-score__title']"));		
		
		            System.out.println("The number of Hotels is " + Names.size());
		            for (int i=1; i<=5; i++)
		            { 
		                
		            	Names = driver.findElements(By.xpath("//a[@class='js-sr-hotel-link hotel_name_link url']"));
		            	ratings = driver.findElements(By.xpath("//div[@class='bui-review-score__title']"));

		            	String hotelname = Names.get(i-1).getText().trim();
		            	String rate = ratings.get(i-1).getText();
		            	System.out.println(hotelname.replace("Opens in new window","")+rate);
		         	
		            	
		            	
		            }
		            
		           
		         	
		                
		               
		            } 
		            
		
	
		
		
	
	


}

