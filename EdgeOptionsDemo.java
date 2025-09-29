package selenium.WebAssignment;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeOptionsDemo {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\sai\\Downloads\\msedgedriver.exe");
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--start-maximized");
		option.setAcceptInsecureCerts(true);
		WebDriver driver = new EdgeDriver(option);
		driver.get("https://www.flipkart.com/");
		
		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys("bluetooth earphones",Keys.ENTER);
		
		List<WebElement> earphones = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		for(WebElement earphone : earphones) {
			System.out.println(earphone.getText());
		}
		
		Thread.sleep(2000);
		driver.close();

	}

}
