package testcases;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*修改个人资料*/


public class ModifyData extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeTest
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/ModifyData.xml");
		init("src/testdata/Data.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testmodifydata(Document params) throws Exception {
    	    	
    	//登录
    	comfun.login("13988880003","123456");
    	//点击用户名，切换到个人账户页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到个人资料页面
    	comfun.clickitem("xpath",dr.readnodevalue(params,"AccountPage","info"));
    	Thread.sleep(3000);
    	//修改图像(取消控件的隐藏属性)
    	((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
    	comfun.inputvalue("css",dr.readnodevalue(params,"InfoPage","photo"),"F:\\testfiles\\P5123511.JPG");
    	Thread.sleep(8000);
    	//修改姓名
    	comfun.clearvalue("xpath",dr.readnodevalue(params,"InfoPage","realname"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"InfoPage","realname"),"测试用户");
    	//修改用户名
    	comfun.clearvalue("xpath",dr.readnodevalue(params,"InfoPage","username"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"InfoPage","username"),"ModifyData");
    	//修改邮箱
    	comfun.clearvalue("xpath",dr.readnodevalue(params,"InfoPage","email"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"InfoPage","email"),"test@sui.me");
    	//修改学校
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropschool"));
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","school"));
    	//选择入学年份
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropyear"));
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","year"));
    	//修改楼栋
    	comfun.clearvalue("xpath",dr.readnodevalue(params,"InfoPage","dorm"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"InfoPage","dorm"),"西校区男1宿舍楼");
    	//修改寝室
    	comfun.clearvalue("xpath",dr.readnodevalue(params,"InfoPage","room"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"InfoPage","room"),"610");
    	//修改地址
    	comfun.clearvalue("xpath",dr.readnodevalue(params,"InfoPage","address"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"InfoPage","address"),"东方路1号");
    	//修改专业
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropmajor1"));
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","major1"));
    	
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropmajor2"));
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","major2"));
    	
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropmajor3"));
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","major3"));
    	//修改qq
    	comfun.clearvalue("xpath",dr.readnodevalue(params,"InfoPage","qq"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"InfoPage","qq"),"121404901");
    	//性取向
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropsex"));
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","sex"));
    	//修改简介
    	comfun.clearvalue("xpath",dr.readnodevalue(params,"InfoPage","about"));
    	comfun.inputvalue("xpath",dr.readnodevalue(params,"InfoPage","about"),"自动化测试用户");
    	//保存修改
    	comfun.clickitem("xpath",dr.readnodevalue(params,"InfoPage","save"));
    	//验证修改
    	Thread.sleep(1000);
    	comfun.checkequal("提交成功",comfun.gettext("xpath",dr.readnodevalue(params,"InfoPage","tips")));
       	
    }
  

    @AfterTest
    public void afterClass() throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ModifyData.png");
    	comfun.teardown();
    }

}
