package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*个人资料-安全中心-修改密码(修改之后还原密码)*/


public class ModifyPwd extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeTest
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/ModifyPwd.xml");
		init("src/testdata/Data.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testmodifypwd(Document params) throws Exception {
           	
    	//登录
    	comfun.login(dr.readnodevalue(params,"ModifyPwd","cellphone"),dr.readnodevalue(params,"ModifyPwd","password"));
    	//点击用户名，切换到个人账户页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到安全中心页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"AccountPage","reset"));
    	Thread.sleep(3000);
    	//输入旧密码
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","oldpwd"),dr.readnodevalue(params,"ModifyPwd","password"));
    	//输入新密码
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","newpwd"),dr.readnodevalue(params,"ModifyPwd","newpwd"));
    	//重复新密码
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","repwd"),dr.readnodevalue(params,"ModifyPwd","newpwd"));
    	//保存修改
    	comfun.clickitem("xpath",dr.readnodevalue(params,"ResetPage","save"));
    	//验证
    	Thread.sleep(1000);
    	comfun.checkequal(dr.readnodevalue(params,"ModifyPwd","tips"),comfun.gettext("xpath",dr.readnodevalue(params,"ResetPage","tips")));
    	
    	//密码还原
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","oldpwd"),dr.readnodevalue(params,"ModifyPwd","newpwd"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","newpwd"),dr.readnodevalue(params,"ModifyPwd","password"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","repwd"),dr.readnodevalue(params,"ModifyPwd","password"));
    	comfun.clickitem("xpath",dr.readnodevalue(params,"ResetPage","save"));
    	    	
    }

   
    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ModifyPwd.png");
        comfun.teardown();
    }

}

