package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*登录之后，上传文档，结算下单*/

public class Order extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
  
	@BeforeClass
	public void beforeClass() throws Exception {
		//打开网页
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr=new DataReader();
		//设置数据源
		init("src/testdata/Order.xml");
	}
	
	@Test(dataProvider = "Test_xml_dataprovider")
    public void testorder(Document params)throws Exception {
		//登录
		comfun.clickitem("xpath", ".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a");
		Thread.sleep(3000);
		comfun.login(dr.readnodevalue(params,"upload","username"), dr.readnodevalue(params,"upload","password"));
		//切换到打印页面
		comfun.clickitem("xpath", "//*[@id='app']/div/div[1]/nav/ul[1]/li[2]/a");
		//取消上传控件的隐藏属性
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
		//上传文件(doc、docx、ppt、pptx、pdf)、隐藏上传控件
		comfun.inputvalue("xpath", ".//*[@id='app']/div/div[2]/div[2]/div[1]/div[1]/div/input", dr.readnodevalue(params, "upload", "doc"));
		comfun.inputvalue("xpath", ".//*[@id='app']/div/div[2]/div[2]/div[1]/div[1]/div/input", dr.readnodevalue(params, "upload", "docx"));
		comfun.inputvalue("xpath", ".//*[@id='app']/div/div[2]/div[2]/div[1]/div[1]/div/input", dr.readnodevalue(params, "upload", "ppt"));
		comfun.inputvalue("xpath", ".//*[@id='app']/div/div[2]/div[2]/div[1]/div[1]/div/input", dr.readnodevalue(params, "upload", "pptx"));
		comfun.inputvalue("xpath", ".//*[@id='app']/div/div[2]/div[2]/div[1]/div[1]/div/input", dr.readnodevalue(params, "upload", "pdf"));
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display='none'");
		Thread.sleep(12000);
		//结算
		comfun.clickitem("xpath", ".//*[@id='app']/div/div[2]/div[4]/button");
		//下单
		comfun.clickitem("classname", "button-submit");
		Thread.sleep(8000);
		//验证支付（支付宝支付页面）
		comfun.checkequal("我的收银台",comfun.gettext("classname", "logo-title"));
		
    }

 
 

    @AfterClass
    public void afterClass()throws Exception {
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"Order.png");
    	comfun.teardown();
    }

}
