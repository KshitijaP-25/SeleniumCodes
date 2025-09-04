package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest2 {
	//All images, count of all links, auto-refresh
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
	    List<WebElement> images =driver.findElements(By.tagName("img"));
		System.out.println("All image URLs on Flipkart Homepage are:"+images.size());
		for(WebElement image : images) {
		String imageLink = image.getDomAttribute("src");
		System.out.println(imageLink);
		} 
		
		driver.get(driver.getCurrentUrl());
		
		List<WebElement> urls = driver.findElements(By.tagName("a"));
		System.out.println("Total links on homepage: "+urls.size());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
