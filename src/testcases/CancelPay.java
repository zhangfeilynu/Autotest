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

/*待支付订单-立即支付-取消*/


public class CancelPay extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeTest
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/CancelPay.xml");
		init("src/testdata/Data.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testcancelpay(Document params) throws Exception {
    	
    	//登录
    	comfun.login("13988880001","123456");
    	//点击用户名
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到待支付订单页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"AccountPage","paid"));
    	Thread.sleep(3000);
    	//立即支付第一个待支付订单 
    	comfun.clickitem("xpath",dr.readnodevalue(params,"PaidPage","pay"));
    	//切换到Alert窗口、取消
    	Thread.sleep(3000);
    	Alert alert = CommonFunctions.driver.switchTo().alert(); 
        alert.dismiss();
  	
    }
  

    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
  	  CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"CancelPay.png");
      comfun.teardown();
    }

}

