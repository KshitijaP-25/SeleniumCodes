package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//a[@aria-label='Mobiles & Tablets']")).click();
		WebElement Oppo = driver.findElement(By.xpath("//div[@class='_6i1qKy' and contains(text(),'OPPO')]"));
		Thread.sleep(1000);
		Oppo.click();
		Thread.sleep(1000);
		WebElement startSlider = driver.findElement(By.xpath("//div[@class='iToJ4v Kaqq1s']"));
		WebElement endSlider = driver.findElement(By.xpath("//div[@class='iToJ4v D0puJn']"));
		
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.dragAndDropBy(startSlider, 50, 0).perform();
		Thread.sleep(1500);
		action.dragAndDropBy(endSlider, -50, 0).perform();
		Thread.sleep(2000);
		WebElement selectedRange = driver.findElement(By.xpath("//div[@class='_6tw8ju' and contains(text(),'₹')]"));
		System.out.println("Selected Price Range is: "+selectedRange.getText());
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1200);");
		//Finding BesterSeller Mobiles using xpath axes
		List<WebElement> BestSellers = driver.findElements(By.xpath("//div[@class='UzRoYO CmflSf']//parent::div//following-sibling::div[2]//div//div[@class='KzDlHZ']"));
		System.out.println("BestSeller Mobiles in Selected Price range are:");
		for(WebElement BestSeller : BestSellers) {
			System.out.println(BestSeller.getText());
		}
		
		Thread.sleep(3000);
		driver.close();
	}

}
