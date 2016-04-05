package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;
import commonfunction.RandomValue;

/*注锟斤拷锟剿伙拷*/


public class Register extends DataProvide {
	
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
    	//输入用户名
    	comfun.inputvalue("name","nickName",dr.readnodevalue(params,"reg","nickName"));
    	//输入手机号（随机生成）
    	comfun.inputvalue("name","cellphone",RandomValue.getTel());
    	//输入密码
    	comfun.inputvalue("name","password",dr.readnodevalue(params,"reg","password"));
    	//输入图片验证码
    	comfun.inputvalue("name","imgVerifyCode",dr.readnodevalue(params,"reg","imgVerifyCode"));
    	//点击获取按钮，输入短信验证码
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[4]/div/div[2]/div/button");
    	comfun.inputvalue("name","verificationCode",dr.readnodevalue(params,"reg","verificationCode"));
    	//点击免费注册按钮
    	comfun.clickitem("classname","button-block");
    	Thread.sleep(3000);
    	//验证注册，跳转到打印页面 
    	comfun.checkequal(CommonFunctions.driver.getCurrentUrl(),dr.readnodevalue(params,"reg","checkpoint1"));
    
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	comfun.teardown();
    }

}
