package testcases;

import org.w3c.dom.*;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;
import commonfunction.TestngRetry;

/*登录*/

public class TestDemo extends DataProvide{
     public CommonFunctions comfun;
     public DataReader dr;
  
     @BeforeTest
     public void setup() throws Exception{
        String url = "http://test2.sui.me/";
        comfun=new CommonFunctions(url);
        dr=new DataReader();
        //设置数据源
        //init("src/testdata/Login.xml");
        //init("src/testdata/Data.xml");
     }
  
    @Test(description = "commonfunction",retryAnalyzer = TestngRetry.class) 
    public void testlogin() throws Exception {
       /**
        * 登录，并检测登录（用户名）
        */
      // comfun.login(dr.readnodevalue(params,"Login","cellphone"),dr.readnodevalue(params,"Login","password"));
      // comfun.checkequal(dr.readnodevalue(params,"Login","checkpoint"),comfun.gettext("xpath",dr.readnodevalue(params,"HomePage","personal")));
       
       comfun.login("15261672979","123456");
       comfun.checkequal("aa",comfun.gettext("xpath",".//*[@id='app']/div/div[1]/nav/ul[2]/li[2]/a"));
       
    }
  
    @AfterTest
    public void teardown() {
    	/**
    	 *截图、退出浏览器
    	 */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"TestDemo.png");
        comfun.teardown();
  }
}