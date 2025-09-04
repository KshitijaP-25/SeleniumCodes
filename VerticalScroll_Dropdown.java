package selenium.WebAssignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerticalScroll_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@data-cy='MobileCodeDropDown_60']")).click();
		WebElement target1 = driver.findElement(By.xpath("(//span[@class='lightGreyText pushRight phoneCode'])[57]"));
		WebElement target2 = driver.findElement(By.xpath("(//div[@class='li makeFlex hrtlCenter font12'])[100]"));
		WebElement target3 = driver.findElement(By.xpath("(//div[@class='li makeFlex hrtlCenter font12'])[111]"));
		
		Actions action = new Actions(driver);
		action.scrollToElement(target1).perform();
		System.out.println(target1.getText());
		Thread.sleep(2000);
		action.scrollToElement(target2).perform();
		System.out.println(target2.getText());
		Thread.sleep(2000);
		action.scrollToElement(target3).perform();
		System.out.println(target3.getText());
		
		Thread.sleep(2000);
		driver.close();
		
	}
}
