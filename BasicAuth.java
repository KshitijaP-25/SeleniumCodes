package selenium.WebAssignment;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuth {
   //Basic Auth, Zoom In, Zoom Out
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("document.body.style.zoom='200%';");
		Thread.sleep(2000);
		jse.executeScript("document.body.style.zoom='50%';");
		Thread.sleep(2000);
		jse.executeScript("document.body.style.zoom='100%';");
		Thread.sleep(2000);
		
		Dimension dm = new Dimension(1000,700);
	    driver.manage().window().setSize(dm);
	    Thread.sleep(2000);
		driver.close();
	}

}
