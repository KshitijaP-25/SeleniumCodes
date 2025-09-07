package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindowHandles {
	//Multiple Windows handling and switching between the tabs
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
	    driver.findElement(By.name("q")).sendKeys("laptops i7",Keys.ENTER);
	    
	    int[] indicesToClick = {0,1,3,6};
	    List<WebElement> laptops = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
	    System.out.println("Laptops selected to compare:");
	    //Parent window
	    String parentWindow = driver.getWindowHandle();
	    //Open multiple windows
	    for(int index : indicesToClick) {
	    	Thread.sleep(2000);
	    	laptops.get(index).click();
	    	System.out.println(laptops.get(index).getText());
	    	Thread.sleep(1500);
	    	driver.switchTo().window(parentWindow);
	    }
	    //Get All Open windows
	    Object[] windowHandles = driver.getWindowHandles().toArray();
		System.out.println("Total Open windows: "+windowHandles.length);
		
	    Set<String> windows = driver.getWindowHandles();
	    System.out.println("All WindowHandles are:"+windows.size());
	    for(String window : windows) {
	    	System.out.println(window);
	    }
	    //Switch to 1st child window
		Thread.sleep(2000);
		driver.switchTo().window((String)windowHandles[1]);
		System.out.println("Current Window: "+(String)windowHandles[1]);
		System.out.println(driver.findElement(By.className("VU-ZEz")).getText());
		Actions action = new Actions(driver);
		List<WebElement> productImages = driver.findElements(By.xpath("//div[@class='Pz+aTd']"));
		for(WebElement image : productImages) {
			action.moveToElement(image).perform();
			Thread.sleep(800);
		}
		
		//Switch to 2nd child window
		driver.switchTo().window((String)windowHandles[2]);
		System.out.println("Current Window: "+(String)windowHandles[2]);
		System.out.println(driver.findElement(By.className("VU-ZEz")).getText());
		
		Thread.sleep(4000);
		driver.quit();
	}

}

