package RestAssured.APITesting;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;

public class POST_HashMap {

	public static void main(String[] args) {
		
		System.out.println("This is API Testing for POST Method in BBD format");
		
		Map<String,Object> requestParam = new HashMap<>();
		requestParam.put("email", "eve.holt@reqres.in");
		requestParam.put("password","pistol");
		requestParam.put("fname", "Johnny");
		requestParam.put("lname", "Bravo");
		requestParam.put("country", "Canada");
		requestParam.put("age", 28);
		
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
