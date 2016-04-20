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

/*注册账号*/


public class Demo extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		init("src/testdata/Data.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testdemo(Document params) throws Exception {
    	/**
    	 * 免费注册
    	 */
    	/*comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","username"),"test11");
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),"14712349898");
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","password"),"123456");
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","imgVerifyCode"),"asdf");
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","obtain"));
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","verificationCode"),"123456");
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","submit"));*/
    	//comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","print"));
    	/*comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","login"));
    	Thread.sleep(3000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"LoginPage","print"));
    	Thread.sleep(8000);*/
    	//comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","login"));
    	Thread.sleep(3000);
    	comfun.login("15261672979","123");
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","print"));
    	Thread.sleep(3000);
    	//init("src/testdata/PrintPage.xml");
    	((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"PrintPage","file"),"F:\\testfiles\\测试文件1.doc");
    	Thread.sleep(8000);
    	
    	
    	
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
  	  CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"Demo.png");
      comfun.teardown();
    }

}
