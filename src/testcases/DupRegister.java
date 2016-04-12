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
		init("src/testdata/DupRegister.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testdupreg(Document params) throws Exception {
    	
    	//输入用户名
    	comfun.inputvalue("name","nickName",dr.readnodevalue(params,"reg","nickName"));
    	//输入已注册的手机号
    	comfun.inputvalue("name","cellphone",dr.readnodevalue(params,"reg","cellphone"));
    	//输入密码
    	comfun.inputvalue("name","password",dr.readnodevalue(params,"reg","password"));
    	//输入图形验证码
    	comfun.inputvalue("name","imgVerifyCode",dr.readnodevalue(params,"reg","imgVerifyCode"));
    	//点击获取按钮
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[4]/div/div[2]/div/button");
    	//提示已注册
    	comfun.checkequal("该手机号码已注册。",comfun.gettext("css",".sui-message-custom-content.sui-message-error>span"));
    
    	
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
