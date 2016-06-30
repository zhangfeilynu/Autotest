package testcases;

import org.w3c.dom.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;
import commonfunction.DotTestListener;


/*文库demo*/
@Listeners({DotTestListener.class})
public class WenKu extends CommonFunctions{
     /*public CommonFunctions comfun;
     public DataReader dr;*/
  
     @BeforeClass
     public void beforeClass() throws Exception{
        /*String url = "http://test2.sui.me/";
        comfun=new CommonFunctions(url);
        dr=new DataReader();
        //设置数据源
        //init("src/testdata/Login.xml");
        init("src/testdata/Data.xml");*/
    	 setup();
     }
  
    @Test(dataProvider="Test_xml_dataprovider") 
    public void testlogin(Document params) throws Exception {
       
       //comfun.login(dr.readnodevalue(params,"Login","cellphone"),dr.readnodevalue(params,"Login","password"));
       //comfun.checkequal(dr.readnodevalue(params,"Login","checkpoint"),comfun.gettext("xpath",dr.readnodevalue(params,"HomePage","personal")));
       //登录
       login("15261672979","Suiyin888001");
       //切换到文库页面
       clickitem("xpath",dr.readnodevalue(params,"HomePage","library"));
       Thread.sleep(3000);
       clickitem("xpath",dr.readnodevalue(params,"WenkuPage","fork"));
       Thread.sleep(3000);
       //搜索四级文档
       inputvalue("xpath",dr.readnodevalue(params,"WenkuPage","text"),"四级");
       clickitem("xpath",dr.readnodevalue(params,"WenkuPage","search"));
       Thread.sleep(5000);
       //Actions action = new Actions(CommonFunctions.driver); 
       //action.clickAndHold(CommonFunctions.driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/md-whiteframe[1]/a/div/img")));
       //鼠标移至第一篇文档上方悬停
       moveToElement(By.xpath("html/body/div[1]/div[2]/div[2]/md-whiteframe[1]/a/div/img"));
       Thread.sleep(3000);
       //点击第一个文档上的分享按钮 
       clickitem("xpath","html/body/div[1]/div[2]/div[2]/md-whiteframe[1]/div[2]/h4/a[1]/span");
       Thread.sleep(8000);
       //验证
       inputvalue("xpath",".//*[@id='ngdialog1-aria-labelledby']","分享到各大社区");
       
       
    
    }
  
    @AfterClass
    public void afterClass() {
    	/**
    	 *截图、退出浏览器
    	 */
    	//CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"WenKu.png");
    	//CommonFunctions.snapshot((TakesScreenshot)comfun.driver,"WenKu.png");
    	teardown();
  }
}