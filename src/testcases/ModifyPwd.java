package testcases;

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

/*个人资料-安全中心-修改密码(修改之后还原密码)*/

@Listeners({DotTestListener.class})
public class ModifyPwd extends CommonFunctions {
	
	/*public CommonFunctions comfun;
	public DataReader dr;*/
	
	@BeforeClass
	public void before() throws Exception {
		/*String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/ModifyPwd.xml");
		init("src/testdata/Data.xml");*/
		setup();
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testmodifypwd(Document params) throws Exception {
           	
    	//登录
    	login(dr.readnodevalue(params,"ModifyPwd","cellphone"),dr.readnodevalue(params,"ModifyPwd","password"));
    	//点击用户名，切换到个人账户页面
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到安全中心页面
    	clickitem("xpath",dr.readnodevalue(params,"AccountPage","reset"));
    	Thread.sleep(3000);
    	//输入旧密码
    	inputvalue("xpath",dr.readnodevalue(params,"ResetPage","oldpwd"),dr.readnodevalue(params,"ModifyPwd","password"));
    	//输入新密码
    	inputvalue("xpath",dr.readnodevalue(params,"ResetPage","newpwd"),dr.readnodevalue(params,"ModifyPwd","newpwd"));
    	//重复新密码
    	inputvalue("xpath",dr.readnodevalue(params,"ResetPage","repwd"),dr.readnodevalue(params,"ModifyPwd","newpwd"));
    	//保存修改
    	clickitem("xpath",dr.readnodevalue(params,"ResetPage","save"));
    	//验证
    	Thread.sleep(1000);
    	checkequal(dr.readnodevalue(params,"ModifyPwd","tips"),gettext("xpath",dr.readnodevalue(params,"ResetPage","tips")));
    	
    	//密码还原
    	inputvalue("xpath",dr.readnodevalue(params,"ResetPage","oldpwd"),dr.readnodevalue(params,"ModifyPwd","newpwd"));
    	inputvalue("xpath",dr.readnodevalue(params,"ResetPage","newpwd"),dr.readnodevalue(params,"ModifyPwd","password"));
    	inputvalue("xpath",dr.readnodevalue(params,"ResetPage","repwd"),dr.readnodevalue(params,"ModifyPwd","password"));
    	clickitem("xpath",dr.readnodevalue(params,"ResetPage","save"));
    	    	
    }

   
    @AfterClass
    public void afterClass() {
    	/**
  	   * 截图、退出浏览器
  	   */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ModifyPwd.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"ModifyPwd.png");
    	teardown();
    }

}

