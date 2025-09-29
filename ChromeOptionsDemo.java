package selenium.WebAssignment;
import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsDemo {

	public static void main(String[] args) throws InterruptedException {
		//Disable Infobar, incognito mode
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation","disable-infobar"));
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
		
		WebElement E=driver.findElement(By.id("identifierId"));
		E.sendKeys("ABC Testing");
		System.out.println(E.getAttribute("value"));
		
		Thread.sleep(2000);
		driver.close();
	}
}
