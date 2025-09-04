package selenium.WebAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileDemo {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//Read data from Config file
		String path1 = "D:\\Goldy\\Selenium Practice\\WebAssignment\\src\\test\\Config.properties";
		File file1 = new File(path1);
		FileInputStream fis = new FileInputStream(file1);
		
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("Browser"));
		System.out.println(prop.getProperty("URL"));
		System.out.println(prop.getProperty("App"));
		System.out.println(prop.getProperty("Env"));
		System.out.println(prop.getProperty("LocalURL"));
		
		//Write data into Config file
		String path2 = "D:\\Goldy\\Selenium Practice\\WebAssignment\\src\\test\\Config2.properties";
		File file2 = new File(path2);
		FileOutputStream fos = new FileOutputStream(file2);
		
		Properties properties = new Properties();
		properties.setProperty("User", "LoggedtUser");
		properties.setProperty("Suite", "Smoke");
		properties.setProperty("URL", "https://www.makemytrip.com/");
		properties.setProperty("Application", "Make My Trip");
		properties.setProperty("Version", "Beta");
		properties.store(fos, path2);
		
	}

}
