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
		//init("src/testdata/Order.xml");
		init("src/testdata/Data.xml");
	}
	
	@Test(dataProvider = "Test_xml_dataprovider")
    public void testorder(Document params)throws Exception {
		
		//登录
		comfun.login("13988880001","123456");
		//切换到打印页面
		comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","print"));
		Thread.sleep(3000);
		//取消上传控件的隐藏属性
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
		//上传文件(doc、docx、ppt、pptx、pdf)、隐藏上传控件
		comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),"F:\\testfiles\\测试文件1.doc");
		comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),"F:\\testfiles\\测试文件2.docx");
		comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),"F:\\testfiles\\测试文件3.ppt");
		comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),"F:\\testfiles\\测试文件4.pptx");
		comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),"F:\\testfiles\\测试文件5.pdf");
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display='none'");
		Thread.sleep(12000);
		//结算
		comfun.clickitem("xpath",dr.readnodevalue(params,"PrintPage","settlement"));
		Thread.sleep(3000);
		//确认下单
		comfun.clickitem("xpath",dr.readnodevalue(params,"CartPage","submit"));
		Thread.sleep(8000);
		//验证支付页面
		comfun.checkequal("我的收银台",comfun.gettext("classname",dr.readnodevalue(params,"AlipayPage","checkpoint")));
		
    }

 
 

    @AfterClass
    public void afterClass()throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"Order.png");
    	comfun.teardown();
    }

}
