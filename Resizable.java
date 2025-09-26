package selenium.WebAssignment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {
	

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable/");
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement Point = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
		WebElement Textbox = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-resizable']"));
		System.out.println("Original Location of Textbox1:"+Point.getLocation());
		System.out.println("X point of Textbox1:"+Point.getLocation().getX());
		System.out.println("Y point of Textbox1:"+Point.getLocation().getY());
		System.out.println("Original Size of Textbox:"+Textbox.getSize());
		System.out.println("Height of Textbox: "+Textbox.getSize().getHeight());
		System.out.println("Width of Textbox: "+Textbox.getSize().getWidth());
		System.out.println("--------------------------------------------------------------------");
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(Point, 152, 72).perform();
		System.out.println("New Location of Textbox1:"+Point.getLocation());
		System.out.println("New X point of Textbox1:"+Point.getLocation().getX());
		System.out.println("New Y point of Textbox1:"+Point.getLocation().getY());
		System.out.println("New Size of Textbox:"+Textbox.getSize());
		System.out.println("New Height of Textbox: "+Textbox.getSize().getHeight());
		System.out.println("New Width of Textbox: "+Textbox.getSize().getWidth());
		Thread.sleep(2000);
		driver.close();
	}

}
