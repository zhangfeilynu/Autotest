package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*选择楼栋*/


public class PrintShop extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
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
    	/*//登录
    	comfun.login(dr.readnodevalue(params,"login","username"), dr.readnodevalue(params,"login","password"));
    	//选择学校、打印店
    	Thread.sleep(3000);
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[1]/div/div/a");
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"print","ctiy"));
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"print","school"));
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"print","dormitory"));
    	//验证楼栋
    	Thread.sleep(3000);
    	comfun.checkequal(dr.readnodevalue(params,"print","checkpoint1"),comfun.gettext("xpath",".//*[@id='app']/div/div[1]/div/div/a"));*/
    	
    	//登录
    	comfun.login("13988880002","123456");
    	//点击学校+楼栋
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","schooldorm"));
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
    	comfun.checkequal("上海交通大学 好精神",comfun.gettext("xpath",dr.readnodevalue(params,"HomePage","schooldorm")));
    	
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"PrintShop.png");
    	comfun.teardown();
    }

}
