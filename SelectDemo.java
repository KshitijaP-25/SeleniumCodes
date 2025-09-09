package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php?entry_point=login");
	
		WebElement monthDD = driver.findElement(By.xpath("//select[@aria-label='Month']"));
		monthDD.click();
		System.out.println("Months are as follows:");
		Select select1 = new Select(monthDD);
		System.out.println("First selected Month is: "+select1.getFirstSelectedOption().getText());
		Thread.sleep(500);
		select1.selectByValue("1");
		System.out.println("Later selected Month is: "+select1.getFirstSelectedOption().getText());
		List <WebElement> monthoptions = select1.getOptions();
		for(WebElement option : monthoptions) {
			System.out.println(option.getText());
		}
		
		WebElement yearDD = driver.findElement(By.xpath("//select[@aria-label='Year']"));
		yearDD.click();
		System.out.println("Years are as follows:");
		Select select2 = new Select(yearDD);
		System.out.println("First selected Year is: "+select2.getFirstSelectedOption().getText());
		Thread.sleep(500);
		select2.selectByVisibleText("2008");
		System.out.println("Later selected Year is: "+select2.getFirstSelectedOption().getText());
		List <WebElement> yearoptions = select2.getOptions();
		for(WebElement option : yearoptions) {
			System.out.println(option.getText());
		}
		driver.close();
	}

}

