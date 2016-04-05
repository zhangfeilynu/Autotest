package testcases;

import org.w3c.dom.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*��¼*/

public class Login extends DataProvide{
     public CommonFunctions comfun;
     public DataReader dr;
  
  @BeforeTest
  public void setup() throws Exception{
      String url = "http://test2.sui.me/";
      comfun=new CommonFunctions(url);
      dr=new DataReader();
      //��������Դ
      init("src/testdata/Login.xml");
  }
  
  @Test(dataProvider="Test_xml_dataprovider") 
  public void testlogin(Document params) throws Exception {
   /**
    * ����¼
    */
      comfun.clickitem("xpath", ".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a");
      comfun.login(dr.readnodevalue(params, "login", "username"), dr.readnodevalue(params, "login", "password"));
      comfun.checkequal(comfun.gettext("xpath", dr.readnodevalue(params, "login", "checkpoint1")), dr.readnodevalue(params, "login", "value1"));
   }
  
  @AfterTest
  public void teardown() {
      comfun.teardown();
  }
}