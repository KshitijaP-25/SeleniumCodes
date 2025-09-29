package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ColourDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://readymag.com/");
		Thread.sleep(500);
		driver.findElement(By.id("CybotCookiebotDialogBodyButtonDecline")).click();
		List<WebElement> sections = driver.findElements(By.xpath("//div[@class='rmwidget widget-button']"));
		Actions action = new Actions(driver);
		System.out.println("Available sections are: "+sections.size()+"\n");
		for(WebElement section : sections) {
			action.moveToElement(section).perform();
			Thread.sleep(300);
			System.out.println(section.getText() + ": "+ section.getCssValue("color"));
			System.out.println(section.getCssValue("font-size")+", "+section.getCssValue("background-color")+", "+section.getCssValue("border"));
			System.out.println(" ");
		}	
		driver.close();
	}

}
