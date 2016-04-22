package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*待支付订单-立即支付-确定*/


public class Pay extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeTest
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/Pay.xml");
		init("src/testdata/Data.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testpay(Document params) throws Exception {
    	    	   	
    	//登录
    	comfun.login("13988880001","123456");
    	//点击用户名，切换到用户账户页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到待支付订单页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"AccountPage","paid"));
    	Thread.sleep(3000);
    	//立即支付第一个待支付订单
    	comfun.clickitem("xpath",dr.readnodevalue(params,"PaidPage","pay"));
    	//切换到Alert窗口、确定
    	Thread.sleep(3000);
    	Alert alert = CommonFunctions.driver.switchTo().alert(); 
        alert.accept();
        //验证支付宝页面
        Thread.sleep(8000);
        comfun.checkequal("我的收银台",comfun.gettext("classname",dr.readnodevalue(params,"AlipayPage","checkpoint")));
    	
    }
 

    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
  	  CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"Pay.png");
      comfun.teardown();
    }

}

