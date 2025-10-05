package selenium.WebAssignment;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DavitaTest2 {
	// PDF File Reading and Assertion
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 driver.manage().window().maximize();
		 driver.get("https://www.att.com/scmsassets/support/wireless/devices-working-on-att-network.pdf");
		 
		 try {
	            URL url = new URL("https://www.att.com/scmsassets/support/wireless/devices-working-on-att-network.pdf");
	            InputStream input = url.openStream();
	            PDDocument document = PDDocument.load(input);
	            //String content = new PDFTextStripper().getText(document);
	            //System.out.println("PDF Content:\n" + content);
	            int totalPages = document.getNumberOfPages();
	            System.out.println("Total pages in PDF: " + totalPages);

	            if (totalPages >= 5) {
	                // Extract only the 5th page
	                PDFTextStripper stripper = new PDFTextStripper();
	                stripper.setStartPage(5);
	                stripper.setEndPage(5);
	                String pageText = stripper.getText(document);
	                //System.out.println("Content of 5th Page:\n" + pageText);
	                String[] lines = pageText.split("\\r?\\n");
	                System.out.println("Microsoft Section lines from page 5:");
	                int start = (lines.length - 8);
	                for (int i = start; i < lines.length-3; i++) {
	                    System.out.println(lines[i]);
	                  }
	                Assert.assertTrue(pageText.contains("Microsoft"));
                    System.out.println("Assertion 1 Passed");
                    Assert.assertTrue(pageText.contains("Surface"));
                    System.out.println("Assertion 2 Passed"); 
                    Assert.assertTrue(pageText.contains("Lumia 640 XL"));
                    System.out.println("Assertion 3 Passed"); 
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		 Thread.sleep(4000);
		 driver.close();
	}
}
