package selenium.WebAssignment;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleProductsDemo {
   //List of Google Product, fetching Favicon icon URL
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://about.google/products/");
		System.out.println("Webpage title is: "+driver.getTitle());
		
		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='ag-products-promo__marquee-content']//li//img"));
		System.out.println("Total Google Products are: "+products.size());
		for(WebElement product : products ) {
			String productName = product.getDomAttribute("alt");
			System.out.println(productName);
		}
		Thread.sleep(1000);
		driver.get("https://www.google.com/imghp?hl=en&tab=ri&authuser=0&ogbl");
		WebElement Favicon = driver.findElement(By.xpath("//link[@rel='icon']"));
		System.out.println("Favicon icon URL of Google: "+Favicon.getAttribute("href"));
		Thread.sleep(4000);
		driver.close();

	}

}
