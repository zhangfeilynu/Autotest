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

/*登录页面，重置密码*/
@Listeners({DotTestListener.class})
public class ResetPwd extends CommonFunctions{
     /*public CommonFunctions comfun;
     public DataReader dr;*/
  
  @BeforeClass
  public void beforeClass() throws Exception{
      /*String url = "http://test2.sui.me/";
      comfun=new CommonFunctions(url);
      dr=new DataReader();
      //设置数据源
      //init("src/testdata/ResetPwd.xml");
      init("src/testdata/Data.xml");*/
	  setup();
  }
  
  @Test(dataProvider="Test_xml_dataprovider") 
  public void testresetpwd(Document params) throws Exception {
     	  
	  //切换到登录页面
	  clickitem("xpath",dr.readnodevalue(params,"HomePage","login"));
	  Thread.sleep(3000);
	  //切换到重置密码页面
	  clickitem("xpath",dr.readnodevalue(params,"LoginPage","resetpwd"));
	  Thread.sleep(3000);
	  //输入手机号
	  inputvalue("xpath",dr.readnodevalue(params,"PassportPage","cellphone"),dr.readnodevalue(params,"ResetPwd","cellphone"));
	  //输入新密码
	  inputvalue("xpath",dr.readnodevalue(params,"PassportPage","newpwd"),dr.readnodevalue(params,"ResetPwd","newpwd"));
	  //确认密码
	  inputvalue("xpath",dr.readnodevalue(params,"PassportPage","conpwd"),dr.readnodevalue(params,"ResetPwd","newpwd"));
	  //输入图形验证码
	  inputvalue("xpath",dr.readnodevalue(params,"PassportPage","imgVerifyCode"),dr.readnodevalue(params,"ResetPwd","imgVerifyCode"));
	  //点击获取按钮
	  clickitem("xpath",dr.readnodevalue(params,"PassportPage","obtain"));
	  //输入短信验证码
	  inputvalue("xpath",dr.readnodevalue(params,"PassportPage","verificationCode"),dr.readnodevalue(params,"ResetPwd","verificationCode"));
	  //点击重置密码按钮
	  clickitem("xpath",dr.readnodevalue(params,"PassportPage","submit"));
	  //验证（成功提示）
	  Thread.sleep(1000);
	  checkequal(dr.readnodevalue(params,"ResetPwd","tips"),gettext("xpath",dr.readnodevalue(params,"PassportPage","tips")));
	  
	  
   }
  
  @AfterClass
  public void afterClass() {
	  /**
	   * 截图、退出浏览器
	   */
	  //CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ResetPwd.png");
	  //CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"ResetPwd.png");
	  teardown();
  }
}
