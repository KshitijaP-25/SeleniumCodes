package RestAssured.APITesting;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GET_OjectList {

	public static void main(String[] args) {
		
		System.out.println("This is API Testing");
		RestAssured.baseURI = "https://api.restful-api.dev";
		RequestSpecification https = RestAssured.given();
		Response response = https.request(Method.GET,"/objects");
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
	}
	
}
