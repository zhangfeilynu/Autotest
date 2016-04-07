package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;

import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*修改个人资料*/


public class ModifyData extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr = new DataReader();
		//设置数据源
		init("src/testdata/ModifyData.xml");
	}
	
    @Test(dataProvider = "Test_xml_dataprovider")
    public void testmodify(Document params) throws Exception {
    	//登录
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a");
    	Thread.sleep(3000);
    	comfun.login(dr.readnodevalue(params,"login","username"),dr.readnodevalue(params,"login","password"));
    	//点击用户名
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[1]/nav/ul[2]/li/a");
    	Thread.sleep(3000);
    	//切换到修改个人资料页面
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[1]/div/div[3]/dl/dd[1]/a");
    	Thread.sleep(2000);
    	//修改姓名
    	comfun.clearvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/input");
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/input",dr.readnodevalue(params,"modify","cname"));
    	//修改用户名
    	comfun.clearvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/input");
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/input",dr.readnodevalue(params,"modify","uname"));
    	//修改邮箱
    	comfun.clearvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/input");
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/input",dr.readnodevalue(params,"modify","email"));
    	//修改学校
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div/i");
    	comfun.clickitem("xpath",dr.readnodevalue(params,"modify","school"));
    	//修改入学年份
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/i");
    	comfun.clickitem("xpath",dr.readnodevalue(params,"modify","year"));
    	//修改地址
    	comfun.clearvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[4]/div[1]/div/input");
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[4]/div[1]/div/input",dr.readnodevalue(params,"modify","address"));
    	//修改宿舍
    	comfun.clearvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[4]/div[2]/div/input");
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[4]/div[2]/div/input",dr.readnodevalue(params,"modify","room"));
    	//修改专业
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[5]/div[1]/div/i");
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"modify","major"));
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[5]/div[2]/div/i");
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"modify","major2"));
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[5]/div[3]/div/i");
    	Thread.sleep(1000);
    	comfun.clickitem("xpath",dr.readnodevalue(params,"modify","major3"));
    	//修改qq
    	comfun.clearvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div[1]/div[1]/div/input");
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div[1]/div[1]/div/input",dr.readnodevalue(params,"modify","qq"));
    	//性取向
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div[1]/div[2]/div/i");
    	comfun.clickitem("xpath",dr.readnodevalue(params,"modify","sex"));
    	//简介
    	comfun.clearvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div[2]/div/div/textarea");
    	comfun.inputvalue("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div[2]/div/div/textarea",dr.readnodevalue(params,"modify","info"));
    	//保存
    	comfun.clickitem("xpath",".//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/input");
    	Thread.sleep(8000);
    	
    }

  
  

    @AfterClass
    public void afterClass() throws Exception {
    	comfun.teardown();
    }

}
