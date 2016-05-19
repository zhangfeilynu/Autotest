package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;


/*登录之后，上传文档，结算下单*/

public class WaitDemo extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
  
	@BeforeTest
	public void beforeClass() throws Exception {
		//打开网页
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr=new DataReader();
		//设置数据源
		//init("src/testdata/Order.xml");
		init("src/testdata/Data.xml");
	}
	
	@Test(dataProvider = "Test_xml_dataprovider")
    public void testorder(Document params)throws Exception {
		
		//登录
		comfun.login(dr.readnodevalue(params,"Order","cellphone"),dr.readnodevalue(params,"Order","password"));
		//切换到打印页面
		comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","print"));
		
		//Thread.sleep(3000);
		
		//取消上传控件的隐藏属性
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
		//上传文件(doc、docx、ppt、pptx、pdf)、隐藏上传控件
		comfun.waitpresenceOfElementLocated(10, By.xpath(dr.readnodevalue(params,"PrintPage","file")));
		comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","pdf"));
		//comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","pptx"));
		//comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","ppt"));
		//comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","docx"));
		//comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),dr.readnodevalue(params,"Order","doc"));
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display='none'");
		Thread.sleep(10000);
		//comfun.waitpresenceOfElementLocated(10, By.xpath(".//*[@id='app']/div/div[2]/div[4]/button"));
		//结算
		
		comfun.clickitem("xpath",dr.readnodevalue(params,"PrintPage","settlement"));
		//Thread.sleep(3000);
		comfun.waitpresenceOfElementLocated(10, By.xpath(dr.readnodevalue(params,"CartPage","droplayout")));
		//修改打印列表中第一个文件页面布局、选择1页2面
		comfun.clickitem("xpath",dr.readnodevalue(params,"CartPage","droplayout"));
		comfun.clickitem("xpath",dr.readnodevalue(params,"CartPage","layout2"));
		//选择双面打印
		comfun.clickitem("xpath",dr.readnodevalue(params,"CartPage","droppage"));
		comfun.clickitem("xpath",dr.readnodevalue(params,"CartPage","twoside"));
		//添加打印份数
		comfun.clickitem("xpath",dr.readnodevalue(params,"CartPage","add"));
		
		
		//确认下单
		comfun.clickitem("xpath",dr.readnodevalue(params,"CartPage","submit"));
		//Thread.sleep(8000);
		comfun.waitpresenceOfElementLocated(10, By.className(dr.readnodevalue(params,"AlipayPage","checkpoint")));
		//验证支付页面
		comfun.checkequal(dr.readnodevalue(params,"Order","checkpoint"),comfun.gettext("classname",dr.readnodevalue(params,"AlipayPage","checkpoint")));
		
    }

 
 

    @AfterTest
    public void afterClass()throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"WaitDemo.png");
    	comfun.teardown();
    }

}
