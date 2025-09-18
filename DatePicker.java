package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tickets.paytm.com/international-flights/");
		
		driver.findElement(By.id("srcCode")).click();
		driver.findElement(By.id("text-box")).sendKeys("Pune");
		driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();
		Thread.sleep(500);
		driver.findElement(By.id("destCode")).click();
		driver.findElement(By.id("text-box")).sendKeys("Kochi");
		driver.findElement(By.xpath("//div[contains(text(),'COK')]")).click();
		Thread.sleep(500);
		driver.findElement(By.id("departureDate")).click();
		//Select 20th Oct 2025
		driver.findElement(By.xpath("(//table[@class='calendar'])[2]//tbody//tr[4]//td[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@id='flightSearch']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@aria-label='Toggle-Icon']")));
		driver.findElement(By.xpath("//label[@aria-label='Toggle-Icon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[(text()='Non-stop')]")).click();
		driver.findElement(By.xpath("//img[@alt='scroll-icon']")).click();
		Thread.sleep(500);
		System.out.println("Non-stop Flights from Pune to Kochi:");
		List<WebElement> flights = driver.findElements(By.xpath("//div[@class='w1u19']"));
		for(WebElement flight : flights) {
			System.out.println(flight.getText());
			System.out.println("-------------------------");
		}
		
	}
}
