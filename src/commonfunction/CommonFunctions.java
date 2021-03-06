package commonfunction;
//import java.util.HashSet;
//import java.util.Set;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;




public class CommonFunctions{
	
	public Document doc;
	public DataReader dr;
	public WebElement e;
	public WebDriver driver;
	public WebDriver getDriver(){
		return driver;
	}
	
	/*构造函数*/
	public CommonFunctions(){
		
	}
	
	
	public CommonFunctions(String url){
		
		/*//创建Firefox浏览器实例
		driver=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\work\\selenium\\tools\\chromedriver.exe");
		//driver= new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "D:\\work\\selenium\\tools\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);*/
				
	}
	
	/**
	 * 创建浏览器实例、设置数据源
	 * @throws Exception
	 */
	public void setup() throws Exception{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.get("http://test2.sui.me/");
		driver.get("http://beta.sui.me/");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr = new DataReader();
		//设置数据源
		init("src/testdata/Data.xml");
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
	* @param type 元素定位类型，如：xpath,css,name等
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
	* @param type 元素定位类型，如：xpath,css,name等
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
	* @param type 元素定位类型，如：xpath,css,name等
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
	* @param type 元素定位类型，如：xpath,css,name等
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
	* @param str1 期望值
	* @param str2 实际值
	*/
	public void checkequal(String str1,String str2){
		assertEquals(str1,str2);
	}
	
	/**
	 * 判断元素是否存在
	 * @param selector
	 * @return
	 */
	
	public boolean isElementExist(By locator) { 
        /*try { 
              driver.findElement(selector); 
              return true; 
        } catch (NoSuchElementException e) { 
              return false; 
        } */
		boolean flag = false;
		try {  
            WebElement element=driver.findElement(locator);  
            flag=null!=element;  
        } catch (NoSuchElementException e) {  
            System.out.println("Element:" + locator.toString()  
                    + " is not exsit!");  
        }  
        return flag;  
    }
	
	/**
	 * 鼠标悬停操作
	 */
	public void moveToElement(By locator){
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElement(locator)).perform();
	}
	
	
	
	/**
	* 登录操作
	* @param name:用户名
	* @param psd:密码
	* @throws Exception
	*/
	public void login(String name,String pwd) throws Exception{
		
		clickitem("xpath", ".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a");//点击首页的登录按钮
        Thread.sleep(3000);
		this.inputvalue("css", "div>input[type='text']", name);
		this.inputvalue("css", "div>input[type='password']", pwd);
		this.clickitem("classname", "button-block");
		Thread.sleep(3000);
		
	}
	
	/**
	 * 截图
	 * @param drivername
	 * @param filename
	 */
	public static void snapshot(TakesScreenshot drivername, String filename){
	           
	    String currentPath = System.getProperty("user.dir"); //get current work folder
	    System.out.println(currentPath);
	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	        // Now you can do whatever you need to do with it, for example copy somewhere
	        try {
	            System.out.println("截图目录是:"+currentPath+"\\src\\images\\"+filename);
	            FileUtils.copyFile(scrFile, new File(currentPath+"\\src\\images\\"+filename));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println(" 截图失败！");
	            e.printStackTrace();
	        } 
	        finally
	        {
	           
	            System.out.println("screen shot finished");
	        }
	  }
	
	/**
	 * 隐式等待
	 * @param by
	 * @param time
	 * @return
	 */
	
	public boolean isByElementDisplayed(By by, int time) {
	    boolean status = false;
	    if (driver.findElement(by).isDisplayed() == false) {
	        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	    } else {
	        status = true;
	    }
	    return status;
	}
	
		
	/**
	 * 显式等待
	 * @param by
	 * @param time
	 */
	
	public void waitelement(By by,long time){
		new WebDriverWait(driver,time).until(ExpectedConditions.presenceOfElementLocated(by)).click();
	}
	
	
	/**
	 * 显式等待2
	 * @param by
	 * @param time
	 */
	
	public void waitxs(final By by,long time){
		
		WebDriverWait wait=new WebDriverWait(driver,time);
		e=wait.until(new ExpectedCondition<WebElement>(){
			@Override
			public WebElement apply(WebDriver d){
				return d.findElement(by);
			}
		});
			
	}
	
	/**
	 * 显示等待
	 * @param time
	 * @param by
	 * @return
	 */
	
	/*public static WebElement waitForelement(long time,By by){
		
		WebElement targetElement=(new WebDriverWait(driver,time)).until(ExpectedConditions.presenceOfElementLocated(by));
		return targetElement;
		
	}*/
	
    public  WebElement waitForelement(long time,By by){
		
		WebElement targetElement=(new WebDriverWait(driver,time)).until(ExpectedConditions.presenceOfElementLocated(by));
		return targetElement;
		
	}
	
	/**
	 * 检测页面title
	 * @param time
	 * @param title
	 * @return
	 */
	public  Boolean waitTitleis(long time,String title){
		
		WebDriverWait wait=new WebDriverWait(driver,time);
		Boolean element=wait.until(ExpectedConditions.titleIs(title));		
		return element;
		
	}
	
	/**
	 * 检查标题包含一个区分大小写的子字符串
	 * @param time
	 * @param title
	 * @return
	 */
	public Boolean waittitleContains(long time,String title){
		
		WebDriverWait wait=new WebDriverWait(driver,time);
		Boolean element=wait.until(ExpectedConditions.titleContains(title));
		return element;
		
	}
	
	/**
	 * 检查一个元素出现在页面的DOM，元素不一定可见
	 * @param time
	 * @param locator
	 * @return
	 */
	public WebElement waitpresenceOfElementLocated(long time,By locator){
		
		WebDriverWait wait=new WebDriverWait(driver,time);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
		
	}
	
	/**
	 * 检查一个元素出现在页面的DOM,并且可见
	 * @param time
	 * @param locator
	 * @return
	 */
	public WebElement waitvisibilityOfElementLocated(long time,By locator){
		
		WebDriverWait wait=new WebDriverWait(driver,time);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
			
	}
	
	/**
	 * 检查一个元素,出现在页面的DOM,是可见的
	 * @param time
	 * @param locator
	 * @return
	 */
	public WebElement waitvisibilityOf(long time,By locator){
		
		WebDriverWait wait=new WebDriverWait(driver,time);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		return element;
		
	}
	
	/**
	 * 提供数据源
	 * @param filename
	 * @throws Exception
	 */
	public void init(String filename) throws Exception{
	    File inputXml = new File(new File(filename).getAbsolutePath());
	    // documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
	    DocumentBuilder db = null;
	    DocumentBuilderFactory dbf = null;
	    try {
	        // 返回documentBuilderFactory对象
	        dbf = DocumentBuilderFactory.newInstance();
	        // 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
	        db = dbf.newDocumentBuilder();
	        // 得到一个DOM并返回给document对象
	        doc = (Document)db.parse(inputXml);
	        }
	        catch (Exception e) {
	             e.printStackTrace();
	        }
	  }
	
	 @DataProvider(name="Test_xml_dataprovider")
	 public Object[][] providerMethod(Method method){
	       return new Object[][]{new Object[]{doc}};
	 }
	


	

}
