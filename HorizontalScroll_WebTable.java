package selenium.WebAssignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HorizontalScroll_WebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/examples/basic_init/scroll_x.html");
		
		Thread.sleep(2000);
		WebElement target = driver.findElement(By.xpath("//a[@href='/faqs/index']"));
		//WebElement target1 = driver.findElement(By.cssSelector("#example > tbody > tr:nth-child(1) > td:nth-child(8)"));
		WebElement target2 = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td[9]"));
		
		Actions action = new Actions(driver);
		
		Thread.sleep(1000);
		action.scrollToElement(target).perform();
		System.out.println(target.getText());
		/*Thread.sleep(2000);
		action.scrollToElement(target1).perform();
		System.out.println(target1.getText()); */
		
		Thread.sleep(2000);
		action.scrollToElement(target2).perform();
		System.out.println(target2.getText());
		
		Thread.sleep(2000);
		driver.close();
		
	}

}

