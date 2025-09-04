package selenium.WebAssignment;
import java.io.File;
import java.io.IOException;


public class FileCreateDemo {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		File folder1= new File("Folder3");
		folder1.mkdir();
		System.out.println("New folder is created in workspace 1.");
		File file1 = new File("Folder1","File5.xlsx");
		file1.createNewFile();
		System.out.println("New file is created in workspace 1.");
		//file1.delete();
	}

}
