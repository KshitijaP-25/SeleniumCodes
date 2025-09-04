package selenium.WebAssignment;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class EdgeDemo {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//Edge Zoom-in, zoom-out
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in/");
		System.out.println("Edge browser is launched...");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.body.style.zoom='150%';");
		Thread.sleep(2000);
		jse.executeScript("document.body.style.zoom='50%';");
		Thread.sleep(2000);
		jse.executeScript("document.body.style.zoom='100%';");
		
		List<WebElement> cities = driver.findElements(By.xpath("//div[@class='swiper-slide']"));
		System.out.println("Available Cities are:");
		for(WebElement city : cities) {
		 System.out.println(city.getText());
		}
	    driver.close();
	}

}
