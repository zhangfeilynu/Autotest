package testcases;

import org.openqa.selenium.Alert;
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

/*待支付订单-立即支付-确定*/

@Listeners({DotTestListener.class})
public class Pay extends CommonFunctions {
	
	/*public CommonFunctions comfun;
	public DataReader dr;*/
	
	@BeforeClass
	public void before() throws Exception {
		/*String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/Pay.xml");
		init("src/testdata/Data.xml");*/
		setup();
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testpay(Document params) throws Exception {
    	    	   	
    	//登录
    	login(dr.readnodevalue(params,"Pay","cellphone"),dr.readnodevalue(params,"Pay","password"));
    	//点击用户名，切换到用户账户页面
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到待支付订单页面
    	clickitem("xpath",dr.readnodevalue(params,"AccountPage","paid"));
    	Thread.sleep(3000);
    	//立即支付第一个待支付订单
    	clickitem("xpath",dr.readnodevalue(params,"PaidPage","pay"));
    	//切换到Alert窗口、确定
    	Thread.sleep(3000);
    	//Alert alert = CommonFunctions.driver.switchTo().alert(); 
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
        //验证支付宝页面
        Thread.sleep(8000);
        checkequal(dr.readnodevalue(params,"Pay","checkpoint"),gettext("classname",dr.readnodevalue(params,"AlipayPage","checkpoint")));
    	
    }
 

    @AfterClass
    public void afterClass() {
    	/**
  	   * 截图、退出浏览器
  	   */
  	  //CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"Pay.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"Pay.png");
    	teardown();
    }

}

