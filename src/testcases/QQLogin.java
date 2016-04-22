package testcases;

import org.w3c.dom.*;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*QQ登录*/

public class QQLogin extends DataProvide{
     public CommonFunctions comfun;
     public DataReader dr;
  
     @BeforeTest
     public void setup() throws Exception{
        String url = "http://test2.sui.me/";
        comfun=new CommonFunctions(url);
        dr=new DataReader();
        //设置数据源
        //init("src/testdata/Login.xml");
        init("src/testdata/Data.xml");
     }
  
    @Test(dataProvider="Test_xml_dataprovider") 
    public void testqqlogin(Document params) throws Exception {
       
        //在首页点击“QQ登录”按钮
        comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","qqlogin"));
        Thread.sleep(3000);
        //切换到账号密码登录
        comfun.clickitem("id",dr.readnodevalue(params,"QQLoginPage","switch"));
        Thread.sleep(10000);
        //输入qq账号、密码
        comfun.inputvalue("id",dr.readnodevalue(params,"QQLoginPage","qqusername"),"2820168487");
        comfun.inputvalue("id",dr.readnodevalue(params,"QQLoginPage","qqpwd"),"testSuiyin001");
        //点击授权并登录按钮
        comfun.clickitem("id",dr.readnodevalue(params,"QQLoginPage","qqlogin"));
        Thread.sleep(8000);
       
    }
  
    @AfterTest
    public void teardown() {
    	/**
    	 *截图、退出浏览器
    	 */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"QQLogin.png");
        comfun.teardown();
  }
}