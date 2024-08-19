package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="invalidData")
	
	public Object[][] verifyUserData(){
		Object[][] datas= new Object[3][2];
		datas[0][0]="basil";
		datas[0][1]="123456";
		
		datas[1][0]="test";
		datas[1][1]="123456";
		
		datas[2][0]="jordan";
		datas[2][1]="12345678";
		return datas;
		
	}
	

}
