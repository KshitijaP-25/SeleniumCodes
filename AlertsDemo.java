package selenium.WebAssignment;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo {
	//Alerts
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
	
		driver.findElement(By.id("alertBox")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		
		driver.findElement(By.id("confirmBox")).click();
		Thread.sleep(2000);
		alert.dismiss();
		
		Thread.sleep(1000);
		driver.findElement(By.id("promptBox")).click();
		Thread.sleep(2000);
		alert.sendKeys("Good Evening");
		Thread.sleep(2000);
		System.out.println("Message in Alert is- "+alert.getText());
		alert.accept();
		Thread.sleep(2000);
		driver.close();
	}

}
