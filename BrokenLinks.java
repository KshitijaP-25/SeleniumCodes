package selenium.WebAssignment;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BrokenLinks {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://amul.com/index.php");
		
	    List<WebElement> Links =driver.findElements(By.tagName("a"));
	    System.out.println("Total Links on Homepage are: "+Links.size());
	    int brokenCount = 0;
	    for(int i=0;i<Links.size();i++) {
	      WebElement Link = Links.get(i);
	      String Linktext = Link.getAttribute("href");
	    	if(Linktext==null || Linktext.isEmpty()) {
	    		System.out.println(Linktext+" -> URL is Empty");
	    	}
	    	try {
				URL url= new URL(Linktext);
		    	HttpURLConnection huc = (HttpURLConnection)(url.openConnection());
		    	huc.connect();
		    	if(huc.getResponseCode()==200) {
		    		System.out.println(url+" : url is working fine..."+huc.getResponseMessage()+", "+huc.getResponseCode());
		    	}
		    	else {
		    		System.err.println(url+" -> url is broken. "+huc.getResponseMessage()+", "+huc.getResponseCode());
		    		brokenCount++;
		    	}
	          }
	    	  catch(Exception e) {}
	    } 
	    	System.out.println("Total broken links: "+brokenCount);
	    
	    Thread.sleep(3000);
	    driver.close();

	}

}
