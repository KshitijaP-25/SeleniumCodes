package RestAssured.APITesting;
import io.restassured.RestAssured;

public class POST_String {

public static void main(String[] args) {
		
System.out.println("This is API Testing for POST Method in BBD format");
		
String requestParam = "{\"email\": \"nico@gmail.com\",\"password\":1234,\"name\": \"Nicolas\",\"avatar\": \"https://picsum.photos/800\",\"age\":\"30\"}";
		
RestAssured.given()
	        .baseUri("https://api.escuelajs.co/api/v1/users/")          
	        .header("Content-Type","application/json")
	        .body(requestParam)
        .when()
        	.post()
	    .then()
	        .log().all();
	}
}




