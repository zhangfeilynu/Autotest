package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;
import commonfunction.RandomValue;


public class Register extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		init("src/testdata/Register.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void reg(Document params) throws Exception {
    	
    	comfun.inputvalue("name","nickName",dr.readnodevalue(params,"reg","nickName"));
    	comfun.inputvalue("name","cellphone",RandomValue.getTel());
    	comfun.inputvalue("name","password",dr.readnodevalue(params,"reg","password"));
    	comfun.inputvalue("name","imgVerifyCode",dr.readnodevalue(params,"reg","imgVerifyCode"));
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[4]/div/div[2]/div/button");
    	comfun.inputvalue("name","verificationCode",dr.readnodevalue(params,"reg","verificationCode"));
    	comfun.clickitem("classname","button-block");
    	Thread.sleep(3000);
    	comfun.checkequal(CommonFunctions.driver.getCurrentUrl(),dr.readnodevalue(params,"reg","checkpoint1"));
    
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	comfun.teardown();
    }

}
