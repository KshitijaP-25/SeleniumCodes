package RestAssured.APITesting;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GET_SingleObject {

	public static void main(String[] args) {
		
		System.out.println("This is API Testing for GET method with Single object");
		RestAssured.baseURI = "https://api.restful-api.dev/objects";
		RequestSpecification https = RestAssured.given();
		Response response = https.get("/7");
		System.out.println("The status received: "+response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
	}
 
}
