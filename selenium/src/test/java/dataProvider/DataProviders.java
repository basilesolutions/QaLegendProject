package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="InvalidUserCredentials")

	public Object[][] verifyUserCredentialsData() {
		
		Object[][] data=new Object[3][2];
		data[0][0]="basil3@ariesesolutions.com";
		data[0][1]="123456";
		
		data[1][0]="test@ariesesolutions.com";
		data[1][1]="123456";
		
		data[2][0]="basil@ariesesolutions.com";
		data[2][1]="12345678";
		
		return data;
		
		
	}	

}
