package JavaCodes;


public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println("Purmutation and Conbination");
		
		String str = "abc";
		PC(str, "");
	}
	
	public static void PC(String str, String result) {
		
		if(str.length()==0) {
			System.out.println(result);
		}
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			String currentStr = str.substring(0,i)+ str.substring(i+1);
			PC(currentStr, result+ch);
		}
		
	}
	
}
