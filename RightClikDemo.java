package selenium.WebAssignment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class RightClikDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println("Default Window size: "+driver.manage().window().getSize());
		driver.manage().window().maximize();
		System.out.println("Maximized Window size: "+driver.manage().window().getSize());
		driver.get("https://www.flipkart.com/");
		
		WebElement source = driver.findElement(By.xpath("//img[@alt='Fashion']"));
		
		Actions action = new Actions(driver);
		Thread.sleep(200);
		action.contextClick(source).perform();
		System.out.println(source.getDomAttribute("alt"));
		
		//WebElement space = driver.findElement(By.xpath("//div[@class='_2NhoPJ']"));
		Thread.sleep(800);
		WebElement banner = driver.findElement(By.xpath("(//img[@alt='Image'])[2]"));
		action.doubleClick(banner).perform();
		
		Thread.sleep(4000);
		driver.close();
	}

}
