package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;


//注册时短信验证码错误

public class ErrMRegister extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeTest
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/DupRegister.xml");
		init("src/testdata/Data.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testerrmreg(Document params) throws Exception {
    	    	  	
    	//输入用户名
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","username"),dr.readnodevalue(params,"ErrMRegister","username"));
    	//输入已注册过的手机号
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),dr.readnodevalue(params,"ErrMRegister","cellphone"));
    	//输入密码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","password"),dr.readnodevalue(params,"ErrMRegister","password"));
    	//输入图形验证码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","imgVerifyCode"),dr.readnodevalue(params,"ErrMRegister","imgVerifyCode"));
    	//点击获取按钮
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","obtain"));
    	//输入错误的短信验证码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","verificationCode"),dr.readnodevalue(params,"ErrMRegister","verificationCode"));
    	//点击免费注册按钮
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","submit"));
    	//提示短信验证码错误
    	Thread.sleep(1000);
    	comfun.checkequal(dr.readnodevalue(params,"ErrMRegister","tips"),comfun.gettext("xpath",dr.readnodevalue(params,"HomePage","tips2")));
  
    }

   

    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ErrMRegister.png");
    	comfun.teardown();
    }

}
