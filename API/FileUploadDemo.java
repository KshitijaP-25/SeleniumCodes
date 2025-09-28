package RestAssured.APITesting;
import java.io.File;
import java.io.FileNotFoundException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
public class FileUploadDemo {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("File Upload demo using Rest Assured");
		
		RestAssured.baseURI = "https://api.escuelajs.co/api/v1/files/upload";
		RequestSpecification req = RestAssured.given();
		
		File testfile = new File("C:\\Users\\sai\\Downloads\\TestFile for Rest.docx");
		req.multiPart("file",testfile);
		req.contentType("multipart/form-data");
		
		Response response = req.post();
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusLine());
		System.out.println(response.getStatusCode());
		//Query Request Specification
		QueryableRequestSpecification query = SpecificationQuerier.query(req);
		System.out.println("Content Type is: "+query.getContentType());
		System.out.println("Base URI is: "+query.getBaseUri());
	
	}

}
