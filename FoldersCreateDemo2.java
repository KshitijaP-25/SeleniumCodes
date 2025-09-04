package selenium.WebAssignment;
import java.io.File;
import java.io.IOException;


public class FoldersCreateDemo2 {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		String folderNames = "Folder2/Subfolder/Childfolder3";
		File folder2= new File(folderNames);
		folder2.mkdirs();
		System.out.println("Nested folders are created in workspace 1.");
		
	}

}
