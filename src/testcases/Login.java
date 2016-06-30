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


/*登录*/
@Listeners({DotTestListener.class})
public class Login extends CommonFunctions{
     /*public CommonFunctions comfun;
     public DataReader dr;*/
  
     @BeforeClass
     public void beforeClass() throws Exception{
        /*String url = "http://test2.sui.me/";
        comfun=new CommonFunctions(url);
        dr=new DataReader();
        //设置数据源
        //init("src/testdata/Login.xml");
        init("src/testdata/Data.xml");*/
    	setup();
     }
  
    @Test(dataProvider="Test_xml_dataprovider") 
    public void testlogin(Document params) throws Exception {
       /**
        * 登录，并检测登录（用户名）
        */
       login(dr.readnodevalue(params,"Login","cellphone"),dr.readnodevalue(params,"Login","password"));
       checkequal(dr.readnodevalue(params,"Login","checkpoint"),gettext("xpath",dr.readnodevalue(params,"HomePage","personal")));
       
    }
  
    @AfterClass
    public void afterClass() {
    	/**
    	 *截图、退出浏览器
    	 */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"Login.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"Login.png");
    	teardown();
  }
}