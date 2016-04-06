package testcases;

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
		init("src/testdata/Register.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void reg(Document params) throws Exception {
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	comfun.teardown();
    }

}
