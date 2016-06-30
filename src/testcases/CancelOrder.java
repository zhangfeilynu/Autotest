package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

/*待支付订单-取消订单*/

@Listeners({DotTestListener.class})
public class CancelOrder extends CommonFunctions {
	
	/*public CommonFunctions comfun;
	public DataReader dr;*/
	
	@BeforeClass
	public void beforeClass() throws Exception {
		/*String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/CancelOrder.xml");
		init("src/testdata/Data.xml");*/
		setup();		
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testcancelorder(Document params) throws Exception {
    	
       	//登录
    	login(dr.readnodevalue(params,"CancelOrder","cellphone"),dr.readnodevalue(params,"CancelOrder","password"));
    	//点击用户名
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到待支付订单页面
    	clickitem("xpath",dr.readnodevalue(params,"AccountPage","paid"));
    	Thread.sleep(3000);
    	
    	
    	//取消第一个待支付的订单
        clickitem("xpath",dr.readnodevalue(params,"PaidPage","cancel"));
        //切换到Alert窗口、确定
        Thread.sleep(3000);
        //Alert alert = CommonFunctions.driver.switchTo().alert(); 
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //验证（提示取消成功）
        Thread.sleep(1000);
        checkequal(dr.readnodevalue(params,"CancelOrder","tips"),gettext("xpath",dr.readnodevalue(params,"PaidPage","tips")));
    	   	
    	
    }

  
  

    @AfterClass
    public void afterClass(){
    	/**
  	   * 截图、退出浏览器
  	   */
  	  //CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"CancelOrder.png");
       //CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"CancelOrder.png");
       //System.out.println(driver.getClass().getSimpleName());
       teardown();
    }

}

