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


//注册时图形验证码错误
@Listeners({DotTestListener.class})
public class ErrPRegister extends CommonFunctions {
	
	/*public CommonFunctions comfun;
	public DataReader dr;*/
	
	@BeforeClass
	public void beforeClass() throws Exception {
		/*String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/DupRegister.xml");
		init("src/testdata/Data.xml");*/
		setup();
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testerrpreg(Document params) throws Exception {
    	    	  	
    	//输入用户名
    	inputvalue("name",dr.readnodevalue(params,"HomePage","username"),dr.readnodevalue(params,"ErrPRegister","username"));
    	//输入手机号
    	inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),dr.readnodevalue(params,"ErrPRegister","cellphone"));
    	//输入密码
    	inputvalue("name",dr.readnodevalue(params,"HomePage","password"),dr.readnodevalue(params,"ErrPRegister","password"));
    	//输入错误的图形验证码
    	inputvalue("name",dr.readnodevalue(params,"HomePage","imgVerifyCode"),dr.readnodevalue(params,"ErrPRegister","imgVerifyCode"));
    	//点击获取按钮
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","obtain"));
    	//提示验证码错误
    	Thread.sleep(1000);
    	checkequal(dr.readnodevalue(params,"ErrPRegister","tips"),gettext("css",dr.readnodevalue(params,"HomePage","tips")));
  
    }

   

    @AfterClass
    public void afterClass() {
    	/**
  	   * 截图、退出浏览器
  	   */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ErrPRegister.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"ErrPRegister.png");
    	teardown();
    }

}
