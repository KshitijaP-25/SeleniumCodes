package selenium.WebAssignment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {
	//count of all links
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700);");
		
	    System.out.println("Focus shifted to Frame 1");
		driver.switchTo().frame("frm1");
		Thread.sleep(500);
	    WebElement dd1 = driver.findElement(By.id("selectnav1"));
	    dd1.click();
	    Select select1 = new Select(dd1);
	    Thread.sleep(1000);
	    select1.selectByValue("https://www.hyrtutorials.com/search/label/Java");
	    String option1 = select1.getFirstSelectedOption().getText();
	    System.out.println("Selected value from DD1 of Frame1: "+option1);
	    //Switching to Frame 2
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    Thread.sleep(1000);
	    jse.executeScript("window.scrollBy(0,800);");
	    System.out.println("-------------------------------------------------");
	    System.out.println("Focus shifted to Frame 2");
	    Thread.sleep(1000);
	    driver.switchTo().frame("frm2");
	    Thread.sleep(1000);
	    WebElement dd2 = driver.findElement(By.id("selectnav1"));
	    dd2.click();
	    Select select2 = new Select(dd2);
	    Thread.sleep(1000);
	    select2.selectByValue("https://www.hyrtutorials.com/p/testng-english.html");
	    String option2 = select2.getFirstSelectedOption().getText();
	    System.out.println("Selected value from DD2 of Frame2: "+option2);
	    Thread.sleep(1000);
		driver.findElement(By.linkText("click here")).click();
		System.out.println("Opened TestNG Tutorials in new tab");
		Thread.sleep(5000);
		//Switching to parent window
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
		
		//Switching to Frame 3
	    Thread.sleep(1000);
	    driver.switchTo().defaultContent();
	    Thread.sleep(1000);
	    jse.executeScript("window.scrollBy(0,1000);");
	    System.out.println("-------------------------------------------------");
	    System.out.println("Focus shifted to Frame 3");
	    Thread.sleep(1000);
	    driver.switchTo().frame("frm3");
	    Thread.sleep(1000);
	    driver.findElement(By.id("name")).sendKeys("Selenium Testing");
		System.out.println("Text entered in Frame 3 Textbox");
		
		Thread.sleep(4000);
		driver.quit();
	}

}

