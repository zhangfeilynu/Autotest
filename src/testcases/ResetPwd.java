package testcases;

import org.w3c.dom.*;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*登录页面，重置密码*/

public class ResetPwd extends DataProvide{
     public CommonFunctions comfun;
     public DataReader dr;
  
  @BeforeTest
  public void setup() throws Exception{
      String url = "http://test2.sui.me/";
      comfun=new CommonFunctions(url);
      dr=new DataReader();
      //设置数据源
      //init("src/testdata/ResetPwd.xml");
      init("src/testdata/Data.xml");
  }
  
  @Test(dataProvider="Test_xml_dataprovider") 
  public void testresetpwd(Document params) throws Exception {
     	  
	  //切换到登录页面
	  comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","login"));
	  Thread.sleep(3000);
	  //切换到重置密码页面
	  comfun.clickitem("xpath",dr.readnodevalue(params,"LoginPage","resetpwd"));
	  Thread.sleep(3000);
	  //输入手机号
	  comfun.inputvalue("xpath",dr.readnodevalue(params,"PassportPage","cellphone"),dr.readnodevalue(params,"ResetPwd","cellphone"));
	  //输入新密码
	  comfun.inputvalue("xpath",dr.readnodevalue(params,"PassportPage","newpwd"),dr.readnodevalue(params,"ResetPwd","newpwd"));
	  //确认密码
	  comfun.inputvalue("xpath",dr.readnodevalue(params,"PassportPage","conpwd"),dr.readnodevalue(params,"ResetPwd","newpwd"));
	  //输入图形验证码
	  comfun.inputvalue("xpath",dr.readnodevalue(params,"PassportPage","imgVerifyCode"),dr.readnodevalue(params,"ResetPwd","imgVerifyCode"));
	  //点击获取按钮
	  comfun.clickitem("xpath",dr.readnodevalue(params,"PassportPage","obtain"));
	  //输入短信验证码
	  comfun.inputvalue("xpath",dr.readnodevalue(params,"PassportPage","verificationCode"),dr.readnodevalue(params,"ResetPwd","verificationCode"));
	  //点击重置密码按钮
	  comfun.clickitem("xpath",dr.readnodevalue(params,"PassportPage","submit"));
	  //验证（成功提示）
	  Thread.sleep(1000);
	  comfun.checkequal(dr.readnodevalue(params,"ResetPwd","tips"),comfun.gettext("xpath",dr.readnodevalue(params,"PassportPage","tips")));
	  
	  
   }
  
  @AfterTest
  public void teardown() {
	  /**
	   * 截图、退出浏览器
	   */
	  CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ResetPwd.png");
      comfun.teardown();
  }
}
