package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;


//重复注册

public class DupRegister extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
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
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","username"),"DupRegister");
    	//输入已注册过的手机号
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),"13988880000");
    	//输入密码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","password"),"123456");
    	//输入图形验证码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","imgVerifyCode"),"asdf");
    	//点击获取按钮
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","obtain"));
    	//提示已注册
    	comfun.checkequal("该手机号码已注册。",comfun.gettext("css",dr.readnodevalue(params,"HomePage","tips")));
        	
    }

   

    @AfterClass
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"DupRegister.png");
    	comfun.teardown();
    }

}
