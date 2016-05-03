package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;


//重复注册

public class DupRegister extends DataProvide {
	
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
    public void testdupreg(Document params) throws Exception {
    	    	    	
    	//输入用户名
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","username"),dr.readnodevalue(params,"DupRegister","username"));
    	//输入已注册过的手机号
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),dr.readnodevalue(params,"DupRegister","cellphone"));
    	//输入密码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","password"),dr.readnodevalue(params,"DupRegister","password"));
    	//输入图形验证码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","imgVerifyCode"),dr.readnodevalue(params,"DupRegister","imgVerifyCode"));
    	//点击获取按钮
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","obtain"));
    	//提示已注册
    	Thread.sleep(1000);
    	comfun.checkequal(dr.readnodevalue(params,"DupRegister","tips"),comfun.gettext("css",dr.readnodevalue(params,"HomePage","tips")));
       
    }

   

    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"DupRegister.png");
    	comfun.teardown();
    }

}
