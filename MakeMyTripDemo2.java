package selenium.WebAssignment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripDemo2 {
	//Search Flight , Full Screenshot
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='lbl_input appendBottom5']")));
		driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		WebElement Class = driver.findElement(By.xpath("//li[@data-cy='travelClass-1']"));		
		System.out.println("Travel class is: "+Class.getText());	
		Class.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("document.body.style.zoom='90%';");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileTarget = "D:\\Goldy\\Selenium Practice\\WebAssignment\\target\\Screenshots\\";
		FileUtils.copyFile(srcFile, new File(fileTarget+"MMTResult_"+timestamp()+".jpeg"));
		Thread.sleep(2000);
		driver.close();
	 }
	    public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
	   }
}


