package testcases;

import org.w3c.dom.*;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*登录失败（用户名或 密码错误）*/

public class LoginFail extends DataProvide{
     public CommonFunctions comfun;
     public DataReader dr;
  
     @BeforeTest
     public void setup() throws Exception{
        String url = "http://test2.sui.me/";
        comfun=new CommonFunctions(url);
        dr=new DataReader();
        //设置数据源
        //init("src/testdata/LoginFail.xml");
        init("src/testdata/Data.xml");
     }
  
     @Test(dataProvider="Test_xml_dataprovider") 
     public void testloginfail(Document params) throws Exception {
       
        //登录、密码错误
    	comfun.login("13988880000","1234567");
    	//提示用户名或密码错误
    	comfun.checkequal("用户名或者密码错误。",comfun.gettext("css",dr.readnodevalue(params,"LoginPage","tips")));
     	   	 	
     }
  
     @AfterTest
     public void teardown() {
	    /**
	     * 截图、退出浏览器
	     */
	    CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"LoginFail.png");
        comfun.teardown();
      }
}