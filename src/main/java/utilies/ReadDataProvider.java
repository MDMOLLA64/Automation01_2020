package utilies;

import org.testng.annotations.DataProvider;

public class ReadDataProvider {
	
	@DataProvider(name="login")
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
}
