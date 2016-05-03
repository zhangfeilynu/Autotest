package testcases;


import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;
import commonfunction.HttpRequest;
//import commonfunction.RandomValue;

//免费注册

public class Register extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeTest
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/Register.xml");
		init("src/testdata/Data.xml");
		
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testreg(Document params) throws Exception {
    	  	
    	//删除上次注册的手机号
    	HttpRequest.sendPost(dr.readnodevalue(params,"Register","post"));    	
    	//输入用户名
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","username"),dr.readnodevalue(params,"Register","username"));
    	//输入随机手机号
    	//comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),RandomValue.getTel());
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","cellphone"),dr.readnodevalue(params,"Register","cellphone"));
    	//输入密码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","password"),dr.readnodevalue(params,"Register","password"));
    	//输入图形验证码
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","imgVerifyCode"),dr.readnodevalue(params,"Register","imgVerifyCode"));
    	//点击获取按钮，输入短信验证码
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","obtain"));
    	comfun.inputvalue("name",dr.readnodevalue(params,"HomePage","verificationCode"),dr.readnodevalue(params,"Register","verificationCode"));
    	//点击免费注册按钮
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","submit"));
    	//验证注册，跳转到打印页面
    	//Thread.sleep(3000);
    	//comfun.checkequal("http://print.test2.sui.me/",CommonFunctions.driver.getCurrentUrl());
    	//注册成功提示
    	Thread.sleep(1000);
    	comfun.checkequal(dr.readnodevalue(params,"Register","tips"),comfun.gettext("xpath",dr.readnodevalue(params,"HomePage","tips2")));
            	
    }

   

    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"Register.png");
    	comfun.teardown();
    }

}
