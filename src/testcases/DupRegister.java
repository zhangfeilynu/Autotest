package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;
import commonfunction.DotTestListener;


//重复注册
@Listeners({DotTestListener.class})
public class DupRegister extends CommonFunctions {
	
	/*public CommonFunctions comfun;
	public DataReader dr;*/
	
	@BeforeClass
	public void before() throws Exception {
		/*String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/DupRegister.xml");
		init("src/testdata/Data.xml");*/
		setup();
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testdupreg(Document params) throws Exception {
    	    	    	
    	//输入用户名
    	inputvalue("name",dr.readnodevalue(params,"HomePage","username"),dr.readnodevalue(params,"DupRegister","username"));
    	//输入已注册过的手机号
    	inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),dr.readnodevalue(params,"DupRegister","cellphone"));
    	//输入密码
    	inputvalue("name",dr.readnodevalue(params,"HomePage","password"),dr.readnodevalue(params,"DupRegister","password"));
    	//输入图形验证码
    	inputvalue("name",dr.readnodevalue(params,"HomePage","imgVerifyCode"),dr.readnodevalue(params,"DupRegister","imgVerifyCode"));
    	//点击获取按钮
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","obtain"));
    	//提示已注册
    	Thread.sleep(1000);
    	checkequal(dr.readnodevalue(params,"DupRegister","tips"),gettext("css",dr.readnodevalue(params,"HomePage","tips")));
       
    }

   

    @AfterClass
    public void after() {
    	/**
  	   * 截图、退出浏览器
  	   */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"DupRegister.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"DupRegister.png");
    	teardown();
    }

}
