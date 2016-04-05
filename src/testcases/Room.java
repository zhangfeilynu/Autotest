package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*选择宿舍*/


public class Room extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		init("testdata/Room.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testroom(Document params) throws Exception {
    	//登录
    	comfun.clickitem("xpath", ".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a");
    	Thread.sleep(2000);
    	comfun.login(dr.readnodevalue(params,"login","username"), dr.readnodevalue(params,"login","password"));
    	//选择学校、宿舍
    	Thread.sleep(3000);
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[1]/div/div/a");
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"room","ctiy"));
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"room","school"));
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"room","dormitory"));
    	Thread.sleep(3000);
    	comfun.checkequal(comfun.gettext("xpath",".//*[@id='app']/div/div[1]/div/div/a"),dr.readnodevalue(params,"room","checkpoint1"));
    	
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	comfun.teardown();
    }

}
