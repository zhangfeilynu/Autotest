package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;


/*登录之后，上传文档，结算下单*/

public class TTT extends DataProvide {
	
	public WebDriver driver;
	public DataReader dr;
	
  
	@BeforeTest
	public void beforeClass() throws Exception {
		//打开网页
		String url="http://test2.sui.me/";
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		dr=new DataReader();
		//设置数据源
		//init("src/testdata/Order.xml");
		init("src/testdata/Data.xml");
	}
	
	@Test(dataProvider = "Test_xml_dataprovider")
    public void testorder(Document params)throws Exception {
		
		driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a")).click();
		driver.findElement(By.cssSelector("div>input[type='text']")).sendKeys("15261672979");
		driver.findElement(By.cssSelector("div>input[type='password")).sendKeys("1234567");
		driver.findElement(By.className("button-block")).click();
		driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/nav/ul[1]/li[2]/a")).click();//打印
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
		driver.findElement(By.xpath(">.//*[@id='app']/div/div[2]/div[2]/div[1]/div[1]/div/input")).sendKeys("F:\\testfiles\\测试文件5.pdf");
		driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[4]/button")).click();
		Thread.sleep(10000);
		
		
		
    }

 
 

    @AfterTest
    public void afterClass()throws Exception {
    	/**
  	   * 截图、退出浏览器
  	   */
    	CommonFunctions.snapshot((TakesScreenshot)CommonFunctions.driver,"TTT.png");
    	driver.quit();
    }

}
