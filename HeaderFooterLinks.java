package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HeaderFooterLinks {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com");
		
		List<WebElement> options = driver.findElements(By.cssSelector(".accent-nav__content>ul>li"));
		System.out.println("Total options in the Header are: "+options.size());
		Thread.sleep(500);
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}	
		
		List<WebElement> links = driver.findElements(By.cssSelector(".container>div>ul>li>a"));
		System.err.println("Total Number of Footer Links are: "+links.size());
		Thread.sleep(500);
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText());
		}	
		driver.close();
	}
}

