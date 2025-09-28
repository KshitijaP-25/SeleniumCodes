package RestAssured.APITesting;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class QueryParamDemo {

	public static void main(String[] args) {
		System.out.println("This is query parameter demo");
		
		RestAssured.baseURI = "https://api.open-meteo.com/v1/forecast";
		RequestSpecification req = RestAssured.given();
		//Set Query Parameters
		req.queryParam("latitude", "52.52");
		req.queryParam("longitude", "13.45");
		
		Response response = req.get();
		System.out.println(response.prettyPrint());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		System.out.println(response.getStatusCode());
	
	}

}
