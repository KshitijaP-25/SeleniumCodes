package RestAssured.APITesting;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import io.restassured.specification.RequestSpecification;


public class POST_HashMap {

	public static void main(String[] args) {
		
		System.out.println("This is API Testing for POST Method using HashMap");
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
		RequestSpecification https = RestAssured.given();
		
		HashMap<String,Object> requestParam = new HashMap<>();
		requestParam.put("totalprice", 18.00);
		requestParam.put("depositpaid",true);
		requestParam.put("firstname", "Jimmy");
		requestParam.put("lastname", "Caron");
		requestParam.put("additionalneeds", "breakfast");
			HashMap<String,Object> date = new HashMap<>();
			date.put("checkin", "2024-05-18");
			date.put("checkout", "2024-05-24");
		requestParam.put("bookingdates", date);
		
		https.header("Content-Type", "application/json");
		https.body(requestParam); 
		
		Response response = https.post(); 
		System.out.println("The status received: " + response.statusLine());
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
	}
 
}
