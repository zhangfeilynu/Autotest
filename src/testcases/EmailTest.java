package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;


/*登录之后，上传文档，结算下单*/

public class EmailTest extends DataProvide {
	
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
		init("src/testdata/Data.xml");
	}
	
	@Test(dataProvider = "Test_xml_dataprovider")
    public void testorder(Document params)throws Exception {
		
		/*comfun.inputvalue("id","idPlaceholder","zhangfeilynu");
		comfun.inputvalue("id","pwdInput","xxxxxxx");
		comfun.clickitem("id","loginBtn");
		comfun.clickitem("xpath",".//*[@id='_mail_component_65_65']/span[2]");
		comfun.clickitem("xpath",".//*[@id='_mail_component_124_124']/span[2]");
		comfun.moveToElement(By.xpath(".//*[@id='mainContent']/div[3]/div[2]/div[2]/div/div[1]/div/div[1]/div/div[1]/img"));
		comfun.clickitem("xpath",".//*[@id='mainContent']/div[3]/div[2]/div[2]/div/div[1]/div/div[1]/div/div[5]/div[2]/a[3]");
		Thread.sleep(8000);*/
		
		comfun.inputvalue("id","kw","selenium判断页面加载完成");
		comfun.clickitem("id","su");
		comfun.clickitem("xpath",".//*[@id='1']/h3/a");
		Thread.sleep(10000);
		
    }

 
 

    @AfterTest
    public void afterClass()throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"EmailTest.png");
    	comfun.teardown();
    }

}
