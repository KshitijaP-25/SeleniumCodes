package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonListOfElements {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		try {
		    driver.findElement(By.xpath("//button[@alt='Continue shopping']")).click();
		}
		catch(Exception e){
			driver.findElement(By.xpath("//img[@alt='Refrigerators']")).click();
		}
		
	    List<WebElement> products =driver.findElements(By.xpath("//span[contains(text(),'Refrigerator')]"));
		System.out.println("All Refrigerator on Amazon Searchpage are:"+products.size());
		for(WebElement product : products) {
		String productName = product.getText();
		System.out.println(productName);
		
		} 
		
		Thread.sleep(2000);
		driver.close();
	}

}
