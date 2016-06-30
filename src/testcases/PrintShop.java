package testcases;

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

/*选择楼栋*/

@Listeners({DotTestListener.class})
public class PrintShop extends CommonFunctions {
	
	/*public CommonFunctions comfun;
	public DataReader dr;*/
	
	@BeforeClass
	public void beforeClass() throws Exception {
		/*String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/PrintShop.xml");
		init("src/testdata/Data.xml");*/
		setup();
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testprint(Document params) throws Exception {
    	    	
    	//登录
    	login(dr.readnodevalue(params,"PrintShop","cellphone"),dr.readnodevalue(params,"PrintShop","password"));
    	//点击学校
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","dorm"));
    	Thread.sleep(1000);
    	//选择城市：上海
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","city"));
    	Thread.sleep(1000);
    	//选择学校：上海交通大学
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","chooseschool"));
    	Thread.sleep(1000);
    	//选择楼栋 
    	//comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","choosedorm"));
    	//CommonFunctions.driver.findElement(By.linkText("好精神")).click();
    	clickitem("text","好精神");
    	Thread.sleep(1000);
    	//验证楼栋
    	checkequal(dr.readnodevalue(params,"PrintShop","checkpoint"),gettext("xpath",dr.readnodevalue(params,"HomePage","schooldorm")));
      	
    }
  

    @AfterClass
    public void afterClass() {
    	/**
  	   * 截图、退出浏览器
  	   */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"PrintShop.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"PrintShop.png");
    	teardown();
    }

}
