package selenium.WebAssignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DavitaTest1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.att.com/");
		
		driver.findElement(By.xpath("//a[@aria-label='Go to the internet page']")).click();
		Thread.sleep(600);
		driver.findElement(By.xpath("//button[@aria-label='See AT&T Fiber offer details']")).click();
		Thread.sleep(500);
		String ActualTitle = driver.findElement(By.xpath("//strong[text()='$34 price offer: Subject to change and may be discontinued at any time']")).getText();
		String ExpectedTitle = "$34 price offer: Subject to change and may be discontinued at any time";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Popup Title is Verified");
		Thread.sleep(1000);
		driver.close();
	 
	}

}
