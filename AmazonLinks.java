package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLinks {
	//count of all links
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		try {
			driver.findElement(By.tagName("button")).click();
		}
		catch(Exception e) {
			System.out.println("Amazon Homepage is Opened..");
		}
	    List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println("All Links on Amazon Homepage are:"+links.size());
		for(WebElement link : links) {
		String Link = link.getDomAttribute("href");
		System.out.println(Link +" : "+link.getText());
		
		} 
		
		Thread.sleep(2000);
		driver.close();
	}

}
