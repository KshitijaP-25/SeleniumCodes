package selenium.WebAssignment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadDemo {
	

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000);");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\sai\\Desktop\\BGV Authorization form V1.3.docx");
		Thread.sleep(1000);
		driver.findElement(By.id("fileSubmit")).click();
		jse.executeScript("window.scrollBy(0,300);");
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//li[@class='breadcrumb-item active']")).getText());
		System.out.println("File Name: "+driver.findElement(By.id("uploaded-files")).getText());
		Thread.sleep(2000);
		driver.close();
		
	}

}
