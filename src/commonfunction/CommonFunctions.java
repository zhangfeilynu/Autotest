package commonfunction;
//import java.util.HashSet;
//import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;


public class CommonFunctions {
	/*程序公用函数*/
	static public WebDriver driver;
	
	/*构造函数*/
	public CommonFunctions(){
		
	}
	
	public CommonFunctions(String url){
		//创建Firefox浏览器实例
		//System.setProperty("webdriver.chrome.driver", "D:\\work\\selenium\\tools\\chromedriver.exe");
		//driver= new ChromeDriver();
		driver=new FirefoxDriver();
		//System.setProperty("webdriver.ie.driver", "D:\\work\\selenium\\tools\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	/*打开网页
	@param url 要打开的URL
	@throws Exception*/
	public void geturl(String url) throws Exception
	{
		driver.get(url);
		Thread.sleep(3000);		
	}
	
	/*退出浏览器*/
	public void teardown(){
		try{
			driver.quit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	* 获取页面标签
	* @param type 元素定位类型，如：Xpath,css,name等
	* @param location 元素位置
	* @return 返回获取到的页面元素的文本
	*/
	public String gettext(String type,String location)
	{
		WebElement elem=null;
		if(type.equals("xpath")){
			elem=driver.findElement(By.xpath(location));			
		}
		
		if(type.equals("name")){
			elem=driver.findElement(By.name(location));
		}
		
		if(type.equals("id")){
			elem=driver.findElement(By.id(location));			
		}
		
		if(type.equals("classname")){
			elem=driver.findElement(By.className(location));			
		}
		
		if(type.equals("css")){
			elem=driver.findElement(By.cssSelector(location));		
		}
		
		if(type.equals("text")){
			elem=driver.findElement(By.linkText(location));		
		}
		
		return elem.getText();
    }
	
	/**
	* 单击某个元素
	* @param type 元素定位类型，如：Xpath,css,name等
	* @param location 元素位置
	*/
	public void clickitem(String type,String location){
		
		WebElement elem=null;
		if(type.equals("xpath")){
			elem=driver.findElement(By.xpath(location));			
		}
		
		if(type.equals("name")){
			elem=driver.findElement(By.name(location));
		}
		
		if(type.equals("id")){
			elem=driver.findElement(By.id(location));			
		}
		
		if(type.equals("classname")){
			elem=driver.findElement(By.className(location));			
		}
		
		if(type.equals("css")){
			elem=driver.findElement(By.cssSelector(location));		
		}
		
		if(type.equals("text")){
			elem=driver.findElement(By.linkText(location));		
		}
		
		elem.click();
	}
	
	/**
	* 清除文本框中的内容
	* @param type 元素定位类型，如：Xpath,css,name等
	* @param location 元素位置
	*/
	public void clearvalue(String type,String location){
		WebElement elem=null;
		if(type.equals("xpath")){
			elem=driver.findElement(By.xpath(location));			
		}
		
		if(type.equals("name")){
			elem=driver.findElement(By.name(location));
		}
		elem.clear();		
	}
	
	/**
	* 向文本框中输入文字
	* @param type 元素定位类型，如：Xpath,css,name等
	* @param location 元素位置
	* @param text 要输入的内容
	*/
	public void inputvalue(String type,String location,String text){
		WebElement elem=null;
		if(type.equals("xpath")){
			elem=driver.findElement(By.xpath(location));			
		}
		
		if(type.equals("name")){
			elem=driver.findElement(By.name(location));
		}
		
		if(type.equals("id")){
			elem=driver.findElement(By.id(location));			
		}
		
		if(type.equals("classname")){
			elem=driver.findElement(By.className(location));			
		}
		
		if(type.equals("css")){
			elem=driver.findElement(By.cssSelector(location));		
		}
		
		if(type.equals("text")){
			elem=driver.findElement(By.linkText(location));		
		}
		
		elem.sendKeys(text);
	}
	
	/**
	* 判断str1和str2是否相等
	* @param str1 源字符串
	* @param str2 目标字符串
	*/
	public void checkequal(String str1,String str2){
		assertEquals(str1,str2);
	}
	
	/**
	* 登录操作
	* @param name:用户名
	* @param psd:密码
	* @throws Exception
	*/
	public void login(String name,String psd) throws Exception{
		this.inputvalue("css", "div>input[type='text']", name);
		this.inputvalue("css", "div>input[type='password']", psd);
		this.clickitem("classname", "button-block");
		Thread.sleep(3000);
		
	}
	
		

}
