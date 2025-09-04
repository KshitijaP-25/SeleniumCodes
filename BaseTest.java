package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

public static void main(String[] args) throws StaleElementReferenceException, NoSuchElementException, InterruptedException {
    //Browser Initialization with Google
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    driver.get("https://www.google.com/");
	    
	//Search for Flipkart in Google Searchbox
		WebElement searchField = driver.findElement(By.xpath("//textarea[@name=\"q\"]"));
		searchField.sendKeys("Flipkart");
	//Auto Suggestion list	
		List <WebElement> suggestions = driver.findElements(By.xpath("//ul[@role=\'listbox\']/li"));
		System.out.println("Total Suggestion Results are as follows: "+suggestions.size());
		for(WebElement list: suggestions) {
			System.out.println(list.getText());	
		 }
	//Click Enter to complete search	
		searchField.sendKeys(Keys.ENTER);
	// Check I'm not a Robot check-box if appears
		try{
			driver.findElement(By.xpath("//form[@action='index']")).click();
		}
		catch(NoSuchElementException e7) {
			System.out.println("No Captcha appeared.....");
		}	
		
	//All Search results for Flipkart	
		Thread.sleep(5000);
		List <WebElement> searchResults = driver.findElements(By.xpath("//a/h3"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a/h3")));
		System.out.println("Total Search Results are as follows: "+searchResults.size());
		for(WebElement link: searchResults) {
			System.out.println(link.getText());
		}
	//Click on first Flipkart link
        driver.findElement(By.cssSelector("a[href='https://www.flipkart.com/']")).click();
       
	//Click on TVs & Appliances on Flipkart homepage
		driver.findElement(By.xpath("//a[@aria-label='TVs & Appliances']")).click();
	//Hover over TVs & Appliances
		Actions action = new Actions(driver);
		WebElement tvElement = driver.findElement(By.xpath("//div[@id='container']/div/div[2]/div/div/span[2]"));
		action.moveToElement(tvElement).perform();
	//Click on Window ACs option	
		WebElement windowAcElement = driver.findElement(By.cssSelector("a[title='Window ACs']"));
		Thread.sleep(2000);
		action.moveToElement(windowAcElement).click().build().perform();
		Thread.sleep(5000);
	// Get CurrentPage title
		String currentPageTitle = driver.getTitle();
		System.out.println("Current Webpage Title is: "+currentPageTitle);
	//To verify Window ACs list is displayed	
		String windowACList = driver.findElement(By.xpath("//h1[@class='BUOuZu']")).getText();
		System.out.println("List Heading is: "+windowACList);
    //Select products of choice by Indices
		List<WebElement> addToCompareCheckbox = driver.findElements(By.xpath("//span[@class='Lni97G']"));
		int[] indicesToClick = {1,4,6,7,8};
		for(int index : indicesToClick) {
	    	addToCompareCheckbox.get(index).click();
	    	Thread.sleep(1000);
	       }
	//Error message after selecting last product  		
	   WebElement errMessage = driver.findElement(By.xpath("//div[@class='eIDgeN']"));
	   System.err.println("Warning Message is: "+errMessage.getText());
	//Click on Compare button   
	   driver.findElement(By.xpath("//a[@class='RCafFg -3yGLs']")).click();
	//Get all 4 products' names and prices   
	   List<WebElement> productNames = driver.findElements(By.xpath("//a[@class='NKi0M6']"));
	   List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));
	   System.out.println("Products' details Added to Compare:");
	    for(int i=0;i<productNames.size() && i<productPrices.size();i++) 	
	    System.out.println(productNames.get(i).getText()+" : "+productPrices.get(i).getText());
	    
	 //Add all 4 Products to the cart one after another
	   List <WebElement> addToCartButton = driver.findElements(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2 _4ltxGf']"));
	    for(int j=0;j<addToCartButton.size();j++){
	    	try {  
	    		Thread.sleep(1000);
		    	addToCartButton.get(j).click();
		    	Thread.sleep(2000);
				driver.navigate().back();
	    	   }
	    	
	    	catch(StaleElementReferenceException e1) {
		    	Thread.sleep(2000);	
		    	driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		    	Thread.sleep(2000);
			  	driver.navigate().back();
	    	}
	    	catch(NoSuchElementException e2) {
	    		Thread.sleep(2000);	
		    	driver.findElement(By.xpath("(//button[@class='QqFHMw vslbG+ In9uk2 _4ltxGf'])[3]")).click();
		    	Thread.sleep(2000);	
		    	driver.navigate().back();
	    	}
	      }   
	 //click on Cart icon
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@class='cjMG1q']")).click();
	    
	 //click on Enter Delivery Pin code button 
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@class='KlGwJl']")).click();
	 //Enter Pin code and click on Submit button
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@type='TEXT']")).sendKeys("411007");
	    driver.findElement(By.xpath("//div[@class='Ji2MFX']")).click();
	    
	 //Product Availability status
	    try {
	    String availabilityMessage = driver.findElement(By.xpath("//div[@class='Yxlaw0']")).getText();
	    System.out.println("Prodcut Availability Status: "+availabilityMessage);
	    List<WebElement> productDetails = driver.findElements(By.xpath("//div[@class='Yxlaw0']/parent::div//a"));
	    for(int k=0;k<productDetails.size();k++) 
	    System.out.println("Prodcut Unavailable: "+productDetails.get(k).getText());
	    }
	    catch(Exception e3){
	    	System.out.println("Products are available for given pincode.");
	    }
	   
	  //Change Pin code   
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x96Ssm']")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='Enter pincode']")).sendKeys("411057");
	    driver.findElement(By.xpath("//div[@class='Ji2MFX']")).click();
	    try {
	    	Thread.sleep(1000);
		    String availabilityMessage2 = driver.findElement(By.xpath("//div[@class='Yxlaw0']")).getText();
		    System.out.println("Prodcut Availability Status for Changed Pincode: "+availabilityMessage2);
		    Thread.sleep(3000);
		    List<WebElement> productDetails2 = driver.findElements(By.xpath("//div[@class='Yxlaw0']/parent::div//a"));
		    for(int l=0;l<productDetails2.size();l++) 
		    System.out.println("Prodcut Unavailable for Changed Pincode: "+productDetails2.get(l).getText());
		    }
		    catch(Exception e4){
		    	System.out.println("Products are available for given pincode after changing.");
		    }
	  //Close the browser window
	    Thread.sleep(3000);
	    driver.close();
	}
  }

 



