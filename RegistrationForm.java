package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationForm {
	

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		
		driver.findElement(By.id("name")).sendKeys("Rajat");
		driver.findElement(By.name("email")).sendKeys("rajatkumar@yahoo.com");
		driver.findElement(By.id("gender")).click();
		driver.findElement(By.name("mobile")).sendKeys("8978563420");
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("24-09-1998");
		driver.findElement(By.id("subjects")).sendKeys("General Science");
		List<WebElement> hobbies = driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> hobbiesName = driver.findElements(By.xpath("//label[@class='col-form-label']"));
		System.out.println("Student's hobbies are:");
		Thread.sleep(500);
		for(int i=1;i<3;i++) {
			hobbies.get(i).click();
			Thread.sleep(200);
			System.out.println(hobbiesName.get(i).getText());
		}
		Thread.sleep(200);
		driver.findElement(By.id("picture")).sendKeys("C:\\Users\\sai\\Downloads\\HRSS Confirmation.png");
		driver.findElement(By.xpath("//textarea[@name='picture']")).sendKeys("Sector 14,Gokuldham Society, Agra");
		
		WebElement state = driver.findElement(By.id("state"));
		WebElement city = driver.findElement(By.id("city"));
		
		Select select1 = new Select (state);
		Select select2 = new Select(city);
		select1.selectByValue("Uttar Pradesh");
		Thread.sleep(300);
		select2.selectByVisibleText("Agra");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
	}

}
