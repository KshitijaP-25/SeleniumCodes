package selenium.WebAssignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {
	//Scroll, Select drop down, Bootstrap menu, getting tool-tip & text in tags, Actions mouse hover

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//a[@aria-label='Mobiles & Tablets']")).click();
		WebElement Electronics = driver.findElement(By.xpath("//span[@class='TSD49J'][1]"));
		action.moveToElement(Electronics).perform();
		Thread.sleep(1000);
		WebElement Oppo = driver.findElement(By.xpath("//a[@title='OPPO']"));
		action.moveToElement(Oppo).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='QqFHMw M5XAsp'])[1]")).click();
		
		System.out.println(driver.getTitle());
		WebElement logo = driver.findElement(By.className("W5mR4e"));
		System.out.println("Logo tooltip is: "+logo.getDomAttribute("title"));
		Thread.sleep(3000);
		WebElement textBetweenTags = driver.findElement(By.className("CDJO0-"));
		System.out.println("Text between tags is: "+textBetweenTags.getText());
		
		List<WebElement> bestSellerPhones = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		System.out.println("Popular OPPO Mobiles are: ");
		for(int i=0;i<bestSellerPhones.size();i++) {
		String PhoneName = bestSellerPhones.get(i).getText();
		 if(PhoneName.contains("OPPO")) {	
			 System.out.println(PhoneName);
		 }
		}
		
		WebElement maxPrice = driver.findElement(By.xpath("(//select[@class='Gn+jFg'])[2]"));
		Select select = new Select(maxPrice);
		select.selectByValue("20000");
		Thread.sleep(1000);
		System.out.println("Max Price for Mobile is: "+select.getFirstSelectedOption().getText());
		System.out.println("Is dropdown multiselect? "+select.isMultiple());
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,7000);");
		List<WebElement> footerLinks =  driver.findElements(By.cssSelector(".bowO0w>a"));
		System.out.println("Total Footer Links are: "+footerLinks.size());
		for(int j=0;j<footerLinks.size();j++) {
			System.out.println(footerLinks.get(j).getText());
		}
	  
		WebElement moreOption = driver.findElement(By.className("_3ZeUN+"));
		action.moveToElement(moreOption).perform();
		List<WebElement> moreOptionMenu = driver.findElements(By.className("XGZdnG"));
		System.out.println("More Option's Menu items are: ");
		for(int k=0;k<moreOptionMenu.size();k++) {
			System.out.println(moreOptionMenu.get(k).getText());
		}
		
		Thread.sleep(2000);
		driver.close();
	}

}
