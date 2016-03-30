package commonfunction;
//import java.util.HashSet;
//import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;


public class CommonFunctions {
	/*�����ú���*/
	static public WebDriver driver;
	
	/*���캯��*/
	public CommonFunctions(){
		
	}
	
	public CommonFunctions(String url){
		//����Firefox�����ʵ��
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	/*����ҳ
	@param url Ҫ�򿪵�URL
	@throws Exception*/
	public void geturl(String url) throws Exception
	{
		driver.get(url);
		Thread.sleep(3000);		
	}
	
	/*�˳������*/
	public void teardown(){
		try{
			driver.quit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	* ��ȡҳ���ǩ
	* @param type Ԫ�ض�λ���ͣ��磺Xpath,css,name��
	* @param location Ԫ��λ��
	* @return ���ػ�ȡ����ҳ��Ԫ�ص��ı�
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
	* ����ĳ��Ԫ��
	* @param type Ԫ�ض�λ���ͣ��磺Xpath,css,name��
	* @param location Ԫ��λ��
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
	* ����ı����е�����
	* @param type Ԫ�ض�λ���ͣ��磺Xpath,css,name��
	* @param location Ԫ��λ��
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
	* ���ı�������������
	* @param type Ԫ�ض�λ���ͣ��磺Xpath,css,name��
	* @param location Ԫ��λ��
	* @param text Ҫ���������
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
	* �ж�str1��str2�Ƿ����
	* @param str1 Դ�ַ���
	* @param str2 Ŀ���ַ���
	*/
	public void checkequal(String str1,String str2){
		assertEquals(str1,str2);
	}
	
	/**
	* ��¼����
	* @param name:�û���
	* @param psd:����
	* @throws Exception
	*/
	public void login(String name,String psd) throws Exception{
		this.inputvalue("css", "div>input[type='text']", name);
		this.inputvalue("css", "div>input[type='password']", psd);
		this.clickitem("classname", "button-block");
		Thread.sleep(3000);
		
	}
	
		

}
