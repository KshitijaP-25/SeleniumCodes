package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonXPathDemo2 {
	//XPath using starts-with option
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobiles 5g",Keys.ENTER);
		
	    List<WebElement> mobiles =driver.findElements(By.xpath("//h2[starts-with(@aria-label,'Samsung')]"));
		System.out.println("All Samsung Mobiles  are:"+mobiles.size());
		for(WebElement mobile : mobiles) {
		System.out.println(mobile.getText());
		} 
		
		//Xpath using contains option
	    List<WebElement> mobiles1 =driver.findElements(By.xpath("//span[contains(text(),'Redmi')]"));
		System.out.println("All Redmi Mobiles are:"+mobiles1.size());
		for(WebElement mobile : mobiles1) {
		System.out.println(mobile.getText());
		} 
		Thread.sleep(2000);
		driver.close();
	}

}
