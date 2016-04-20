package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*待支付订单-取消订单*/


public class CancelOrder extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/CancelOrder.xml");
		init("src/testdata/Data.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testcancelorder(Document params) throws Exception {
    	
    /*	 //登录
    	 comfun.login(dr.readnodevalue(params, "login", "username"), dr.readnodevalue(params, "login", "password"));
         //点击用户名
         comfun.clickitem("xpath",dr.readnodevalue(params,"map","personal"));
    	 Thread.sleep(3000);
         //切换到待支付订单页面
         comfun.clickitem("xpath",dr.readnodevalue(params,"map","notpaid"));
    	 Thread.sleep(3000);
         //取消第一个待支付的订单
         comfun.clickitem("xpath",dr.readnodevalue(params,"map","cancel"));
         //切换到Alert窗口、确定
         Alert alert = CommonFunctions.driver.switchTo().alert(); 
         Thread.sleep(3000);
         alert.accept();
         //验证
         comfun.checkequal("取消订单成功!",comfun.gettext("xpath",dr.readnodevalue(params,"map","tips")));
            	*/
    	//登录
    	comfun.login("13988880001","123456");
    	//点击用户名
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到待支付订单页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"AccountPage","paid"));
    	Thread.sleep(3000);
    	//取消第一个待支付的订单
    	comfun.clickitem("xpath",dr.readnodevalue(params,"PaidPage","cancel"));
    	//切换到Alert窗口、确定
    	Thread.sleep(3000);
    	Alert alert = CommonFunctions.driver.switchTo().alert(); 
        alert.accept();
        //验证（提示取消成功）
        Thread.sleep(1000);
        comfun.checkequal("取消订单成功!",comfun.gettext("xpath",dr.readnodevalue(params,"PaidPage","tips")));
    	
    	
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
  	  CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"CancelOrder.png");
      comfun.teardown();
    }

}

