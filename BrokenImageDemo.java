package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImageDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		
	    List<WebElement> images =driver.findElements(By.tagName("img"));
	    System.out.println("Total Images on Homepage are: "+images.size());
	    for(WebElement image : images)
		if(image.getAttribute("naturalWidth").equals("0")) {
			System.out.println(image.getAttribute("src")+": This Image is Broken : "+image.getAttribute("naturalWidth"));
		}
		else {
			System.out.println(image.getAttribute("src")+" ---> Image is not Broken"+" : "+image.getAttribute("naturalWidth"));
		}

	}

}
