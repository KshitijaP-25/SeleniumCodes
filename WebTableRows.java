package selenium.WebAssignment;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableRows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/india-population/");
		
		WebElement TableHeading = driver.findElement(By.xpath("//h2[text()='Population of India (2025 and historical)']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",TableHeading);
		
		System.out.println("Table Heading-> "+TableHeading.getText());
		Thread.sleep(1000);
		List<WebElement> Rows = driver.findElements(By.xpath("(//table[@class='datatable w-full border border-zinc-200 datatable-table'])[1]//tbody//tr"));
		System.out.println("Total Rows are "+Rows.size()+" and All Rows data are:");
		
		for(WebElement Row : Rows) {
		  System.out.println(Row.getText()); 
		}
		
		Thread.sleep(3000);
		driver.close();
	}
		
}
