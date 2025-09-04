package selenium.WebAssignment;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class DemoTest3 {
	//Checkbox Flipkart Bedsheets, Full Page screenshot with ASHOT
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		//driver.findElement(By.xpath("//div[@class='_1wE2Px'][2]")).click();
		Thread.sleep(1000);
		WebElement homeFurniture = driver.findElement(By.xpath("//*[@aria-label='Home & Furniture']"));
		action.moveToElement(homeFurniture).perform();
		Thread.sleep(500);
		WebElement bedsheets = driver.findElement(By.xpath("//a[text()='Bedsheets']"));
		action.moveToElement(bedsheets).click().build().perform();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200);");
		Thread.sleep(2000);
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='XqNaEv']"));
	    for(int i=0;i<2;i++) {
	    	checkboxes.get(i).click();
	    	Thread.sleep(2000);
	    }
	    driver.findElement(By.xpath("//div[@class='sHCOk2']/div[2]")).click();
	    String timestamp = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss").format(new Date());
	    Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    ImageIO.write(s.getImage(),"PNG",new File ("FlipkartFullPage_"+timestamp+".png"));
	    
	    driver.close();
	}

}
