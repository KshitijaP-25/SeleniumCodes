package selenium.WebAssignment;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GTagDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/coronavirus/country/india/");
		String GraphHeading = driver.findElement(By.xpath("//h3[text()='Total Coronavirus Cases in India']")).getText();
		System.out.println(GraphHeading);
		Thread.sleep(2000);
		List<WebElement> points = driver.findElements(By.xpath("(//*[local-name() ='g' and @class='highcharts-axis-labels highcharts-xaxis-labels'])[2]//*[name()='tspan']"));
		for(WebElement point : points) {
		System.out.println(point.getText());
		}
		
		System.out.println("Graph Points are:");
		Thread.sleep(2000);
		WebElement graphPoint = driver.findElement(By.xpath("//*[local-name()='g' and @class='highcharts-markers highcharts-series-0 highcharts-line-series highcharts-tracker']//*[name()='path'][2]"));
		Actions action = new Actions(driver);
		action.moveToElement(graphPoint).perform();
		System.out.println(graphPoint.getText());
		
		Thread.sleep(2000);
		//driver.close();
		
	}

}

