package testcases;

import org.w3c.dom.*;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;
import commonfunction.DotTestListener;

/*登录失败（用户名或 密码错误）*/
@Listeners({DotTestListener.class})
public class LoginFail extends CommonFunctions{
     /*public CommonFunctions comfun;
     public DataReader dr;*/
  
     @BeforeClass
     public void beforeClass() throws Exception{
        /*String url = "http://test2.sui.me/";
        comfun=new CommonFunctions(url);
        dr=new DataReader();
        //设置数据源
        //init("src/testdata/LoginFail.xml");
        init("src/testdata/Data.xml");*/
    	setup();
     }
  
     @Test(dataProvider="Test_xml_dataprovider") 
     public void testloginfail(Document params) throws Exception {
       
        //登录、密码错误
    	login(dr.readnodevalue(params,"LoginFail","cellphone"),dr.readnodevalue(params,"LoginFail","password"));
    	//提示用户名或密码错误
    	checkequal(dr.readnodevalue(params,"LoginFail","checkpoint"),gettext("css",dr.readnodevalue(params,"LoginPage","tips")));
     	   	 	
     }
  
     @AfterClass
     public void afterClass() {
	    /**
	     * 截图、退出浏览器
	     */
	    //CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"LoginFail.png");
    	 //CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"LoginFail.png");
    	 teardown();
      }
}