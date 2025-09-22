package RestAssured.APITesting;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;


public class POST_BDDFormat {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		System.out.println("This is API Testing for POST Method in BBD format");
		
		JSONObject requestParam = new JSONObject();
		requestParam.put("email", "eve.holt@reqres.in");
		requestParam.put("password","pistol");
		requestParam.put("fname", "Steffy");
		requestParam.put("lname", "Smith");
		requestParam.put("country", "USA");
		
		RestAssured.given()
	        .baseUri("https://reqres.in/api/users")          
	        .contentType(ContentType.JSON)
	        .body(requestParam.toString())
	        .header("x-api-key","reqres-free-v1")
        .when()
        	.post()
	    .then()
	        .log().all();
	}
}
