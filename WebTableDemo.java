package selenium.WebAssignment;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo {

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
		List<WebElement> ColumnNames = driver.findElements(By.xpath("(//*[@class='datatable w-full border border-zinc-200 datatable-table'])[1]//tr[1]//th"));
		List<WebElement> CurrentYearData = driver.findElements(By.xpath("(//*[@class='datatable w-full border border-zinc-200 datatable-table'])[1]//tbody//tr[@data-index=0]//td"));
		System.out.println("Total Records are-> "+CurrentYearData.size());
		
		for(int i=0;i<ColumnNames.size() && i<CurrentYearData.size();i++) {
		  System.out.println(ColumnNames.get(i).getText()+" : "+CurrentYearData.get(i).getText()); 
		}
		
		Thread.sleep(2000);
		driver.close();
	}
		
}
