package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*选择楼栋*/


public class PrintShop extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeTest
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/PrintShop.xml");
		init("src/testdata/Data.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testprint(Document params) throws Exception {
    	    	
    	//登录
    	comfun.login(dr.readnodevalue(params,"PrintShop","cellphone"),dr.readnodevalue(params,"PrintShop","password"));
    	//点击学校
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","dorm"));
    	Thread.sleep(1000);
    	//选择城市：上海
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","city"));
    	Thread.sleep(1000);
    	//选择学校：上海交通大学
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","chooseschool"));
    	Thread.sleep(1000);
    	//选择楼栋 
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","choosedorm"));
    	Thread.sleep(1000);
    	//验证楼栋
    	comfun.checkequal(dr.readnodevalue(params,"PrintShop","checkpoint"),comfun.gettext("xpath",dr.readnodevalue(params,"HomePage","schooldorm")));
      	
    }
  

    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"PrintShop.png");
    	comfun.teardown();
    }

}
