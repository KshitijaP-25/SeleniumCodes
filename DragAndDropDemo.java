package selenium.WebAssignment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DragAndDropDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
	
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		Thread.sleep(300);
		action.dragAndDrop(source, target).build().perform();
		Thread.sleep(300);
		System.out.println(target.getText());
		
		Thread.sleep(300);
		driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");
		driver.findElement(By.xpath("//button[@id='nav-profile-tab'][1]")).click();
		WebElement Xaxis = driver.findElement(By.xpath("//div[@id='div_element']"));
		Thread.sleep(500);
		//Right scroll
		action.dragAndDropBy(Xaxis,300,0).build().perform();
		System.out.println("Right side scroll of " +Xaxis.getText());
		Thread.sleep(500);
		//Left scroll
		action.dragAndDropBy(Xaxis,-200,0).build().perform();
		System.out.println("Left side scroll of " +Xaxis.getText());
		
		WebElement Yaxis = driver.findElement(By.xpath("//div[@id='div_elementy']"));
		Thread.sleep(500);
		//Downward scroll
		action.dragAndDropBy(Yaxis,0,100).build().perform();
		System.out.println("Downward scroll of " +Yaxis.getText());
		Thread.sleep(500);
		//Upward scroll
		action.dragAndDropBy(Yaxis,0,-120).build().perform();
		System.out.println("Upward scroll of " +Yaxis.getText());
		
		Thread.sleep(800);
		driver.close();
	}

}
