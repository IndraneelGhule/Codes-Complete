package F1;

import org.testng.annotations.Test;



public class C1 {
	
	@Test
	public void launchChrome() {
		
		String sysPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", 
				sysPath + "//resources//drivers//chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		System.out.println("**Path******: "+sysPath);
		
		
	}

}
