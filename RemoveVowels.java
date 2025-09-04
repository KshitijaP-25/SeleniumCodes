package selenium.WebAssignment;


public class RemoveVowels {
  public static void main(String[] args)  {
	
	 String str = "I live in Amravati, Maharashtra, India, Asia";
     System.out.println("Given String is:"+str);
     removeVowels(str);
     
  }

  public static String removeVowels(String s){
	  String res = s.replaceAll("[aeiouAEIOU]","");
	  System.out.println("Modified String: "+res);
	  return res;
	}
}
