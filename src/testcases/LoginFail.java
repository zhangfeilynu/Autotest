package testcases;

import org.w3c.dom.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*登录失败（密码错误）*/

public class LoginFail extends DataProvide{
     public CommonFunctions comfun;
     public DataReader dr;
  
  @BeforeTest
  public void setup() throws Exception{
      String url = "http://test2.sui.me/";
      comfun=new CommonFunctions(url);
      dr=new DataReader();
      //设置数据源
      init("src/testdata/LoginFail.xml");
  }
  
  @Test(dataProvider="Test_xml_dataprovider") 
  public void testloginfail(Document params) throws Exception {
   /**
    *  错误的用户名或者密码登录
    */
      comfun.clickitem("xpath", ".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a");
      Thread.sleep(3000);
      comfun.login(dr.readnodevalue(params, "loginfail", "username"), dr.readnodevalue(params, "loginfail", "password"));
      comfun.checkequal("用户名或者密码错误。",comfun.gettext("css",".cg-notify-message-template.ng-binding.ng-scope"));
   }
  
  @AfterTest
  public void teardown() {
      comfun.teardown();
  }
}