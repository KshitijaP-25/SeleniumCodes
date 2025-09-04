package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AadharDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://uidai.gov.in/");
		Thread.sleep(2000);
		List<WebElement> languages = driver.findElements(By.xpath("//button[@type='button']"));
		Actions action = new Actions(driver);
		System.out.println("Available languages are:"+languages.size());
		for(WebElement lang : languages) {
			action.moveToElement(lang).perform();
			Thread.sleep(300);
			System.out.println(lang.getText() + " : "+lang.getAccessibleName());
		}	 
		driver.close();
	}

}
