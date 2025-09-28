package RestAssured.APITesting;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import io.restassured.specification.RequestSpecification;


public class POST_RegisterUser {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		System.out.println("This is API Testing for POST Method");
		RestAssured.baseURI = "https://reqres.in/api/register";
		RequestSpecification https = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		requestParam.put("email", "eve.holt@reqres.in");
		requestParam.put("password","pistol");
		requestParam.put("fname", "John");
		requestParam.put("lname", "Terrence");
		
		https.header("Content-Type", "application/json");
		https.header("x-api-key","reqres-free-v1");
		https.body(requestParam.toJSONString()); 
		//Response response = https.request(Method.POST,"/api/register");
		Response response = https.post("/api/register"); 
		System.out.println("The status received: " + response.statusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
	}
 
}
