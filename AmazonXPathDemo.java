package selenium.WebAssignment;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonXPathDemo {
	// XPath Axes examples
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		try {
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		catch(Exception e) {}
	    driver.findElement(By.xpath("//a[@aria-label='Cushion covers, bedsheets & more']")).click();
	    
	    //xpath for Bathroom Linen using text()
	    driver.findElement(By.xpath("//span[text()='Bathroom Linen']")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		//xpath for All items under Category using ancestor axis
		System.out.println("All items in Home & Kitchen Category are:");
		List<WebElement> items = driver.findElements(By.xpath("//span[text()='Bathroom Linen']//ancestor::ul[1]"));
		for(WebElement item : items) {
			System.out.println(item.getText());
		}
		
		//xpath for Home & Kitchen wrt Bathroom Linen using ancestor, preceding-sibling
		WebElement item1 = driver.findElement(By.xpath("//span[text()='Bathroom Linen']//ancestor::li[1]//preceding-sibling::li[2]"));
		System.out.println("Category is: "+item1.getText());
		item1.click();
		System.out.println("Home & Kitchen URL: "+driver.getCurrentUrl() );
		System.out.println("Title is- "+ driver.getTitle());
		Thread.sleep(1000);
		driver.navigate().back();
		
		//xpath for Home Furnishing wrt Bathroom Linen using ancestor, preceding-sibling
		WebElement heading = driver.findElement(By.xpath("//span[text()='Bathroom Linen']//ancestor::li[1]//preceding-sibling::li[1]"));
		System.out.println("Sub Category wrt to Bathroom Linen is: "+heading.getText());
		
		//xpath for Home Furnishing wrt Carpets & Rugs using ancestor, preceding-sibling
		WebElement heading1 = driver.findElement(By.xpath("//span[text()='Carpets & Rugs']/ancestor::li[1]/preceding-sibling::li[3]"));
		System.out.println("Sub Category wrt to Carpets & Rugs is: "+heading1.getText());
		driver.findElement(By.xpath("//span[text()='Carpets & Rugs']")).click();
		System.out.println("Current Webpage Title is - "+driver.getTitle());
		Thread.sleep(500);
		driver.navigate().back();
		
		//xpath for Diwan Cover Set wrt Cushions and Cushion Covers using ancestor, following-sibling
		WebElement Diwan = driver.findElement(By.xpath("//span[text()='Cushions & Cushion Covers']/ancestor::li/following-sibling::li[1]"));
		System.out.println(Diwan.getText());
		Diwan.click();
		driver.navigate().back();
		
		//xpath for Curtains & Accessories using child axis
		WebElement Curtains = driver.findElement(By.xpath("//ul[@aria-labelledby='n-title']//child::li[6]"));
		System.out.println("6th child element is: "+Curtains.getText());
		Thread.sleep(2000);
		driver.close();
		
	}

}
