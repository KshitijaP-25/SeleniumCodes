package selenium.WebAssignment;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class GraphDemo {

public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver =  new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.worldometers.info/coronavirus/country/india/");
	
	String GraphHeading = driver.findElement(By.xpath("//h3[text()='Total Coronavirus Cases in India']")).getText();
	
	List<WebElement> points = driver.findElements(By.xpath("(//*[local-name() ='g' and @class='highcharts-axis-labels highcharts-xaxis-labels'])[2]//*[name()='tspan']"));
		System.out.println(GraphHeading +": "+points.size());
		for(WebElement point : points) {
			  System.out.println(point.getText());
			}
		Thread.sleep(1000);
	
	List<WebElement> graphPoints = driver.findElements(By.xpath("//div[@id='coronavirus-cases-linear']//*[@class='highcharts-grid highcharts-xaxis-grid']//*[name()='path']"));
	System.out.println("Total Graph Points are: "+graphPoints.size());
	String textXPath ="//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']";
	Actions action = new Actions(driver);
		for(WebElement graphPoint : graphPoints) {
			action.moveToElement(graphPoint).perform();
			Thread.sleep(200);
			try{
				System.out.println(driver.findElement(By.xpath(textXPath)).getText());	
			}
			catch(Exception e) {}
		}
		
	//System.out.println(driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']")).getText());	
		
   }
}
		
		
	