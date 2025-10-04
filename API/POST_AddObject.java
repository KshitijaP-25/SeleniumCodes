package RestAssured.APITesting;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import io.restassured.specification.RequestSpecification;


public class POST_AddUser {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		System.out.println("This is API Testing for POST Method - Add Object");
		
		RestAssured.baseURI = "https://api.restful-api.dev/objects";
		RequestSpecification https = RestAssured.given();
		//Nested JSON Object
		 JSONObject requestBody = new JSONObject();
	     requestBody.put("name", "Apple MacBook Pro 16");

	        JSONObject dataObject = new JSONObject();
	        dataObject.put("year", 2019);
	        dataObject.put("price", 1849.99);
	        dataObject.put("CPU model", "Intel Core i9");
	        dataObject.put("color", "silver");
	        dataObject.put("Hard disk size", "1 TB");

	     requestBody.put("data", dataObject);
		
		https.header("Content-Type", "application/json");
		https.header("x-api-key","reqres-free-v1");
		https.body(requestBody.toJSONString()); 
		
		Response response = https.post(); 
		System.out.println("The status received: " + response.statusLine());
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
	}
 
}


