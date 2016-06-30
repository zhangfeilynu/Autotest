package testcases;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

/*修改个人资料*/

@Listeners({DotTestListener.class})
public class ModifyData extends CommonFunctions {
	
	/*public CommonFunctions comfun;
	public DataReader dr;*/
	
	@BeforeClass
	public void beforeClass() throws Exception {
		/*String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		//init("src/testdata/ModifyData.xml");
		init("src/testdata/Data.xml");*/
		setup();
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testmodifydata(Document params) throws Exception {
    	    	
    	//登录
    	login(dr.readnodevalue(params,"ModifyData","cellphone"),dr.readnodevalue(params,"ModifyData","password"));
    	//点击用户名，切换到个人账户页面
    	clickitem("xpath",dr.readnodevalue(params,"HomePage","personal"));
    	Thread.sleep(3000);
    	//切换到个人资料页面
    	clickitem("xpath",dr.readnodevalue(params,"AccountPage","info"));
    	Thread.sleep(3000);
    	//修改图像(取消控件的隐藏属性)
    	//((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
    	((JavascriptExecutor)driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
    	inputvalue("css",dr.readnodevalue(params,"InfoPage","photo"),dr.readnodevalue(params,"ModifyData","photo"));
    	Thread.sleep(8000);
    	//修改姓名
    	clearvalue("xpath",dr.readnodevalue(params,"InfoPage","realname"));
    	inputvalue("xpath",dr.readnodevalue(params,"InfoPage","realname"),dr.readnodevalue(params,"ModifyData","realname"));
    	//修改用户名
    	clearvalue("xpath",dr.readnodevalue(params,"InfoPage","username"));
    	inputvalue("xpath",dr.readnodevalue(params,"InfoPage","username"),dr.readnodevalue(params,"ModifyData","username"));
    	//修改邮箱
    	clearvalue("xpath",dr.readnodevalue(params,"InfoPage","email"));
    	inputvalue("xpath",dr.readnodevalue(params,"InfoPage","email"),dr.readnodevalue(params,"ModifyData","email"));
    	//修改学校
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropschool"));
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","school"));
    	//选择入学年份
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropyear"));
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","year"));
    	//修改楼栋
    	clearvalue("xpath",dr.readnodevalue(params,"InfoPage","dorm"));
    	inputvalue("xpath",dr.readnodevalue(params,"InfoPage","dorm"),dr.readnodevalue(params,"ModifyData","dorm"));
    	//修改寝室
    	clearvalue("xpath",dr.readnodevalue(params,"InfoPage","room"));
    	inputvalue("xpath",dr.readnodevalue(params,"InfoPage","room"),dr.readnodevalue(params,"ModifyData","room"));
    	//修改地址
    	clearvalue("xpath",dr.readnodevalue(params,"InfoPage","address"));
    	inputvalue("xpath",dr.readnodevalue(params,"InfoPage","address"),dr.readnodevalue(params,"ModifyData","address"));
    	//修改专业
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropmajor1"));
    	Thread.sleep(1000);
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","major1"));
    	
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropmajor2"));
    	Thread.sleep(1000);
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","major2"));
    	
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropmajor3"));
    	Thread.sleep(1000);
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","major3"));
    	//修改qq
    	clearvalue("xpath",dr.readnodevalue(params,"InfoPage","qq"));
    	inputvalue("xpath",dr.readnodevalue(params,"InfoPage","qq"),dr.readnodevalue(params,"ModifyData","qq"));
    	//性取向
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","dropsex"));
    	Thread.sleep(1000);
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","sex"));
    	//修改简介
    	clearvalue("xpath",dr.readnodevalue(params,"InfoPage","about"));
    	inputvalue("xpath",dr.readnodevalue(params,"InfoPage","about"),dr.readnodevalue(params,"ModifyData","about"));
    	//保存修改
    	clickitem("xpath",dr.readnodevalue(params,"InfoPage","save"));
    	//验证修改
    	Thread.sleep(1000);
    	checkequal(dr.readnodevalue(params,"ModifyData","tips"),gettext("xpath",dr.readnodevalue(params,"InfoPage","tips")));
       	
    }
  

    @AfterClass
    public void afterClass() {
    	/**
  	   * 截图、退出浏览器
  	   */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"ModifyData.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"ModifyData.png");
    	teardown();
    }

}
