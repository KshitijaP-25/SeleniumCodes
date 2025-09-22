package RestAssured.APITesting;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import io.restassured.specification.RequestSpecification;


public class PUT_UpdateAddedUser {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		System.out.println("This is API Testing for PUT Method");
		RestAssured.baseURI = "https://api.restful-api.dev/objects/ff8081819782e69e01997146e8207ab8";
		RequestSpecification https = RestAssured.given();
		
		JSONObject requestBody = new JSONObject();
	    requestBody.put("name", "Apple MacBook Pro 16");

	        JSONObject dataObject = new JSONObject();
	        dataObject.put("year", 2024);
	        dataObject.put("price", 1849.99);
	        dataObject.put("CPU model", "Intel Core i9");
	        dataObject.put("color", "black");
	        dataObject.put("Hard disk size", "1 TB");

	    requestBody.put("data", dataObject);
		
		https.header("Content-Type", "application/json");
		https.header("x-api-key","reqres-free-v1");
		https.body(requestBody.toJSONString()); 
		
		Response response = https.put(); 
		System.out.println("The status received: " + response.statusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
	}
 
}
