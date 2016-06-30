package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


/*登录之后，上传文档，结算下单*/
@Listeners({DotTestListener.class})
public class Order extends CommonFunctions {
	
	/*public CommonFunctions comfun;
	public DataReader dr;*/
	
  
	@BeforeClass
	public void beforeClass() throws Exception {
		/*//打开网页
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr=new DataReader();
		//设置数据源
		//init("src/testdata/Order.xml");
		init("src/testdata/Data.xml");*/
		setup();
	}
	
	@Test(dataProvider = "Test_xml_dataprovider")
    public void testorder(Document params)throws Exception {
		
		//登录
		login(dr.readnodevalue(params,"Order","cellphone"),dr.readnodevalue(params,"Order","password"));
		//切换到打印页面
		clickitem("xpath",dr.readnodevalue(params,"HomePage","print"));
		Thread.sleep(3000);
		//取消上传控件的隐藏属性
		//((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
		((JavascriptExecutor)driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
		//上传文件(doc、docx、ppt、pptx、pdf)、隐藏上传控件
		inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","pdf"));
		//comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","pptx"));
		//comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","ppt"));
		//comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","docx"));
		//comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","doc"));
		//((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display='none'");
		((JavascriptExecutor)driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display='none'");
		Thread.sleep(20000);
		//CommonFunctions.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//结算
		/*waitxs(By.xpath(dr.readnodevalue(params,"PrintPage","settlement")),10);
		e.click();*/
		
		clickitem("xpath",dr.readnodevalue(params,"PrintPage","settlement"));
		Thread.sleep(3000);
		//修改打印列表中第一个文件页面布局、选择1页2面
		clickitem("xpath",dr.readnodevalue(params,"CartPage","droplayout"));
		clickitem("xpath",dr.readnodevalue(params,"CartPage","layout2"));
		//选择双面打印
		clickitem("xpath",dr.readnodevalue(params,"CartPage","droppage"));
		clickitem("xpath",dr.readnodevalue(params,"CartPage","twoside"));
		//添加打印份数
		clickitem("xpath",dr.readnodevalue(params,"CartPage","add"));
		//确认下单
		clickitem("xpath",dr.readnodevalue(params,"CartPage","submit"));
		Thread.sleep(8000);
		//验证支付页面
		checkequal(dr.readnodevalue(params,"Order","checkpoint"),gettext("classname",dr.readnodevalue(params,"AlipayPage","checkpoint")));
		
    }

 
 

    @AfterClass
    public void afterClass() {
    	/**
  	   * 截图、退出浏览器
  	   */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"Order.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"Order.png");
    	teardown();
    }

}
