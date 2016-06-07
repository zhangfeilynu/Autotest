package testcases;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;
import commonfunction.DotTestListener;


/*登录之后，上传文档，结算下单*/
@Listeners({DotTestListener.class})
public class EmailTest extends CommonFunctions {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
  
	@BeforeTest
	public void beforeClass() throws Exception {
		//打开网页
		String url="https://www.baidu.com/";
		comfun=new CommonFunctions(url);
		dr=new DataReader();
		//设置数据源
		//init("src/testdata/Order.xml");
		//init("src/testdata/Data.xml");
	}
	
	
    @Test
	public void testorder()throws Exception {
		
		System.out.println("XXXXXXXXXXXXXXX");
		
    }

 
 

    @AfterTest
    public void afterClass()throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"EmailTest.png");
    	comfun.teardown();
    }

}
