package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*个人资料-安全中心-修改密码(修改之后还原密码)*/


public class ModifyPwd extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
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
    	comfun.login("13988880005","123456");
    	//点击用户名，切换到个人账户页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到安全中心页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"AccountPage","reset"));
    	Thread.sleep(3000);
    	//输入旧密码
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","oldpwd"),"123456");
    	//输入新密码
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","newpwd"),"1234567");
    	//重复新密码
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","repwd"),"1234567");
    	//保存修改
    	comfun.clickitem("xpath",dr.readnodevalue(params,"ResetPage","save"));
    	//验证
    	Thread.sleep(1000);
    	comfun.checkequal("修改成功",comfun.gettext("xpath",dr.readnodevalue(params,"ResetPage","tips")));
    	
    	//密码还原
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","oldpwd"),"1234567");
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","newpwd"),"123456");
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"ResetPage","repwd"),"123456");
    	comfun.clickitem("xpath",dr.readnodevalue(params,"ResetPage","save"));
    	    	
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

