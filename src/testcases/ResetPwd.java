package testcases;

import org.w3c.dom.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*重置密码*/

public class ResetPwd extends DataProvide{
     public CommonFunctions comfun;
     public DataReader dr;
  
  @BeforeTest
  public void setup() throws Exception{
      String url = "http://test2.sui.me/";
      comfun=new CommonFunctions(url);
      dr=new DataReader();
      //设置数据源
      init("src/testdata/ResetPwd.xml");
  }
  
  @Test(dataProvider="Test_xml_dataprovider") 
  public void testresetpwd(Document params) throws Exception {
      //切换到登录页面
      comfun.clickitem("xpath", ".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a");
      Thread.sleep(3000);
      //切换到重置密码页面
      comfun.clickitem("xpath","html/body/div[2]/div/div[2]/div[4]/div/div/div[2]/a");
      Thread.sleep(3000);
      //重置密码
      comfun.inputvalue("xpath","html/body/div[2]/div/div[2]/div[2]/input",dr.readnodevalue(params,"resetpwd","cellphone"));
      comfun.inputvalue("xpath","html/body/div[2]/div/div[2]/div[3]/input",dr.readnodevalue(params,"resetpwd","password"));
      comfun.inputvalue("xpath","html/body/div[2]/div/div[2]/div[4]/input",dr.readnodevalue(params,"resetpwd","password"));
      comfun.inputvalue("xpath","html/body/div[2]/div/div[2]/div[5]/div/div[1]/input",dr.readnodevalue(params,"resetpwd","imgVerifyCode"));
      comfun.clickitem("xpath","html/body/div[2]/div/div[2]/div[5]/div/div[2]/div/button");
      comfun.inputvalue("xpath","html/body/div[2]/div/div[2]/div[5]/div/div[2]/div/input",dr.readnodevalue(params,"resetpwd","verificationCode"));
      comfun.clickitem("xpath","html/body/div[2]/div/div[2]/div[6]/div/div/div[1]/button");
      //验证
      Thread.sleep(1000);
      comfun.checkequal("密码重置成功,请登录",comfun.gettext("xpath","html/body/div[4]/div"));
   }
  
  @AfterTest
  public void teardown() {
      comfun.teardown();
  }
}