package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*个人资料-安全中心-找回密码*/


public class ModifyPwd extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		init("src/testdata/ModifyPwd.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testmodifypwd(Document params) throws Exception {
    	
    	//登录
    	comfun.login(dr.readnodevalue(params,"login","cellphone"),dr.readnodevalue(params,"login","password"));
    	//切换到安全中心页面
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[1]/nav/ul[2]/li/a");
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[1]/div/div[3]/dl/dd[2]/a");
    	//输入旧密码
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/input",dr.readnodevalue(params,"login","password"));
    	//输入新密码
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/input",dr.readnodevalue(params,"modifypwd","newpwd"));
    	//重复新密码
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div[3]/div/div/input",dr.readnodevalue(params,"modifypwd","newpwd"));
    	//保存修改
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/input");
    	//验证(提示修改成功)
    	comfun.checkequal("修改成功",comfun.gettext("xpath","html/body/div[2]/div/span/div/div/div/span"));
    	Thread.sleep(3000);
    	//密码还原
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/input",dr.readnodevalue(params,"modifypwd","newpwd"));
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/input",dr.readnodevalue(params,"login","password"));
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div[3]/div/div/input",dr.readnodevalue(params,"login","password"));
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/input");
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ModifyPwd.png");
        comfun.teardown();
    }

}

