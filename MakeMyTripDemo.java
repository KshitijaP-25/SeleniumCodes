package selenium.WebAssignment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripDemo {
	//Check-box, WindowHandles, Partial Screenshot
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("document.body.style.zoom='90%';");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("span[data-cy='tertiaryRowIcon_Gift Cards']")).click();
		Thread.sleep(2000);
		Object[] windowhandles = driver.getWindowHandles().toArray();
		driver.switchTo().window((String)windowhandles[1]);
		System.out.println("Gift Card Categories are:"); 
		Thread.sleep(2000);
		List<WebElement> category = driver.findElements(By.xpath("//p[@class='lato-bold cap-text append-bottom5 line-height18 cap-text']"));
		for(WebElement Categories : category) {
		System.out.println(Categories.getText());
	    }
		Thread.sleep(2000);
	    WebElement giftCardBanner = driver.findElement(By.xpath("//img[@data-cy='GiftCardBanner_480']"));
		File imageFile = giftCardBanner.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		String filePath = path+"\\target\\Screenshots\\";
		String timestamp = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss").format(new Date());
		FileUtils.copyFile(imageFile, new File(filePath + "GiftCard_"+timestamp+".jpeg"));
		System.out.println(timestamp);
		Thread.sleep(500);
		driver.switchTo().window((String)windowhandles[0]);
		Thread.sleep(2000);
		driver.quit();
	}
	 	
}
        
