package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;


//注册时图形验证码错误

public class ErrPRegister extends DataProvide {
	
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
    public void testerrpreg(Document params) throws Exception {
    	    	  	
    	//输入用户名
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","username"),"Register");
    	//输入已注册过的手机号
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),"13988880000");
    	//输入密码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","password"),"123456");
    	//输入错误的图形验证码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","imgVerifyCode"),"qwer");
    	//点击获取按钮
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","obtain"));
    	//提示验证码错误
    	Thread.sleep(1000);
    	comfun.checkequal("图形验证码错误",comfun.gettext("css",dr.readnodevalue(params,"HomePage","tips")));
  
    }

   

    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ErrPRegister.png");
    	comfun.teardown();
    }

}
